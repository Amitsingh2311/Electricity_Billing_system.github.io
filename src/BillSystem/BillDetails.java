package BillSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class BillDetails extends JFrame {

    BillDetails(String meter) {

        setSize(600, 550);
        setLocation(390, 80);

        getContentPane().setBackground(Color.WHITE);

        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();

        // Setting up table model
        table.setModel(model);

        try {
            Conn c = new Conn();
            String query = "select * from bill where meter_no = '" + meter + "'";
            ResultSet rs = c.s.executeQuery(query);

            // Get metadata for column names
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Add column names to the model
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            // Add rows to the model
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 0, 700, 650);
        add(sp);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BillDetails(""); // Pass meter number as a string here
    }
}
