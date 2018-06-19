package ConnectionToDevice;

import Entity.Device;
import net.wimpi.modbus.ModbusException;
import net.wimpi.modbus.io.ModbusTCPTransaction;
import net.wimpi.modbus.msg.ReadInputRegistersRequest;
import net.wimpi.modbus.msg.ReadInputRegistersResponse;
import net.wimpi.modbus.msg.ReadMultipleRegistersRequest;
import net.wimpi.modbus.msg.ReadMultipleRegistersResponse;
import net.wimpi.modbus.net.TCPMasterConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.*;

public class Test_Read {


    TCPMasterConnection con = null;
    ModbusTCPTransaction trans = null;
    ReadMultipleRegistersRequest request = null;
    ReadMultipleRegistersResponse response = null;
    ReadInputRegistersRequest readInputRegistersRequest = null;
    ReadInputRegistersResponse readInputRegistersResponse = null;
    InetAddress addr = null;
    final int port = 502;
    HashMap map_values = null;
    HashMap response_map = null;

Device device;

    public List CheckValues(HashMap map, TCPMasterConnection con, HttpServletRequest Httprequest)  {
        synchronized (Httprequest){

        //map_values = new HashMap();
        List list = new ArrayList();
        response_map = map;
        System.out.println("Fresh map is come" + response_map);
        Iterator iterator = response_map.entrySet().iterator();
        while (iterator.hasNext()) {
            try {

                Map.Entry entry = (Map.Entry) iterator.next();
                request = new ReadMultipleRegistersRequest(Integer.parseInt((String) entry.getKey()), 1);

                trans = new ModbusTCPTransaction(con);
                trans.setRequest(request);
                trans.setRetries(10);
                trans.execute();

                response = (ReadMultipleRegistersResponse) trans.getResponse();
                System.out.println(response.getRegisterValue(0));

               // map_values.put(String.valueOf(entry.getValue()), String.valueOf(response.getRegisterValue(0)));
                list.add(new Device(String.valueOf(entry.getValue()),String.valueOf(response.getRegisterValue(0))));

            } catch (ModbusException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}




    public void ConnctionTo(String addres) throws Exception {
        addr = InetAddress.getByName(addres);
        con = new TCPMasterConnection(addr);
        con.setPort(502);
        con.setTimeout(1000);
        con.getTimeout();
        con.connect();
    }

    public void Disconnect(TCPMasterConnection con){
            if(this.con.isConnected()){
                con.close();
            } else System.out.println("Нет подключения");
    }

        public TCPMasterConnection GetConnection(){
            if(con.isConnected()){
                return con;
            }
            else return null;
        }

}

