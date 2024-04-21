package hotel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.*;

public class AddDishes extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField d1;
    private JTextField d2;
    private JTextField d3;
    private JTable table;
    private JButton btnBack;

    public AddDishes() {
        addWindowListener((WindowListener) new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                displayDishes();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 972, 611);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblDishName = new JLabel("DISH NAME");
        lblDishName.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblDishName.setBounds(33, 211, 155, 22);
        contentPane.add(lblDishName);

        JLabel lblD = new JLabel("DISH PRICE");
        lblD.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblD.setBounds(33, 284, 155, 27);
        contentPane.add(lblD);

        JLabel lblDishType = new JLabel("DISH TYPE");
        lblDishType.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblDishType.setBounds(33, 353, 155, 27);
        contentPane.add(lblDishType);

        d1 = new JTextField();
        d1.setFont(new Font("High Tower Text", Font.BOLD, 20));
        d1.setBounds(182, 207, 232, 30);
        contentPane.add(d1);
        d1.setColumns(10);

        d2 = new JTextField();
        d2.setFont(new Font("High Tower Text", Font.BOLD, 20));
        d2.setBounds(182, 282, 232, 30);
        contentPane.add(d2);
        d2.setColumns(10);

        d3 = new JTextField();
        d3.setFont(new Font("High Tower Text", Font.BOLD, 20));
        d3.setBounds(182, 351, 232, 30);
        contentPane.add(d3);
        d3.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(456, 194, 418, 279);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JButton btnAddDish = new JButton("ADD DISH");
        btnAddDish.setIcon(new ImageIcon("images\\plus (1).png"));
        btnAddDish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addDishes();
            }
        });
        btnAddDish.setFont(new Font("High Tower Text", Font.BOLD, 20));
        btnAddDish.setBounds(45, 486, 176, 53);
        contentPane.add(btnAddDish);

        JButton btnDeleteDish = new JButton("DELETE DISH");
        btnDeleteDish.setIcon(new ImageIcon("images\\iconfinder_f-cross_256_282471 (1).png"));
        btnDeleteDish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteDishes();
            }
        });
        btnDeleteDish.setFont(new Font("High Tower Text", Font.BOLD, 20));
        btnDeleteDish.setBounds(245, 486, 221, 53);
        contentPane.add(btnDeleteDish);

        JButton btnUpdateDish = new JButton("UPDATE DISH");
        btnUpdateDish.setIcon(new ImageIcon("images\\updated.png"));
        btnUpdateDish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateDishes();
            }
        });
        btnUpdateDish.setFont(new Font("High Tower Text", Font.BOLD, 20));
        btnUpdateDish.setBounds(502, 486, 221, 53);
        contentPane.add(btnUpdateDish);

        JLabel label = new JLabel("");
        label.setBounds(879, 100, 239, 163);

        contentPane.add(label);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("images\\34.jpg"));
        lblNewLabel.setBounds(0, 0, 300, 195);
        contentPane.add(lblNewLabel);

        JLabel label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon("images\\i3.jpg"));
        label_1.setBounds(310, -1, 319, 195);
        contentPane.add(label_1);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("images\\cock.jpg"));
        lblNewLabel_1.setBounds(623, 0, 331, 195);
        contentPane.add(lblNewLabel_1);

        btnBack = new JButton("BACK");
        btnBack.setIcon(new ImageIcon("images\\back.png"));
        btnBack.setFont(new Font("High Tower Text", Font.BOLD, 20));
        btnBack.setBounds(765, 486, 143, 53);
        contentPane.add(btnBack);

        // Action listener for the back button
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current window
                // Add code here to navigate back to the previous window or perform any other action needed
            }
        });
    }

    public void displayDishes() {
        GetConnection connect = new GetConnection();
        Connection conn = connect.getConnection();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("DISH NO");
        model.addColumn("DISH NAME");
        model.addColumn("DISH TYPE");
        model.addColumn("PRICE");

        try {
            String query = "SELECT * FROM restaurant";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("itemNo"),
                        rs.getString("itemName"),
                        rs.getString("Type"),
                        rs.getString("Price")
                });
            }

            rs.close();
            st.close();
            conn.close();
            table.setModel(model);
            table.setAutoResizeMode(0);
            table.getColumnModel().getColumn(0).setPreferredWidth(70);
            table.getColumnModel().getColumn(1).setPreferredWidth(167);
            table.getColumnModel().getColumn(2).setPreferredWidth(90);
            table.getColumnModel().getColumn(3).setPreferredWidth(90);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addDishes() {
        PreparedStatement ps = null;
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            GetConnection connect = new GetConnection();
            Connection conn = connect.getConnection();
            ps = conn.prepareStatement("INSERT INTO restaurant(itemName,Price,Type) VALUES (?,?,?)");
            ps.setString(1, d1.getText());
            ps.setInt(2, Integer.parseInt(d2.getText()));
            ps.setString(3, d3.getText());

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "New Dish Added");
                Object[] newRow = {model.getRowCount() + 1, d1.getText(), d3.getText(), d2.getText()};
                model.addRow(newRow);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateDishes() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a dish to update.");
            return;
        }

        String itemName = d1.getText().trim();
        String price = d2.getText().trim();
        String type = d3.getText().trim();
        
        if (itemName.isEmpty() || price.isEmpty() || type.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String itemNo = model.getValueAt(selectedRow, 0).toString();

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            GetConnection connect = new GetConnection();
            conn = connect.getConnection();
            pstmt = conn.prepareStatement("UPDATE restaurant SET itemName=?, Price=?, Type=? WHERE itemNo=?");
            pstmt.setString(1, itemName);
            pstmt.setString(2, price);
            pstmt.setString(3, type);
            pstmt.setString(4, itemNo);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Dish Updated");
                displayDishes(); // Refresh the displayed dishes after update
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }



    public void deleteDishes() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a dish to delete.");
            return;
        }
        String itemNo = table.getValueAt(selectedRow, 0).toString();

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            GetConnection connect = new GetConnection();
            conn = connect.getConnection();
            pstmt = conn.prepareStatement("DELETE FROM restaurant WHERE itemNo=?");
            pstmt.setString(1, itemNo);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Dish Deleted");
                displayDishes();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public JButton getBackButton() {
        return btnBack;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AddDishes frame = new AddDishes();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public AbstractButton getDeleteButton() {
        // TODO Auto-generated method stub
        return null;
    }

    public AbstractButton getUpdateButton() {
        // TODO Auto-generated method stub
        return null;
    }

    public AbstractButton getSaveButton() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getItemName() {
        return d1.getText();
    }

    public int getPrice() {
        return Integer.parseInt(d2.getText());
    }

    public String getDishType() {
        return d3.getText();
    }
}
