package lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    private JButton[] button;
    private JTextField field;
    String[] text = { "%", "CE", "C", "/",
                      "7", "8", "9", "x",
                      "4", "5", "6", "-",
                      "1", "2", "3", "+",
                      " ", "0", ".", "=" };
    private JPanel mainPanel;

    private String current = "";
    private String operator = "";
    private double firstNum = 0;
    private boolean startNew = true;

    public Calculator(String title) {
        super(title);
        button = new JButton[text.length];
        field = new JTextField("0");
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 4, 5, 5));

        field.setFont(new Font("Consolas", Font.BOLD, 30));
        field.setHorizontalAlignment(JTextField.RIGHT);
        field.setEditable(false);
        add(field, BorderLayout.NORTH);

        for (int i = 0; i < text.length; i++) {
            button[i] = new JButton(text[i]);
            button[i].setFont(new Font("Consolas", Font.PLAIN, 20));
            button[i].addActionListener(this);
            mainPanel.add(button[i]);
        }

        add(mainPanel, BorderLayout.CENTER);
        setSize(350, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9]") || cmd.equals(".")) {
            if (startNew) {
                current = "";
                startNew = false;
            }
            current += cmd;
            field.setText(current);
        } 
        else if (cmd.equals("C")) {
            current = "";
            operator = "";
            firstNum = 0;
            field.setText("0");
            startNew = true;
        } 
        else if (cmd.equals("CE")) {
            current = "";
            field.setText("0");
            startNew = true;   
        }


        else if (cmd.equals("%")) {
            try {
                double val = Double.parseDouble(field.getText());
                val = val / 100;
                current = String.valueOf(val);
                field.setText(current);
                startNew = true;
            } catch (Exception ex) {}
        } 
        else if ("+-x/".contains(cmd)) {
            try {
                firstNum = Double.parseDouble(field.getText());
            } catch (Exception ex) {
                firstNum = 0;
            }
            operator = cmd;
            startNew = true;
        } 
        else if (cmd.equals("=")) {
            try {
                double secondNum = Double.parseDouble(field.getText());
                double result = 0;

                switch (operator) {
                    case "+": result = firstNum + secondNum; break;
                    case "-": result = firstNum - secondNum; break;
                    case "x": result = firstNum * secondNum; break;
                    case "/": 
                        if (secondNum == 0) {
                            field.setText("Error");
                            return;
                        }
                        result = firstNum / secondNum; 
                        break;
                }
                current = String.valueOf(result);
                field.setText(current);
                startNew = true;
            } catch (Exception ex) {}
        }
        else if (cmd.equals(" ")) { 
            if (!current.isEmpty() && !startNew) {
                current = current.substring(0, current.length() - 1);
                if (current.isEmpty()) current = "0";
                field.setText(current);
            } else {
                field.setText("0");
            }
        }
    }
    public static void main(String[] args) {
        new Calculator("Calculator");
    }
}
