package util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
// import util.GetConnection;

public class Operation {

    // public Operation(){
        // }
        
        public void SignUp(String Name, String Email, String Pass, String Type) {
        GetConnection connection = GetConnection.getInstance();

        String query = "";

        if (Type == "Stud") {
            query = "INSERT INTO Student (`Name`, `Email`, `Password`) VALUES (?, ?, ?);";
        } else if (Type == "Teach") {
            query = "INSERT INTO Teacher (`Name`, `Email`, `Password`) VALUES (?, ?, ?);";
        }

        PreparedStatement pStat;

        try {

            pStat = connection.getConnection().prepareStatement(query);

            pStat.setString(1, Name);
            pStat.setString(2, Email);
            pStat.setString(3, Pass);
            pStat.executeUpdate();

            System.out.println("Inserting Works");

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void SignIn(String ID, String Pass, String Type) {
        GetConnection connection = GetConnection.getInstance();

        String query = "";

        if (Type == "Stud") {
            query = "INSERT INTO Student (`Name`, `Email`, `Password`) VALUES (?, ?, ?);";
        } else if (Type == "Teach") {
            query = "INSERT INTO Teacher (`Name`, `Email`, `Password`) VALUES (?, ?, ?);";
        }

        PreparedStatement pStat;

        try {

            pStat = connection.getConnection().prepareStatement(query);

            // pStat.setString(1, Name);
            // pStat.setString(2, Email);
            // pStat.setString(3, Pass);
            // pStat.executeUpdate();

            System.out.println("Inserting Works");

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
