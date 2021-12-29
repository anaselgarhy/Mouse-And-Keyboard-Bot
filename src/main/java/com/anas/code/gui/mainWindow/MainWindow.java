package com.anas.code.gui.mainWindow;

import javax.swing.*;

public class MainWindow extends JFrame {
    // TODO: Add your GUI components here
    protected JTable eventsTable; // Table of events
    protected JScrollPane eventsTableScrollPane; // Scroll pane of the table
    protected JCheckBox mouseCheckBox, keyboardCheckBox; // Check boxes for mouse and keyboard events
    protected JButton startRecodingButton, stopRecordingButton; // Buttons for start and stop recording
    protected JButton playButton, stopPlayButton; // Buttons for start and stop playing
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
        // initialize the table.
        eventsTable = new JTable(0, 3);
        // Initialize the scroll pane.
        eventsTableScrollPane = new JScrollPane(eventsTable);
        // Initialize the check boxes.
        mouseCheckBox = new JCheckBox("Recorde Mouse");
        keyboardCheckBox = new JCheckBox("Recorde Keyboard");
        // Initialize the buttons.
        startRecodingButton = new JButton("Start Recording");
        stopRecordingButton = new JButton("Stop Recording");
        playButton = new JButton("Play");
        stopPlayButton = new JButton("Stop");
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
        startRecodingButton.setBounds(320, 70, 200, 20);
        stopRecordingButton.setBounds(320, 100, 200, 20);
        playButton.setBounds(320, 130, 200, 20);
        stopPlayButton.setBounds(320, 160, 200, 20);
        // Add the components to the window.
        add(eventsTableScrollPane);
        add(mouseCheckBox);
        add(keyboardCheckBox);
        add(startRecodingButton);
        add(stopRecordingButton);
        add(playButton);
        add(stopPlayButton);
    }

    // Test main method.
    public static void main(String[] args) {
        new MainWindow();
    }
}
