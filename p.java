import java.sql.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



class p extends JFrame {

    /**
     * @param args
     */
    public static void main(String[] args) {
    JFrame f;
   JButton ins,dis;
   JTable t; 
   JPanel p;
   JLabel id,nm,ds,st;
   JTextField iid,nnm,dds,sst;

   int pid;
   String pname,pdes,psta;



   // db connection 
//    String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc";
        // String username = "root";
        // String password = "qwertyuiop";

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
                System.out.println("Connection Successful..");
                stmt=con.createStatement();
                rs=stmt.executeQuery("Select * from project");

                while (rs.next()){
                    System.out.print(" Project Id : "+rs.getInt(1));
                    System.out.print(" Project Name : "+rs.getString(2));
                    System.out.print(" Project Description : "+rs.getString(3));
                    System.out.print(" Project Status : "+rs.getString(1));

                    pid=rs.getInt(1);
                    pname=rs.getString(2);
                    pdes=rs.getString(3);
                    psta=rs.getString(4);


                }
                con.close();

            }

            // Do something with the connection (e.g., execute SQL queries)

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }




   
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

    ins=new JButton("Insert");
    dis=new JButton("Display ..");

    p.add(id);
    p.add(iid);

    p.add(nm);
    p.add(nnm);

    p.add(ds);
    p.add(dds);

    p.add(st);
    p.add(sst);
        

    p.add(ins);
    p.add(dis);
    
    f.add(p);
    f.setSize(300, 400);
    f.setVisible(true);
     dis.addActionListener(null);
    //ins.addActionListener(this);

   

        
        
    }

    public void actionPerformed(ActionEvent e){

        // if (e.getSource().equals(dis)){
            // System.out.println("Hello");
    
    
        // }

    }
}