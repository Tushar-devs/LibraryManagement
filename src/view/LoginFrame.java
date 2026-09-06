package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.User;
import service.UserService;

public class LoginFrame extends JFrame {

	private JTextField txtUsername;
	private JPasswordField txtPassword;

	private JButton btnLogin;
	private JButton btnExit;

	private UserService userService;

	public LoginFrame() {
		userService = new UserService();
		initialize();
		registerListeners();
	}

	private void initialize() {

		setTitle("Library Management System");
		setSize(500, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		setLayout(new BorderLayout());
		getContentPane().setBackground(new Color(245, 245, 245));

		// Title Panel
		
		JPanel titlePanel = new JPanel(new BorderLayout());
		titlePanel.setBackground(new Color(245, 245, 245));
		titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

		JLabel lblTitle = new JLabel("Library Management System");
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblSubtitle = new JLabel("Administrator Login");
		lblSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSubtitle.setForeground(Color.GRAY);
		lblSubtitle.setHorizontalAlignment(SwingConstants.CENTER);

		titlePanel.add(lblTitle, BorderLayout.CENTER);
		titlePanel.add(lblSubtitle, BorderLayout.SOUTH);

		add(titlePanel, BorderLayout.NORTH);

		// Form Panel		
		JPanel formPanel = new JPanel(new GridBagLayout());
		formPanel.setBackground(new Color(245, 245, 245));
		formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 15, 15, 15);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Username Label

		gbc.gridx = 0;
		gbc.gridy = 0;
		formPanel.add(new JLabel("Username"), gbc);

		// Username TextField

		gbc.gridx = 1;
		txtUsername = new JTextField(20);
		formPanel.add(txtUsername, gbc);

		// Password Label

		gbc.gridx = 0;
		gbc.gridy = 1;
		formPanel.add(new JLabel("Password"), gbc);

		// Password Field

		gbc.gridx = 1;
		txtPassword = new JPasswordField(20);
		formPanel.add(txtPassword, gbc);

		add(formPanel, BorderLayout.CENTER);

		// Button Panel
		
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.setBackground(new Color(245, 245, 245));

		btnLogin = new JButton("Login");
		btnLogin.setPreferredSize(new Dimension(100, 35));
		btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnExit = new JButton("Exit");
		btnExit.setPreferredSize(new Dimension(100, 35));
		btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));

		buttonPanel.add(btnLogin);
		buttonPanel.add(btnExit);

		add(buttonPanel, BorderLayout.SOUTH);
	}

	private void registerListeners() {

		btnLogin.addActionListener(e -> attemptLogin());

		btnExit.addActionListener(e -> System.exit(0));
	}

	private void attemptLogin() {

		String username = txtUsername.getText().trim();
		String password = new String(txtPassword.getPassword());

		if (username.isEmpty() || password.isEmpty()) {

			JOptionPane.showMessageDialog(
					this,
					"Please enter both username and password.",
					"Invalid Input",
					JOptionPane.ERROR_MESSAGE);

			return;
		}

		User user = userService.getUserByUsername(username);

		if (user == null || !user.getPassword().equals(password)) {

			JOptionPane.showMessageDialog(
					this,
					"Invalid username or password.",
					"Login Failed",
					JOptionPane.ERROR_MESSAGE);

			return;
		}

		dispose();

		new DashboardFrame(user).setVisible(true);
	}

}