import java.io.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;






public class pro extends JFrame implements ActionListener {
   
   JFrame f;
   JButton ins,dis;
   JTable t; 
   JPanel p;
   JLabel id,nm,ds,st;
   JTextField iid,nnm,dds,sst;

   
   Connection con;

   String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc";
       String username = "root";
       String password = "qwertyuiop";

       // Connection con;
       Statement stmt;
       ResultSet rs;





   String pid,pname,pdes,psta;
   pro(){
    f=new JFrame("Project");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // f.setLayout(new GridLayout(4,4));

    p=new JPanel();
    p.setLayout(new GridLayout(5, 2,10,10));

    id=new JLabel("Project Id ");
    iid=new JTextField();

    nm=new JLabel("Project name ");
    nnm=new JTextField();

    ds=new JLabel("Project Description : ");
    dds=new JTextField();

    st=new JLabel("Project Status ");
    sst=new JTextField();

    p.add(id);
    p.add(iid);

    p.add(nm);
    p.add(nnm);

    p.add(ds);
    p.add(dds);

    p.add(st);
    p.add(sst);
    
    
    
    


    ins=new JButton("Insert");
    dis=new JButton("Display ..");
    

    p.add(ins);
    p.add(dis);
    
    add(p);
    setSize(300, 400);
    setVisible(true);
    dis.addActionListener(this);
    ins.addActionListener(this);

   }

   public void actionPerformed(ActionEvent e){
    
    if (e.getSource().equals(dis)){
        System.out.println("Hello");

        displayData();

    }
    /*

    if (e.getSource().equals(ins)){
        System.out.println(" no Hello");

        try {
            // Registering the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(jdbcUrl, username, password);


            if (con==null)
            {
                System.out.println("Connection failed..");
            }else{
                System.out.println("Connection Successful..");
                stmt=con.createStatement();
                rs=stmt.executeQuery("Select * from project");

                while (rs.next()){
                    System.out.print(" Project Id : "+rs.getInt(1));
                    System.out.print(" Project Name : "+rs.getString(2));
                    System.out.print(" Project Description : "+rs.getString(3));
                    System.out.print(" Project Status : "+rs.getString(1));

                }
                con.close();

            }catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }finally{


            }*/
    }

   
   private void displayData(){

    try {
        // Registering the MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(jdbcUrl, username, password);


        if (con==null)
        {
            System.out.println("Connection failed..");
        }else{
            System.out.println("Connection Successful..");
            stmt=con.createStatement();
            rs=stmt.executeQuery("Select * from project");

            while (rs.next()){
                System.out.print(" Project Id : "+rs.getInt(1));
                System.out.print(" Project Name : "+rs.getString(2));
                System.out.print(" Project Description : "+rs.getString(3));
                System.out.print(" Project Status : "+rs.getString(1));

            }
            con.close();
        }
        }
        catch (ClassNotFoundException | SQLException e)
         {
            e.printStackTrace();
        }
    
   }
  


    public static void main(String ars[]){

/*
        Connection con;

    String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "qwertyuiop";

        // Connection con;
        Statement stmt;
        ResultSet rs;





        try {
            // Registering the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(jdbcUrl, username, password);


            if (con==null)
            {
                System.out.println("Connection failed..");
            }else{
                System.out.println("Connection Successful..");
                stmt=con.createStatement();
                rs=stmt.executeQuery("Select * from project");

                while (rs.next()){
                    System.out.print(" Project Id : "+rs.getInt(1));
                    System.out.print(" Project Name : "+rs.getString(2));
                    System.out.print(" Project Description : "+rs.getString(3));
                    System.out.print(" Project Status : "+rs.getString(1));

                }
                con.close();

            }

            // Do something with the connection (e.g., execute SQL queries)

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
*/

SwingUtilities.invokeLater(() -> new pro());



        // pro p=new pro();


 



        


    


    }
}
