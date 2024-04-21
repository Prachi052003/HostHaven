// SignupPage.java
package hotel;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("unused")
public class SignupPage {

    private JFrame frame;
    private JTextField tfName;
    private JTextField tfEmail;
    private JPasswordField tfPassword;
    private JButton btnSignup;
    private String username; // Store username
    private String role; // Store role

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
                role = "user"; // Assuming signed up users have "user" role
                insertIntoDatabase(username, password, email);
                openCustomerAdminPage();
                frame.dispose();
            }
        });
    }

    private void insertIntoDatabase(String username, String password, String email) {
        // Insert into database logic
        // Example SQL code:
        // INSERT INTO users (username, password, email) VALUES ('username', 'password', 'email');
        // Ensure you handle database operations properly
    }

    private void openCustomerAdminPage() {
        CustomerAdminPage customerAdminPage = new CustomerAdminPage(username, role);
        customerAdminPage.setVisible(true);
    }
    
    public void resetUserPwd() {
        tfName.setText("");
        tfPassword.setText("");
    }

	public void show() {
		// TODO Auto-generated method stub
		
	}

  
}
