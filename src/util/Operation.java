package util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Operation {

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

    int theId;
    String theName, theEmail, thePass;

    public void SignIn(int ID, String Pass, String Type) {
        GetConnection connection = GetConnection.getInstance();
        
        Statement Stat;
        ResultSet rs;
        String query = "";

        if (Type == "Stud") {
            query = "SELECT * FROM Student WHERE Student_ID = " + ID + ";";
        } else if (Type == "Teach") {
            query = "SELECT * FROM Teacher WHERE Teacher_ID = " + ID + ";";
        }

        System.out.println(query);

        try {
            Stat = connection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = Stat.executeQuery(query);

            rs.next();
            theId = rs.getInt(1);
            theName = rs.getString(2);
            theEmail = rs.getString(3);
            thePass = rs.getString(4);
            // theId = Integer.toString(intId);

            System.out.println("Inserting Works");

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    // public String getId() {
    //     return theId;
    // }

    public int getId() {
        return theId;
    }

    public String getName() {
        return theName;
    }

    public String getEmail() {
        return theEmail;
    }

    public String getPass() {
        return thePass;
    }

}
