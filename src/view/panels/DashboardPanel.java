package view.panels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DashboardPanel extends JPanel {

    public DashboardPanel(Consumer<String> navigationHandler) {

        setLayout(new BorderLayout());

        setBorder(
                BorderFactory.createEmptyBorder(
                        30, 40, 30, 40));

        // ===========================
        // Welcome Section
        // ===========================

        JPanel welcomePanel = new JPanel(new BorderLayout());

        JLabel lblWelcome = new JLabel(
                "Welcome to Library Management System");

        lblWelcome.setFont(
                new Font("Segoe UI", Font.BOLD, 28));

        lblWelcome.setHorizontalAlignment(
                SwingConstants.CENTER);

        JLabel lblDescription = new JLabel(
                "Manage books, members, issues, returns and fines from one place.");

        lblDescription.setFont(
                new Font("Segoe UI", Font.PLAIN, 15));

        lblDescription.setHorizontalAlignment(
                SwingConstants.CENTER);

        welcomePanel.add(
                lblWelcome,
                BorderLayout.NORTH);

        welcomePanel.add(
                lblDescription,
                BorderLayout.CENTER);

        add(
                welcomePanel,
                BorderLayout.NORTH);

        // ===========================
        // Cards Panel
        // ===========================

        JPanel cardsPanel = new JPanel(
                new GridLayout(2, 3, 20, 20));

        cardsPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        30, 0, 0, 0));

        cardsPanel.add(createCard(
                "Books",
                "Manage library books",
                "Books",
                navigationHandler));

        cardsPanel.add(createCard(
                "Members",
                "Manage library members",
                "Members",
                navigationHandler));

        cardsPanel.add(createCard(
                "Issue Book",
                "Issue books to members",
                "Issue",
                navigationHandler));

        cardsPanel.add(createCard(
                "Return Book",
                "Manage book returns",
                "Return",
                navigationHandler));

        cardsPanel.add(createCard(
                "Fine",
                "Manage library fines",
                "Fine",
                navigationHandler));

        cardsPanel.add(createCard(
                "Users",
                "Manage system users",
                "Users",
                navigationHandler));

        add(
                cardsPanel,
                BorderLayout.CENTER);
    }

    // ===========================
    // Card Creation
    // ===========================

    private JPanel createCard(
            String title,
            String description,
            String panelName,
            Consumer<String> navigationHandler) {

        JPanel card = new JPanel(new BorderLayout());

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(210, 210, 210)),
                        BorderFactory.createEmptyBorder(
                                20, 20, 20, 20)));

        // Card title

        JLabel lblTitle = new JLabel(title);

        lblTitle.setFont(
                new Font("Segoe UI", Font.BOLD, 20));

        // Card description

        JLabel lblDescription = new JLabel(description);

        lblDescription.setFont(
                new Font("Segoe UI", Font.PLAIN, 14));

        // Open button

        JButton btnOpen = new JButton("Open");

        btnOpen.setFocusPainted(false);

        // ===========================
        // Navigation
        // ===========================

        btnOpen.addActionListener(e ->
                navigationHandler.accept(panelName));

        // Text panel

        JPanel textPanel = new JPanel(
                new BorderLayout());

        textPanel.add(
                lblTitle,
                BorderLayout.NORTH);

        textPanel.add(
                lblDescription,
                BorderLayout.CENTER);

        card.add(
                textPanel,
                BorderLayout.CENTER);

        card.add(
                btnOpen,
                BorderLayout.SOUTH);

        return card;
    }
}