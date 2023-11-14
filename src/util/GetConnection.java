package util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class GetConnection {

        private static GetConnection instance;
        private Connection connection;

        private GetConnection() {
            Properties mySql = new Properties();
            try (FileReader in = new FileReader("database.properties")) {
                mySql.load(in);
            } catch (IOException e) {
                System.out.println("Error loading db.properties from classpath." + e);
            }
            String username = mySql.getProperty("username");
            String password = mySql.getProperty("password");
            String url = mySql.getProperty("url");
            try {
                this.connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                System.out.println("Error connecting to the database." + e);
            }
        }

        public Connection getConnection() {
            return connection;
        }

        public static GetConnection getInstance() {
            if (instance == null) {
                instance = new GetConnection();
            }
            return instance;
        }  
        
        

        public void StudLogin(String ID, String Name, String Email, String Pass) {
        String query = "INSERT INTO Student (ID, Name, Email, Pass) VALUES (?, ?, ?, ?);";
        PreparedStatement pStat;

        try {
            pStat = connection.prepareStatement(query);

            pStat.setString(1, ID);
            pStat.setString(2, Name);
            pStat.setString(3, Email);
            pStat.setString(4, Pass);
            pStat.executeUpdate();

            System.out.println("Inserting Works");

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}