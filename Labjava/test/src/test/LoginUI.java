package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class LoginUI extends JFrame {
    private HashMap<String, Teacher> users = new HashMap<>();

    public LoginUI() {
        setTitle("Login System");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(15);
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(15);

        JButton loginBtn = new JButton("Login");
        JButton signupBtn = new JButton("Signup");

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(emailLabel); panel.add(emailField);
        panel.add(passLabel); panel.add(passField);
        panel.add(loginBtn); panel.add(signupBtn);

        add(panel);

        // Signup
        signupBtn.addActionListener(e -> {
            String email = emailField.getText();
            String pass = new String(passField.getPassword());
            Teacher t = new Teacher(email, email, pass);
            users.put(email, t);
            JOptionPane.showMessageDialog(this, "Signup successful!");
        });

        // Login
        loginBtn.addActionListener(e -> {
            String email = emailField.getText();
            String pass = new String(passField.getPassword());
            if (users.containsKey(email) && users.get(email).getPassword().equals(pass)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                dispose();
                new BookingUI(users.get(email));
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email or password!");
            }
        });

        setVisible(true);
    }
}

