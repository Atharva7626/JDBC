import java.sql.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class mob {

    /**
     * @param args
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void main(String args[])throws SQLException, ClassNotFoundException {
        
        Connection con;
        Statement stmt;
        ResultSet rs;
        PreparedStatement ps1;

        int mno,ram,strg;
        String mname,mcolor,stype,ntype,batt,ptype;

        int op=Integer.parseInt(args[0]);

        Scanner sc=new Scanner(System.in);
        try
        {

            Class.forName("com.postgresql.Driver");

            con=DriverManager.getConnection("jdbc:postgrsql:DB", "postgres","" );

            if (con==null)
            {
                System.out.println("Connection Failed ");
            }
            else
            {
                System.out.println("1 : Insert");
                System.out.println("2 : Modify");
                System.out.println("3 : Delete");
                System.out.println("4 : Search");
                System.out.println("5 : View All");
                System.out.println("6 : Exit");
                switch(op)
                {
                    case 1:System.out.print(" \n Enter mobile (model_no) : ");
                           mno=sc.nextInt();
                           System.out.print(" \n Enter mobile (model_name) : ");
                           mname=sc.next();
                           System.out.print(" \n Enter mobile (model_color) : ");
                           mcolor=sc.next();
                           System.out.print(" \n Enter mobile (sim_type) : ");
                           stype=sc.next();
                           System.out.print(" \n Enter mobile (network_type) : ");
                           ntype=sc.next();
                           System.out.print(" \n Enter mobile (battery capacity) : ");
                           batt=sc.next();
                           System.out.print(" \n Enter mobile (internal Storage) : ");
                           strg=sc.nextInt();
                           System.out.print(" \n Enter mobile (ram) : ");
                           ram=sc.nextInt();
                           System.out.print(" \n Enter mobile (processor) : ");
                           ptype=sc.next();

                           stmt=con.createStatement();
                          // String q= "INSERT INTO project () VALUES (mno,'mname','mcolor','stype','ntype','batt',strg,ram,ptype)";
                           //rs=stmt.executeQuery("INSERT INTO mobile () VALUES (mno,'mname','mcolor','stype','ntype','batt',strg,ram,ptype)");
                           //success..

                           try {
                            String insertQuery = "INSERT INTO project (project_name, project_description, project_status) VALUES (?, ?, ?)";
                            try (PreparedStatement ps2 = con.prepareStatement(insertQuery)) {
                                ps2.setInt(1, mno); 
                                ps2.setString(2, mname); 
                                ps2.setString(3, mcolor);
                                ps2.setString(4, stype);
                                ps2.setString(5, ntype);
                                ps2.setString(6, batt);
                                ps2.setInt(7, strg);
                                ps2.setInt(8, ram);
                                ps2.setString(9, ptype);
                                
                                ps2.executeUpdate();
                                System.out.println("Record inserted successfully!");
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        break;

                    case 2:
                           break;
                    case 3://delete
                           System.out.print("Enter model_name to delete mobile : ");
                           String m=sc.next();
                           String sq="DELETE FROM mobile WHERE moname=='m'";
                           stmt=con.createStatement();
                           int no=stmt.executeUpdate(sq);
                           if (no >1){
                            System.out.println("Successfully deleted...");
                           }
                           break;
                    case 4://search
                          System.out.print("Enter model_no to search mobile : ");
                          int n=sc.nextInt();

                          String ql="SELECT * FROM mobile WHERE mno=="+n;
                          stmt=con.createStatement();
                          rs=stmt.executeQuery(ql);

                          if (rs.next()){
                            System.out.println(" Mobile no : "+rs.getInt(1));
                            System.out.println(" Mobile name : "+rs.getString(2));
                            System.out.println(" Mobile color : "+rs.getString(3));
                            System.out.println(" Mobile sim : "+rs.getString(4));
                            System.out.println(" Mobile network : "+rs.getString(5));
                            System.out.println(" Mobile battery : "+rs.getString(6));
                            System.out.println(" Mobile Internal : "+rs.getInt(7));
                            System.out.println(" Mobile Ram : "+rs.getInt(8));
                            System.out.println(" Mobile processor : "+rs.getString(9));
                          }
                          else
                          {
                             System.out.println("Record not found");
                          }



                           break;
                    case 5: //viewall
                          String q="SELECT * FROM mobile ";
                          stmt=con.createStatement();
                          rs=stmt.executeQuery(q);

                           if (rs.next())
                          {
                            System.out.println(" Mobile no : "+rs.getInt(1));
                            System.out.println(" Mobile name : "+rs.getString(2));
                            System.out.println(" Mobile color : "+rs.getString(3));
                            System.out.println(" Mobile sim : "+rs.getString(4));
                            System.out.println(" Mobile network : "+rs.getString(5));
                            System.out.println(" Mobile battery : "+rs.getString(6));
                            System.out.println(" Mobile Internal : "+rs.getInt(7));
                            System.out.println(" Mobile Ram : "+rs.getInt(8));
                            System.out.println(" Mobile processor : "+rs.getString(9));
                      
                          }    
                            break;
                    case 6:System.exit(0);
                           break;
                }

            }
        }
        catch(ClassCastException e)
        {
            e.printStackTrace();
        }
    }
    
}
