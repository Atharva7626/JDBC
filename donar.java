import java.sql.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class donar {

    public static void main(String[] args)throws SQLException {
        Connection con;
        Statement stmt;
        ResultSet rs;

        try {
            // Registering the MySQL JDBC Driver
            Class.forName("com.postgresql.Driver");

            con = DriverManager.getConnection("jdbc:postgresql:TestDB", "postgres", "");

            if (con==null)
            {
                System.out.println("Connection failed..");
            }else{
                stmt=con.createStatement();
                rs=stmt.executeQuery("Select * from Donor");

                ResultSetMetaData rsmd=rs.getMetaData();
                int no=rsmd.getColumnCount();

                for (int i=0;i<no;++i){
                    System.out.println("Column no : "+i);
                    System.out.println("Column name : "+rsmd.getColumnName(i));
                    System.out.println(" Column type : "+rsmd.getColumnType(i));
                    System.out.println(" Column Display size : "+rsmd.getColumnDisplaySize(i));

                }

                con.close();

            }

            // Do something with the connection (e.g., execute SQL queries)

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
}
