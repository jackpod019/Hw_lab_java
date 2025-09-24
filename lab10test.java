package lab10;

import java.lang.reflect.Field;

import javax.swing.*;
import java.awt.*;


public class Calculator extends JFrame {

	private JButton[] button;
	private JTextField field;
	String[] text = { "%", "CE", "C", "/", "7", "8", "9", "x", "4", "5", "6", "-", "1", "2", "3", "+", " ", "0", ".",
			"=" };
	private JPanel mainPanel;

	public Calculator(String title) {
		super(title);
		button = new JButton[20];
		field = new JTextField();
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(5, 4));
		field.setFont(new Font("Consolas", Font.ITALIC, 40));
		add(field, BorderLayout.NORTH);
		for (int i = 0; i < text.length; i++) 
		{
		
				button[i] = new JButton(text[i]);
			
			
			mainPanel.add(button[i]);
		}
		add(mainPanel, BorderLayout.CENTER);
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Calculator("Calculator");
	}

}
