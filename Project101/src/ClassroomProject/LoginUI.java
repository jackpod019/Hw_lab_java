package ClassroomProject;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoginUI extends JFrame {
    private final AuthSystem authSystem;

    public LoginUI(AuthSystem authSystem) {
        super("Classroom Reservation - Auth");
        this.authSystem = authSystem;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 360);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Sign Up", createSignUpPanel());
        tabs.addTab("Sign In", createSignInPanel());

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(tabs, BorderLayout.CENTER);
    }

    private JPanel createSignUpPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 8, 6, 8);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(24);
        JLabel gmailLabel = new JLabel("Gmail:");
        JTextField gmailField = new JTextField(24);
        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField(24);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(24);
        JButton signUpButton = new JButton("Sign Up");

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(nameLabel, gbc);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(gmailLabel, gbc);
        gbc.gridx = 1;
        panel.add(gmailField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(idLabel, gbc);
        gbc.gridx = 1;
        panel.add(idField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 1; gbc.gridy = 4;
        panel.add(signUpButton, gbc);

        signUpButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String gmail = gmailField.getText().trim();
            String id = idField.getText().trim();
            String password = new String(passwordField.getPassword());

            if (name.isEmpty() || gmail.isEmpty() || id.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "กรอกข้อมูลให้ครบทุกช่อง", "Validation", JOptionPane.WARNING_MESSAGE);
                return;
            }

            boolean ok = authSystem.signUp(name, gmail, id, password);
            if (ok) {
                JOptionPane.showMessageDialog(this, "✅ Sign Up สำเร็จ! ยินดีต้อนรับ, " + name, "Sign Up", JOptionPane.INFORMATION_MESSAGE);
                nameField.setText("");
                gmailField.setText("");
                idField.setText("");
                passwordField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "❌ Sign Up ล้มเหลว: Gmail มีอยู่ในระบบแล้ว", "Sign Up", JOptionPane.ERROR_MESSAGE);
            }
        });

        return panel;
    }

    private JPanel createSignInPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 8, 6, 8);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel gmailLabel = new JLabel("Gmail:");
        JTextField gmailField = new JTextField(24);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(24);
        JButton signInButton = new JButton("Sign In");

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(gmailLabel, gbc);
        gbc.gridx = 1;
        panel.add(gmailField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(signInButton, gbc);

        signInButton.addActionListener(e -> {
            String gmail = gmailField.getText().trim();
            String password = new String(passwordField.getPassword());

            if (gmail.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "กรอก Gmail และ Password", "Validation", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Teacher t = authSystem.signIn(gmail, password);
            if (t != null) {
                JOptionPane.showMessageDialog(this, "✅ Sign In สำเร็จ! สวัสดี, " + t.getName(), "Sign In", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "❌ Sign In ล้มเหลว: Gmail หรือรหัสผ่านไม่ถูกต้อง", "Sign In", JOptionPane.ERROR_MESSAGE);
            }
        });

        return panel;
    }

    public static void show(AuthSystem authSystem) {
        SwingUtilities.invokeLater(() -> {
            LoginUI ui = new LoginUI(authSystem);
            ui.setVisible(true);
        });
    }
}


