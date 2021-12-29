package com.anas.code.gui.mainWindow;

import com.anas.code.Controller;

public class MainWindowController {
    private final MainWindow mainWindow;
    private final Controller controller;

    // Singleton pattern.
    // Singleton instance.
    private static MainWindowController instance;
    private MainWindowController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        controller = Controller.getInstance();
        addEventsHandlers();
    }

    // Instance getter.
    public static MainWindowController getInstance(MainWindow mainWindow) {
        if (instance == null) {
            instance = new MainWindowController(mainWindow);
        }
        return instance;
    }

    private void addEventsHandlers() {
        // CheckBox's events
        addCheckBoxesHandlers();
        // Button's events
        addButtonsHandlers();
    }

    private void addCheckBoxesHandlers() {
        mainWindow.mouseCheckBox.addActionListener(event -> {

        });
        mainWindow.keyboardCheckBox.addActionListener(event -> {

        });
    }

    private void addButtonsHandlers() {
        mainWindow.startRecodingButton.addActionListener(event -> {
            controller.startRecording();
        });
        mainWindow.stopRecordingButton.addActionListener(event -> {
            controller.stopRecording();
        });
        mainWindow.playButton.addActionListener(event -> {
            controller.play();
        });
        mainWindow.stopPlayButton.addActionListener(event -> {
            controller.stop();
        });
    }

    public void addEventToTable(String event) {
        var temp = event.split(",");
        mainWindow.tableModel.addRow(temp);
    }
}
