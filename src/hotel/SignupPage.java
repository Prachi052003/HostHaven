package hotel;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignupPage {

    private JFrame frame;
    private JTextField tfName;
    private JTextField tfEmail;
    private JPasswordField tfPassword;
    private JButton btnSignup;
    private String username;
    private String role;

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hotel";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "prachi@123";

    public SignupPage() {
        frame = new JFrame();
        frame.setBounds(200, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblName.setBounds(50, 50, 100, 30);
        frame.getContentPane().add(lblName);

        tfName = new JTextField();
        tfName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        tfName.setBounds(200, 50, 250, 30);
        frame.getContentPane().add(tfName);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblEmail.setBounds(50, 100, 100, 30);
        frame.getContentPane().add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        tfEmail.setBounds(200, 100, 250, 30);
        frame.getContentPane().add(tfEmail);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblPassword.setBounds(50, 150, 100, 30);
        frame.getContentPane().add(lblPassword);

        tfPassword = new JPasswordField();
        tfPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        tfPassword.setBounds(200, 150, 250, 30);
        frame.getContentPane().add(tfPassword);

        btnSignup = new JButton("Sign Up");
        btnSignup.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnSignup.setBounds(200, 220, 150, 40);
        frame.getContentPane().add(btnSignup);

        btnSignup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                username = tfName.getText();
                String password = String.valueOf(tfPassword.getPassword());
                String email = tfEmail.getText();
                role = "user";

                insertIntoDatabase(username, password, email);

                openCustomerAdminPage(username, role);
                frame.dispose();
            }
        });
    }

    private void insertIntoDatabase(String username, String password, String email) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Check if the username already exists
            String checkQuery = "SELECT COUNT(*) FROM signup WHERE username = ?";
            PreparedStatement checkStatement = conn.prepareStatement(checkQuery);
            checkStatement.setString(1, username);
            ResultSet resultSet = checkStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            if (count > 0) {
                // Username already exists, handle this situation (e.g., show an error message)
                System.out.println("Username already exists. Please choose a different username.");
                return; // Exit method
            }

            // Prepare SQL statement for insertion
            String sql = "INSERT INTO signup (username, password, email) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);

            // Execute insertion query
            statement.executeUpdate();

            // Close database resources
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private void openCustomerAdminPage(String username, String role) {
        CustomerAdminPage customerAdminPage = new CustomerAdminPage(username, role);
        customerAdminPage.setVisible(true);
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SignupPage signupPage = new SignupPage();
        signupPage.show();
    }
}
