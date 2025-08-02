package org.example;

import org.example.models.DBHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginTest extends JFrame {

    public LoginTest() {
        // Set frame properties
        setTitle("Login");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(235, 255, 240)); // Light blue-gray

        // App title
        JLabel title = new JLabel("Welcome Back!");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setBounds(110, 50, 300, 40);
        title.setForeground(new Color(33, 37, 41));
        add(title);

       /* // Username icon
        JLabel userIcon = new JLabel(new ImageIcon("C:\\Users\\user\\Downloads\\profile.png")); // replace with your actual icon
        userIcon.setBounds(60, 140, 30, 30);
        add(userIcon);*/

        // Enter User Name
        JLabel usertitle = new JLabel("Enter Username");
        usertitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        usertitle.setBounds(100, 105, 300, 40);
        usertitle.setForeground(new Color(33, 37, 41));
        add(usertitle);

        // Username field
        JTextField usernameField = new JTextField();
        usernameField.setBounds(100, 140, 220, 30);
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        usernameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        add(usernameField);

        // Password icon
        JLabel passIcon = new JLabel(new ImageIcon("password_icon.png")); // replace with your actual icon
        passIcon.setBounds(60, 200, 30, 30);
        add(passIcon);

        // Enter User Name
        JLabel userpass = new JLabel("Enter Password");
        userpass.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        userpass.setBounds(100, 180, 300, 40);
        userpass.setForeground(new Color(33, 37, 41));
        add(userpass);
        // Password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(100, 215, 220, 30);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        add(passwordField);

        // Rounded login button
        JButton loginBtn = new RoundedButton("Login");
        loginBtn.setBounds(135, 280, 120, 40);
        loginBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginBtn.setBackground(new Color(4, 191, 51));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(loginBtn);



        /*// Button logic
        loginBtn.addActionListener(e -> {
            String user = usernameField.getText();
            String pass = String.valueOf(passwordField.getPassword());

            if (user.equals("admin") && pass.equals("1234")) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });*/


        loginBtn.addActionListener(e -> {
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());
            // DataBase Work
            if (DBHelper.loginUser(user, pass)) {
                JOptionPane.showMessageDialog(this, "Login successful!");

                //Goto Registar Activity
                gotoToRegister();

            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        });


        // Did't have an Account
        JLabel useractext = new JLabel("Didn't Have an Account?");
        useractext.setFont(new Font("Segoe UI", Font.ITALIC, 15));
        useractext.setBounds(120, 450, 300, 40);
        useractext.setForeground(new Color(33, 37, 41));
        add(useractext);

        // Rounded Regi button
        JButton regiBtn = new RoundedButton("Register");
        regiBtn.setBounds(135, 490, 120, 40);
        regiBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        regiBtn.setBackground(new Color(4, 191, 51));
        regiBtn.setForeground(Color.WHITE);
        regiBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(regiBtn);

        regiBtn.addActionListener(e -> {
            gotoToRegister();
        });

        setVisible(true);
    }

    // Rounded button class
    class RoundedButton extends JButton {
        public RoundedButton(String label) {
            super(label);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            super.paintComponent(g2);
            g2.dispose();
        }


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginTest::new);
    }

    public void gotoToRegister(){
        dispose();
        new Register();
    }
}

