package com.anas.code;

import com.anas.code.loggers.Logger;
import com.anas.code.loggers.keyboard.KeyboardLogger;
import com.anas.code.loggers.mouse.MouseLogger;

public class Recoder {
    // Flags
    private boolean isRecording = false;
    private boolean mouseRecording = false;
    private boolean keyboardRecording = false;
    private boolean isPaused = false;
    private boolean recordMouseMovement = false;

    // Variables
    private Logger mouseLogger, keyboardLogger; // Loggers

    // Singleton pattern
    private static Recoder instance = null;

    private Recoder() {
        mouseLogger = MouseLogger.getInstance();
        keyboardLogger = KeyboardLogger.getInstance();
    }

    public static Recoder getInstance() {
        if (instance == null) {
            instance = new Recoder();
        }
        return instance;
    }
}
