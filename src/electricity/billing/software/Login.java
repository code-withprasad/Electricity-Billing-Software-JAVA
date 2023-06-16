/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.software;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    JButton Login,Cancel,Signup;
    JTextField username,password;
    Choice logginin;

    Login() {
        super("LOGIN PLEASE");
//        getContentPane().setBackground(Color.WHITE);
        getContentPane().setBackground(new Color(255,245,238));

        setLayout(null);
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(300, 20, 100, 20);
        add(lblUsername);
        username = new JTextField();
        username.setBounds(400, 20, 150, 20);
        add(username);

        setLayout(null);
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(300, 60, 100, 20);
        add(lblPassword);
        password = new JTextField();
        password.setBounds(400, 60, 150, 20);
        add(password);

        setLayout(null);
        JLabel Loggininas = new JLabel("Logg in as");
        Loggininas.setBounds(300, 100, 100, 20);
        add(Loggininas);
//        dropdown
        logginin = new Choice();
        logginin.add("Admin");
        logginin.add("Customer");
        logginin.setBounds(400, 100, 150, 20);
        add(logginin);

        //        buttons
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/Login.png"));
        Image i2 = i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        Login = new JButton("Login", new ImageIcon(i2));
        Login.setBounds(330, 160, 100, 20);
        Login.addActionListener(this);
        add(Login);

        
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("Icon/cancel.jpg"));
        Image i4 = i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        Cancel = new JButton("Cancel", new ImageIcon(i4));
        Cancel.setBounds(450, 160, 100, 20);
        Cancel.addActionListener(this);
        add(Cancel);

        
        
        
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("Icon/signup.png"));
        Image i6 = i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        Signup = new JButton("Signup", new ImageIcon(i6));
        Signup.setBounds(380, 200, 100, 20);
        Signup.addActionListener(this);
        add(Signup);

        
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("Icon/second-frame.png"));
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel Image = new JLabel(i9);
        Image.setBounds(20,0,250,250);
        add(Image);
        
        
        
        setSize(640, 300);
        setLocation(400, 200);
        setVisible(true);

    }
    
    
    public void actionPerformed(ActionEvent ae){
    
    if (ae.getSource() == Login){
         String susername = username.getText();
         String spassword = password.getText();
         String user = logginin.getSelectedItem();
         
         
         try{
         
             Conn c = new Conn();
//             String query = "select * from login where username =  '" + susername+"' and password =  '" + spassword+"' and user = '"+user+"'";
               String query = "select * from login where username = '"+susername+"' and password = '"+spassword+"' and user = '"+user+"'";
                ResultSet rs =  c.s.executeQuery(query);
             
             if(rs.next()){
                String meter = rs.getString("meter_no");
                setVisible(false);
                new Project(user,meter);
               
             } else{
                 JOptionPane.showMessageDialog(null, "Invalid Login");
                  username.setText("");
                  password.setText("");
                 }
             
            }catch(Exception e){
           
           e.printStackTrace();
         }
         
    } 
    
    
    else if ( ae.getSource() == Cancel){
    setVisible(false);
    }
    
    else if ( ae.getSource() == Signup){
    setVisible(false);
    
    
       new Signup();
    }
    
    }

    public static void main(String[] args) {

        new Login();

    }
}
