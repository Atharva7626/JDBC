import java.sql.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class p1 extends JFrame implements ActionListener {
    JFrame f;
   JButton ins,dis;
   JTable t; 
   JPanel p;
   JLabel id,nm,ds,st;
   JTextField iid,nnm,dds,sst;

   int pid;
   String pname,pdes,psta;

   p1()
   {

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
        }
        else
        {
            System.out.println("Connection Successful..");
            stmt=con.createStatement();
            rs=stmt.executeQuery("Select * from project");

            while (rs.next())
              {
                    System.out.print(" Project Id : "+rs.getInt(1));
                    System.out.print(" Project Name : "+rs.getString(2));
                    System.out.print(" Project Description : "+rs.getString(3));
                    System.out.print(" Project Status : "+rs.getString(1));

                    
                    
                    pid=rs.getInt(1);
                    pname=rs.getString(2);
                    pdes=rs.getString(3);
                    psta=rs.getString(4);
                   
                  

                   /*
                   pid=1;
                   pname="Memory";
                   pdes="Hello";
                   psta="Atharv";
                   */

                }
            }
            con.close();
        }
        catch (ClassNotFoundException | SQLException e) 
        {
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
     dis.addActionListener(this);
    ins.addActionListener(this);
   }

   public void actionPerformed(ActionEvent e)
   {
    if (e.getSource()==dis){
        System.out.println("Hello");

        // iid.setInt(pid);
        nnm.setText(pname);
        dds.setText(pdes);
        sst.setText(psta);
        // p1 p2=new p1();


    }


   }

   public static void main(String[] args) {
       p1 p=new p1();

   }



   }






