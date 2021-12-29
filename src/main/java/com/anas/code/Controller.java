package com.anas.code;

public class Controller {

    // Singleton pattern
    private static Controller instance = null;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void startRecording() {
        System.out.println("Recording started");
    }

    public void stopRecording() {
        System.out.println("Recording stopped");
    }

    public void play() {
        System.out.println("Playing");
    }

    public void pause() {
        System.out.println("Paused");
    }

    public void stop() {
        System.out.println("Stopped");
    }

    public void skip(int id) {
        System.out.println("Skipped: " + id);
    }
}
