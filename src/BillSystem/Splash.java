package BillSystem;
import javax.swing.*;
import java.awt.*;

        public class Splash extends JFrame implements Runnable {
           
            Splash() {
                
            	ImageIcon i1 = new ImageIcon("E:\\MCA(23-25)\\Placement\\Projects\\Project(BillSystem)\\Electricity_Bill_System\\Billing_System\\src\\icon/elect.jpg");
                Image i2 = i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);  ///scale the image
                ImageIcon i3 = new ImageIcon(i2);   //convert to image to imageIcon for passing to JFrame
                JLabel image = new JLabel(i3);
                add(image);
                
                setVisible(true);
//                
//                int x = 1;
//                for (int i = 2; i < 600; i+=4, x+=1) {
//                    setSize(i + x, i);
//                    setLocation(700 - ((i + x)/2), 400 - (i/2));
//                    try {
//                        Thread.sleep(5);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
                
                setSize(720,550);
                setLocation(300,100);
                
                Thread t = new Thread(this);
                t.start();
                
                setVisible(true);
            }
            
            public void run() {
                try {
                    Thread.sleep(7000);
                    setVisible(false);
                    
                    // login frame
                   new Login();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            public static void main(String[] args) {
                new Splash();
            }
        }