package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector implements IDBConnector {

    public Connection getMyConnection() {
        Connection connection = null;
        String urlSettings = "?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        String url = "jdbc:mysql://localhost:3306/delfinsp5";
        String user = "root";
        String password = "root123";

        try {
            connection = DriverManager.getConnection(url + urlSettings, user, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
