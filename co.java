import java.sql.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class co extends JFrame implements ActionListener  {

    JFrame f;
    JLabel top;
    JLabel an,by,mn,ag,sh,va,ts;
    JButton ad,up,del,vi,se;

    JTextField t1,t2,t3,t4;

    JRadioButton cv,cx,sp;
    JRadioButton mo,af,ev;
    JRadioButton ei,fo;
    // Component b1;
    ButtonGroup b1,b2,b3;
    Connection con;

    JPanel p,p1,p2,p3,p4,p5,p6,p7,p8,p9;

    co()
    {
/*
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

            }
        }catch(ClassNotFoundException |SQLException e){


        }  
*/


        f=new JFrame("Cowin Registration");

        p=new JPanel();
        p.setLayout(new GridLayout(1,1,10,50));
        top=new JLabel("Cowin Registration");
        p.add(top);

        p2=new JPanel();
        p.setLayout(new GridLayout(3, 2, 300, 20));

        an=new JLabel("AadharCardNo : ");
        t1=new JTextField("",10);
        System.out.println();

        by=new JLabel("Birth Year : ");
        t2=new JTextField("",10);

        mn=new JLabel("Mobile No : ");
        t3=new JTextField("",10);

        p2.add(an);
        p2.add(t1);


        p3=new JPanel();
        p3.setLayout(new FlowLayout());

        p3.add(by);
        p3.add(t2);

        p4=new JPanel();
        p4.setLayout(new FlowLayout());

        p4.add(mn);
        p4.add(t3);


        p5=new JPanel();
        p5.setLayout(new FlowLayout());

        ag=new JLabel("Age Group : ");
        ei=new JRadioButton(" 18 & Above");
        fo=new JRadioButton(" 45 & Above");

        ei.addActionListener(this);
        fo.addActionListener(this);
        b1=new ButtonGroup();
        b1.add(ei);
        b1.add(fo);
        
        p5.add(ag);
        // p5.add(b1);
        p5.add(ei);
        p5.add(fo);

        p6=new JPanel();
        p6.setLayout(new FlowLayout());

        sh=new JLabel("Select Hospital");
        t4=new JTextField("",10);

        p6.add(sh);
        p6.add(t4);

        p7=new JPanel();
        p7.setLayout(new FlowLayout());

        va=new JLabel("Vaccines : ");
        cv=new JRadioButton("Covishield");
        cx=new JRadioButton("Covaxin");
        sp=new JRadioButton("Sputnik V");

        b2=new ButtonGroup();
        b2.add(cv);
        b2.add(cx);
        b2.add(sp);
        
        p7.add(va);
        p7.add(cv);
        p7.add(cx);
        p7.add(sp);

        p8=new JPanel();
        p8.setLayout(new FlowLayout());

        ts=new JLabel("Time slot");
        mo=new JRadioButton("Morning");
        af=new JRadioButton("AfterNoon");
        ev=new JRadioButton("Evening");

        b3=new ButtonGroup();
        b3.add(mo);
        b3.add(af);
        b3.add(ev);

        p8.add(ts);
        p8.add(mo);
        p8.add(af);
        p8.add(ev);

        p9=new JPanel();
        p9.setLayout(new FlowLayout());
        ad=new JButton("ADD");
        up=new JButton("UPDATE");
        del=new JButton("DELETE");
        vi=new JButton("VIEW");
        se=new JButton("SEARCH");
        
        ad.addActionListener(this);
        up.addActionListener(this);
        del.addActionListener(this);
        vi.addActionListener(this);
        se.addActionListener(this);
        
        p9.add(ad);
        p9.add(up);
        p9.add(del);
        p9.add(vi);
        p9.add(se);


        f.add(p);
        f.add(p2);
        f.add(p3);
        f.add(p4);
        f.add(p5);
        f.add(p6);
        f.add(p7);
        f.add(p8);
        f.add(p9);
        f.setLayout(new GridLayout(9,1));
        f.setSize(450,500);
        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
        String ano,b,m,sh,age,vac,t;

        if (e.getSource()==ad){
            co a=new co();
            ano=t1.getText();
            b=t2.getText();
            m=t3.getText();
            sh=t4.getText();
            // age=e.getActionCommand();
            AbstractButton selectedButton = (AbstractButton) e.getSource();
            System.out.println("Selected: " + selectedButton.getText());
            age=selectedButton.getText();




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
    
                }
            }catch(ClassNotFoundException |SQLException e1){
    
    
            }

            
         
            
        }



    }




    public static void main(String[] args) {
        co c=new co();
    }
    
}
