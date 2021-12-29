package com.anas.code.gui.mainWindow;

import javax.swing.*;

public class MainWindow extends JFrame {
    // TODO: Add your GUI components here
    // private Container container; // Container of the window
    // private GroupLayout layout; // Layout manager
    protected JTable eventsTable; // Table of events
    protected JScrollPane eventsTableScrollPane; // Scroll pane of the table
    protected JCheckBox mouseCheckBox, keyboardCheckBox; // Check boxes for mouse and keyboard events
    protected JButton startButton, stopButton; // Buttons for start and stop recording
    public MainWindowController controller; // Controller of the window

    // Constructor.
    public MainWindow() {
        // Initialize the components.
        initComponents();
        // Initialize the window.
        initWindow();

        // Add the controller to the window.
        controller = new MainWindowController(this);
    }

    // Initializes the window components.
    private void initComponents() {
        // Initialize the container.
       // container = getContentPane();
        // Initialize the layout manager.
        // layout = new GroupLayout(container);
        // Set the layout manager to the container.
        // container.setLayout(layout);
        // Active auto-generated gaps.
        // layout.setAutoCreateGaps(true);
        // Active auto-generated sizes.
        // layout.preferredLayoutSize(container);
        // initialize the table.
        eventsTable = new JTable(0, 3);
        // Initialize the scroll pane.
        eventsTableScrollPane = new JScrollPane(eventsTable);
        // Initialize the check boxes.
        mouseCheckBox = new JCheckBox("Recorde Mouse");
        keyboardCheckBox = new JCheckBox("Recorde Keyboard");
        // Initialize the buttons.
        startButton = new JButton("Start Recording");
        stopButton = new JButton("Stop Recording");
    }

    // Initializes the window.
    private void initWindow() {
        setTitle("Recorder");
        setSize(600, 500);
        // Set the location of the window to the center of the screen.
        setLocationRelativeTo(null);
        // Set the layout manager.
        setLayout(null);
        // Set the default close operation to exit the application.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Add the components to the window.
        addComponents();
        // Show the window.
        setVisible(true);
    }

    // Adds the components to the window.
    private void addComponents() {

        // Set the bounds of the components.
        eventsTableScrollPane.setBounds(10, 10, 300, 300);
        mouseCheckBox.setBounds(320, 10, 200, 20);
        keyboardCheckBox.setBounds(320, 40, 200, 20);
        startButton.setBounds(320, 70, 200, 20);
        stopButton.setBounds(320, 100, 200, 20);
        // Add the components to the window.
        add(eventsTableScrollPane);
        add(mouseCheckBox);
        add(keyboardCheckBox);
        add(startButton);
        add(stopButton);
/*        // Add the components to the window.
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(eventsTableScrollPane))
                // Add preferred gaps.
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(eventsTableScrollPane, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(mouseCheckBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, 20)
                                .addComponent(keyboardCheckBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, 20)
                                .addComponent(startButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, 20)
                                .addComponent(stopButton)
                                .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap());

        // Add buttons to the group.
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(eventsTableScrollPane)
                )
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        */
    }

    // Test main method.
    public static void main(String[] args) {
        new MainWindow();
    }
}
