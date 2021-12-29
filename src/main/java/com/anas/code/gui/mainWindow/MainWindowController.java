package com.anas.code.gui.mainWindow;

import com.anas.code.gui.mainWindow.MainWindow;

public record MainWindowController(MainWindow mainWindow) {
    public MainWindowController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        addEventsHandlers();
    }

    private void addEventsHandlers() {
        mainWindow.mouseCheckBox.addActionListener(event -> {
            if (mainWindow.mouseCheckBox.isSelected()) {
                mainWindow.mouseCheckBox.setText("Mouse: ON");
            } else {
                mainWindow.mouseCheckBox.setText("Mouse: OFF");
            }
        });
    }
}
