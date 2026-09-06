package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.SwingConstants;

import view.panels.BookPanel;
import view.panels.DashboardPanel;
import view.panels.FinePanel;
import view.panels.IssuePanel;
import view.panels.MemberPanel;
import view.panels.ReturnPanel;
import view.panels.UserPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.BookController;
import controller.FineController;
import controller.IssueController;
import controller.MemberController;
import controller.ReturnController;
import controller.UserController;
import model.User;

public class DashboardFrame extends JFrame {

	private JPanel headerPanel;
	private JPanel sidebarPanel;
	private JPanel contentPanel;
	private CardLayout cardLayout;
	private JButton btnDashboard;
	private JButton btnBooks;
	private JButton btnMembers;
	private JButton btnIssue;
	private JButton btnReturn;
	private JButton btnFine;
	private JButton btnUsers;
	private JButton btnLogout;

	private User currentUser;

	public DashboardFrame(User currentUser) {
		this.currentUser = currentUser;
		initialize();
	}

	private JButton createSidebarButton(String text) {

	    JButton button = new JButton(text);

	    button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
	    button.setPreferredSize(new Dimension(200, 45));

	    button.setFont(new Font("Segoe UI", Font.PLAIN, 15));

	    button.setHorizontalAlignment(SwingConstants.LEFT);

	    button.setFocusPainted(false);
	    button.setBorderPainted(false);
	    button.setContentAreaFilled(false);

	    button.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    button.setAlignmentX(Component.CENTER_ALIGNMENT);

	    button.setBorder(
	            BorderFactory.createEmptyBorder(0, 15, 0, 10));

	    return button;
	}
	private void registerListeners() {

	    btnDashboard.addActionListener(e -> {
	        cardLayout.show(contentPanel, "Dashboard");
	        setActiveButton(btnDashboard);
	    });

	    btnBooks.addActionListener(e -> {
	        cardLayout.show(contentPanel, "Books");
	        setActiveButton(btnBooks);
	    });

	    btnMembers.addActionListener(e -> {
	        cardLayout.show(contentPanel, "Members");
	        setActiveButton(btnMembers);
	    });

	    btnIssue.addActionListener(e -> {
	        cardLayout.show(contentPanel, "Issue");
	        setActiveButton(btnIssue);
	    });

	    btnReturn.addActionListener(e -> {
	        cardLayout.show(contentPanel, "Return");
	        setActiveButton(btnReturn);
	    });

	    btnFine.addActionListener(e -> {
	        cardLayout.show(contentPanel, "Fine");
	        setActiveButton(btnFine);
	    });

	    btnUsers.addActionListener(e -> {
	        cardLayout.show(contentPanel, "Users");
	        setActiveButton(btnUsers);
	    });

	    btnLogout.addActionListener(e -> {
	        dispose();
	        new LoginFrame().setVisible(true);
	    });
	}
	private void setActiveButton(JButton activeButton) {

	    JButton[] buttons = {
	            btnDashboard,
	            btnBooks,
	            btnMembers,
	            btnIssue,
	            btnReturn,
	            btnFine,
	            btnUsers
	    };

	    for (JButton button : buttons) {

	        button.setContentAreaFilled(false);
	        button.setBackground(null);

	        button.setFont(
	                new Font("Segoe UI", Font.PLAIN, 15));
	    }

	    activeButton.setContentAreaFilled(true);
	    activeButton.setBackground(new Color(220, 230, 250));

	    activeButton.setFont(
	            new Font("Segoe UI", Font.BOLD, 15));
	}

