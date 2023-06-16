/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.software;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    Conn() {

        try {

            c = DriverManager.getConnection("jdbc:mysql:///ebs", "root", "PrasadMane@1624");
            s = c.createStatement();

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
