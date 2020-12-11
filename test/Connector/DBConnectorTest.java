package Connector;

import java.sql.Connection;

import static org.junit.Assert.*;

public class DBConnectorTest {

    @org.junit.Test
    public void getMyConnection() {
        IDBConnector dbc = new DBConnector();
        Connection connection = dbc.getMyConnection();
        assertNotNull(connection);
    }
}