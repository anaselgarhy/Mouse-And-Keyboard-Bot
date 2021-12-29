package com.anas.code;

import com.anas.code.gui.mainWindow.MainWindow;

public class Main {
    public static void main(String[] args) {
        Controller controller = Controller.getInstance();
        new MainWindow();
    }
}
