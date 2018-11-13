package dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
private static String path;
public static final ConnectionPool INSTANCE = new ConnectionPool();

    public  Connection getConnection(){
        InitialContext initContext= null;
        Connection conn= null;
        try {
            initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/pet");
            conn = ds.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static ConnectionPool getInstance() {
        return INSTANCE;
    }
}
//"java:comp/env/jdbc/pet"