	private void showPanel(String panelName) {

	    cardLayout.show(contentPanel, panelName);

	    switch (panelName) {

	        case "Dashboard":
	            setActiveButton(btnDashboard);
	            break;

	        case "Books":
	            setActiveButton(btnBooks);
	            break;

	        case "Members":
	            setActiveButton(btnMembers);
	            break;

	        case "Issue":
	            setActiveButton(btnIssue);
	            break;

	        case "Return":
	            setActiveButton(btnReturn);
	            break;

	        case "Fine":
	            setActiveButton(btnFine);
	            break;

	        case "Users":
	            setActiveButton(btnUsers);
	            break;
	    }
	}
	private void initialize() {

		// Frame Settings

		setTitle("Library Management System");
		setSize(1100, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);

		setLayout(new BorderLayout());

		// Header Panel

		headerPanel = new JPanel(new BorderLayout());
		headerPanel.setPreferredSize(new Dimension(0, 70));
		headerPanel.setBackground(new Color(30, 58, 138));

		JLabel lblTitle = new JLabel("Library Management System");
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblTitle.setForeground(Color.WHITE);

		JLabel lblWelcome = new JLabel("Welcome, " + currentUser.getFullName());
		lblWelcome.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblWelcome.setForeground(Color.WHITE);

		headerPanel.add(lblTitle, BorderLayout.WEST);
		headerPanel.add(lblWelcome, BorderLayout.EAST);

		headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));

		// Sidebar Panel

		sidebarPanel = new JPanel();
		sidebarPanel.setPreferredSize(new Dimension(220, 0));
		sidebarPanel.setBackground(new Color(245, 245, 245));
		sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
		sidebarPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

		btnDashboard = createSidebarButton("Dashboard");
		btnBooks = createSidebarButton("Books");
		btnMembers = createSidebarButton("Members");
		btnIssue = createSidebarButton("Issue Book");
		btnReturn = createSidebarButton("Return Book");
		btnFine = createSidebarButton("Fine");
		btnUsers = createSidebarButton("Users");
		btnLogout = createSidebarButton("Logout");

		sidebarPanel.add(btnDashboard);
		sidebarPanel.add(Box.createVerticalStrut(10));

		sidebarPanel.add(btnBooks);
		sidebarPanel.add(Box.createVerticalStrut(10));

		sidebarPanel.add(btnMembers);
		sidebarPanel.add(Box.createVerticalStrut(10));

		sidebarPanel.add(btnIssue);
		sidebarPanel.add(Box.createVerticalStrut(10));

		sidebarPanel.add(btnReturn);
		sidebarPanel.add(Box.createVerticalStrut(10));

		sidebarPanel.add(btnFine);
		sidebarPanel.add(Box.createVerticalStrut(10));

		sidebarPanel.add(btnUsers);

		sidebarPanel.add(Box.createVerticalGlue());

		sidebarPanel.add(btnLogout);

		// Content Panel
		cardLayout = new CardLayout();

		contentPanel = new JPanel(cardLayout);
		contentPanel.setBackground(Color.WHITE);

		// Add all panels to CardLayout

		contentPanel.add(new DashboardPanel(this::showPanel), "Dashboard");
		        
		BookPanel bookPanel = new BookPanel();
		contentPanel.add(bookPanel, "Books");
		new BookController(bookPanel);
		
		MemberPanel memberPanel = new MemberPanel();
		contentPanel.add(memberPanel, "Members");
		new MemberController(memberPanel);

		IssuePanel issuePanel = new IssuePanel();
		contentPanel.add(issuePanel, "Issue");
		new IssueController(issuePanel, currentUser.getUserId());

		ReturnPanel returnPanel = new ReturnPanel();
		contentPanel.add(returnPanel, "Return");
		new ReturnController(returnPanel);

		FinePanel finePanel = new FinePanel();
		contentPanel.add(finePanel, "Fine");
		new FineController(finePanel, currentUser.getUserId());

		UserPanel userPanel = new UserPanel();
		contentPanel.add(userPanel, "Users");
		new UserController(userPanel);

		// Show Dashboard first

		cardLayout.show(contentPanel, "Dashboard");
		// Add Panels to Frame

		add(headerPanel, BorderLayout.NORTH);
		add(sidebarPanel, BorderLayout.WEST);
		add(contentPanel, BorderLayout.CENTER);

		registerListeners();

		setActiveButton(btnDashboard);

	}

}