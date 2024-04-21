package hotel;

import javax.swing.*;
import java.awt.*;

public class LoginPage {

    private JFrame frame;
    private JTextField tfusername;
    private JPasswordField tfpwd;
    private JButton btnLogin;
    private JButton btnCancel;
    private JLabel Ustar;
    private JLabel Pstar;
    private JButton btnSignup;

    public LoginPage() {
        Ustar = new JLabel("*");
        Pstar = new JLabel("*");

        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 23));
        frame.setBounds(200, 100, 898, 624);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Set background image
        ImageIcon backgroundImg = new ImageIcon("images\\loginbk.jpg");
        JLabel background = new JLabel("", backgroundImg, JLabel.CENTER);
        background.setBounds(0, 0, 898, 624);
        frame.getContentPane().add(background);

        JLabel lblLogin = new JLabel("LOGIN ");
        lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 32));
        lblLogin.setForeground(Color.WHITE); // Set text color to white
        lblLogin.setBounds(389, 190, 212, 67);
        background.add(lblLogin);

        // Username Label and TextField
        JLabel lblUsername = new JLabel("USERNAME");
        lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 23));
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setBounds(280, 324, 155, 50);
        background.add(lblUsername);

        tfusername = new JTextField();
        tfusername.setFont(new Font("Times New Roman", Font.BOLD, 23));
        tfusername.setBounds(489, 331, 208, 38);
        background.add(tfusername);
        tfusername.setColumns(10);

        // Password Label and PasswordField
        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 23));
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setBounds(280, 413, 133, 38);
        background.add(lblPassword);

        tfpwd = new JPasswordField();
        tfpwd.setFont(new Font("Times New Roman", Font.BOLD, 23));
        tfpwd.setBounds(489, 414, 208, 38);
        background.add(tfpwd);

        // Login Button
        btnLogin = new JButton("LOGIN");
        btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 23));
        btnLogin.setBounds(288, 513, 147, 50);
        background.add(btnLogin);

        // Signup Button
        btnSignup = new JButton("Signup");
        btnSignup.setFont(new Font("Times New Roman", Font.BOLD, 23));
        btnSignup.setBounds(288, 513, 147, 50);
        background.add(btnSignup);

        // Cancel Button
        btnCancel = new JButton("QUIT");
        btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 23));
        btnCancel.setBounds(565, 513, 155, 51);
        background.add(btnCancel);

        Ustar.setForeground(Color.RED);
        Ustar.setFont(new Font("Times New Roman", Font.BOLD, 28));
        Ustar.setBounds(699, 347, 46, 21);
        background.add(Ustar);

        Pstar.setForeground(Color.RED);
        Pstar.setFont(new Font("Times New Roman", Font.BOLD, 28));
        Pstar.setBounds(699, 430, 46, 21);
        background.add(Pstar);

        JLabel lblHotelManagementSystem = new JLabel("HOTEL KAYAK");
        lblHotelManagementSystem.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
        lblHotelManagementSystem.setForeground(Color.WHITE); // Set text color to white
        lblHotelManagementSystem.setBounds(279, 72, 636, 80);
        background.add(lblHotelManagementSystem);

        Ustar.setVisible(false);
        Pstar.setVisible(false);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getLoginBtn() {
        return btnLogin;
    }

    public JButton getSignupBtn() {
        return btnSignup;
    }

    public JButton getCancelBtn() {
        return btnCancel;
    }

    public String getUserName() {
        return tfusername.getText();
    }

    public String getPassword() {
        char[] passwordChars = tfpwd.getPassword();
        return String.valueOf(passwordChars);
    }

    public void resetUserPwd() {
        tfusername.setText("");
        tfpwd.setText("");
    }

    public JLabel getUStar() {
        return Ustar;
    }

    public JLabel getPStar() {
        return Pstar;
    }

    public void show() {
        frame.setVisible(true);
    }
}
