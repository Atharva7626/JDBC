import java.sql.*;
import java.util.*;


public class a2 {

    public static void main(String[] args) {
        

        Connection con;
        //Statement st;
        //ResultSet rs;
        DatabaseMetaData dm;

        try{

            //to load all drivers..
            Class.forName("com.postgresql.Driver");

            con=DriverManager.getConnection("jdbc:postgresql:DB","postgres","");

            if (con==null){
                System.out.println("\n Connection failed...");
            }
            else{
                System.out.println("Connection Successful ..\n");

                System.out.println("Metadata information...");
                dm=con.getMetaData();

                System.out.println("\n Database product Name : "+dm.getDatabaseProductName());
                System.out.println("Database product version : "+dm.getDatabaseProductVersion());
                System.out.println("\n Database Driver Name : "+dm.getDriverName());
                System.out.println("Database Driver version : "+dm.getDriverVersion());

                System.out.println("Database tables : "+dm.getTables(null, null, null, args));

            }

            con.close();

        }
        catch(ClassNotFoundException | SQLException e){
            //   System.out.println(e.printStackTrace());
            e.printStackTrace();

        }


    }
    
}
