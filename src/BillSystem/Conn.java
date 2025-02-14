package BillSystem;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    Conn() 
    {
        try
        {
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ElectricityBillSystem", "root", "Ankit@23112000");
            s = c.createStatement();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
}