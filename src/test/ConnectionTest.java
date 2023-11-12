/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.GetConnection;

/**
 *
 * @author maya1
 */
public class ConnectionTest {
    private static String name;
    private static String password;
    private static String url;

    @BeforeClass
    public static void loadKey() throws IOException {
        Properties properties = new Properties();
        properties.load(ConnectionTest.class.getResourceAsStream("test.properties"));
        name = properties.getProperty("username");
        password = properties.getProperty("password");
        url = properties.getProperty("url");
    }

    @Test
    public void testSuccessfulLoadFromProperties() {
        assertEquals("root", name);
    }

    @Test
    public void testDbConnection() throws SQLException {
        assertNotNull(DriverManager.getConnection(url, name, password));
    }

    @Test
    public void testSingletonConnection() throws SQLException {
        GetConnection gc = GetConnection.getInstance();
        assertNotNull(gc.getConnection());
    }
}
