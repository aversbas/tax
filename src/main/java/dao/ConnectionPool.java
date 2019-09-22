package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by alexm on 08.09.2019.
 */
public class ConnectionPool {
    private ConnectionPool() {
    }

    private static ConnectionPool instance = null;

    public static ConnectionPool getInstance() {
        if (instance == null)
            instance = new ConnectionPool();
        return instance;
    }

    public Connection getConnection() {
        Context ctx;
        Connection connection = null;
        try {
            ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/jdbccp");
            connection = ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
