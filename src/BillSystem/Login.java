package BillSystem;
import javax.swing.*;
import java.sql.*; 
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{

	 JButton login, cancel, signup;
	 JTextField username, password;
	 Choice loginInAs;
	Login()
	{
		super("Login Page");  //heading(it is the 1st statement)
		getContentPane().setBackground(Color.white);
		setLayout(null);
			
		//UserName
		JLabel lblusername = new JLabel("User Name");
		lblusername.setBounds(300, -60, 100, 200);
		add(lblusername);
		
		username = new JTextField();
        username.setBounds(400, 30, 150, 20);
        add(username);
		
        //Password
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(300, -20, 100, 200);
		add(lblPassword);
		
		password = new JTextField();
        password.setBounds(400, 70, 150, 20);
        add(password);
		
        //LoginInAs
		JLabel LoginInAs = new JLabel("Login in as");
		LoginInAs.setBounds(300, 20, 100, 200);
		add(LoginInAs);
		
		//DropDown
		loginInAs = new Choice();
        loginInAs.add("Admin");
        loginInAs.add("Customer");
        loginInAs.setBounds(400, 110, 150, 20);
        add(loginInAs);
        
        //Login Button
    	ImageIcon i1 = new ImageIcon("E:\\MCA(23-25)\\Placement\\Projects\\Project(BillSystem)\\Electricity_Bill_System\\Billing_System\\src\\icon/login.png");
        Image i2 = i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        login = new JButton("Login",new ImageIcon(i2));
        login.setBounds(330, 160, 100, 20);
        login.addActionListener(this);
        add(login);
		
        //Cancel Button
        ImageIcon i3 = new ImageIcon("E:\\MCA(23-25)\\Placement\\Projects\\Project(BillSystem)\\Electricity_Bill_System\\Billing_System\\src\\icon/cancel.jpg");
        Image i4 = i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        cancel = new JButton("Cancel", new ImageIcon(i4));
        cancel.setBounds(450, 160, 100, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        //Sign UP Button
        ImageIcon i5 = new ImageIcon("E:\\MCA(23-25)\\Placement\\Projects\\Project(BillSystem)\\Electricity_Bill_System\\Billing_System\\src\\icon/signup.png");
        Image i6 = i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        signup = new JButton("Signup", new ImageIcon(i6));
        signup.setBounds(380, 200, 100, 20);
        signup.addActionListener(this);
        add(signup);

        //Left Side Image
        ImageIcon i7 = new ImageIcon("E:\\MCA(23-25)\\Placement\\Projects\\Project(BillSystem)\\Electricity_Bill_System\\Billing_System\\src\\icon/second.jpg");
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(0, 0, 250, 250);
        add(image);
        
        
        
		setSize(640,300);
		setLocation(380,200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String susername = username.getText();
            String spassword = password.getText();
            String aType = loginInAs.getSelectedItem();
            
            try {
                Conn c = new Conn();
                String query = "select * from login where username = '"+susername+"' and password = '"+spassword+"' and user = '"+aType+"'";
                
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()) {
                    String meter = rs.getString("meter_no");
                    setVisible(false);
                    new Project(aType, meter);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    username.setText("");
                    password.setText("");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        } else if (ae.getSource() == signup) {
            setVisible(false);
            
            new Signup();
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}