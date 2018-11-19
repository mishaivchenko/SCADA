package ConnectionToDevice;


import Entity.Device;
import net.wimpi.modbus.ModbusException;
import net.wimpi.modbus.io.ModbusTCPTransaction;
import net.wimpi.modbus.msg.ReadMultipleRegistersRequest;
import net.wimpi.modbus.msg.ReadMultipleRegistersResponse;
import net.wimpi.modbus.net.TCPMasterConnection;

import java.net.InetAddress;
import java.util.*;

public class ParamsReader {
    private TCPMasterConnection con = null;

    public Map<String, List<Device>> CheckValues(HashMap map, TCPMasterConnection con) {
        HashMap<String, List<Device>> params = new HashMap<>();
        List<Device> values = new ArrayList<>();
        List<Device> words = new ArrayList<>();
        String key;

        Iterator iterator = ((HashMap<String, String>) map).entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            key = entry.getKey().toString();
            ReadMultipleRegistersResponse response = getResponse(con, key);
            if (isVal((String) entry.getKey())) {
                values.add(new Device(String.valueOf(entry.getValue()), String.valueOf(response.getRegisterValue(0))));
            } else {
                words.add(new Device(String.valueOf(entry.getValue()), Integer.toString(response.getRegisterValue(0), 2)));
            }

        }
        params.put("values", values);
        params.put("words", words);
        return params;
    }

    public void ConnctionTo(String addres) throws Exception {
        InetAddress addr = InetAddress.getByName(addres);
        con = new TCPMasterConnection(addr);
        con.setPort(502);
        con.setTimeout(1000);
        con.getTimeout();
        con.connect();
    }

    private ReadMultipleRegistersResponse getResponse(TCPMasterConnection con, String key) {
        ReadMultipleRegistersRequest request = new ReadMultipleRegistersRequest(Integer.parseInt(key.substring(key.lastIndexOf(":") + 1)), 1);
        ModbusTCPTransaction trans = new ModbusTCPTransaction(con);
        trans.setRequest(request);
        trans.setRetries(10);
        try {
            trans.execute();
        } catch (ModbusException e) {
            e.printStackTrace();
        }
        return (ReadMultipleRegistersResponse) trans.getResponse();
    }

    private boolean isVal(String param) {
        return param.contains("val:");
    }

    public TCPMasterConnection GetConnection() {
        if (con.isConnected()) {
            return con;
        } else return null;
    }

}

