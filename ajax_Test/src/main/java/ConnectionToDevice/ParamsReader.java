package ConnectionToDevice;


import Entity.Device;
import Entity.Holder;
import net.wimpi.modbus.ModbusException;
import net.wimpi.modbus.io.ModbusTCPTransaction;
import net.wimpi.modbus.msg.ReadMultipleRegistersRequest;
import net.wimpi.modbus.msg.ReadMultipleRegistersResponse;
import net.wimpi.modbus.net.TCPMasterConnection;

import java.net.InetAddress;
import java.util.*;

public class ParamsReader {
    private TCPMasterConnection con = null;
    private List<Device> values;
    private List<Device> words;
    private List<Device> info;

    public Map<String, List<Device>> CheckValues(HashMap map, TCPMasterConnection con) {
        HashMap<String, List<Device>> params = new HashMap<>();
        values = new ArrayList<>();
        words = new ArrayList<>();
        info = new ArrayList<>();
        String key;

        Iterator<Map.Entry<String, String>> iterator = ((HashMap<String, String>) map).entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            key = entry.getKey().toString();
            ReadMultipleRegistersResponse response = getResponse(con, key);
            chooseType(entry,response);
            Holder.addToMap(String.valueOf(entry.getValue()),String.valueOf(response.getRegisterValue(0)));
        }
        params.put("values", values);
        params.put("words", words);
        params.put("info",info);
        return params;
    }
    private void chooseType(Map.Entry<String,String> entry,  ReadMultipleRegistersResponse response){
        String key = entry.getKey();
        if (isVal(key)) {
            if(isInfo(key)){
                info.add(new Device(String.valueOf(entry.getValue()), String.valueOf(response.getRegisterValue(0))));
            }else  {
                values.add(new Device(String.valueOf(entry.getValue()), String.valueOf(response.getRegisterValue(0))));
            }
        } else {
            if(isInfo(key)){
                info.add(new Device(String.valueOf(entry.getValue()), Integer.toString(response.getRegisterValue(0), 2)));
            }else {
                words.add(new Device(String.valueOf(entry.getValue()), Integer.toString(response.getRegisterValue(0), 2)));
            }
        }
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
    private boolean isInfo(String param){
        return param.contains("info:");
    }

    public TCPMasterConnection GetConnection() {
        if (con.isConnected()) {
            return con;
        } else return null;
    }

}

