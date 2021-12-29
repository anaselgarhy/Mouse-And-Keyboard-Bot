package com.anas.code.loggers.mouse;

import com.anas.code.loggers.Key;
import com.anas.code.loggers.Logger;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.mouse.*;

import java.util.ArrayList;

public class MouseLogger extends Logger implements NativeMouseListener, NativeMouseMotionListener, NativeMouseWheelListener {
    private ArrayList<MouseWheel> wheelEvents;
    private ArrayList<MouseMove> mouseMoves;

    // Singleton pattern.
    // The instance of the class.
    private static MouseLogger instance = null;
    // Constructor
    private MouseLogger() {
        super();
        wheelEvents = new ArrayList<>();
        mouseMoves = new ArrayList<>();
    }

    // Get the instance of the class.
    public static MouseLogger getInstance() {
        if (instance == null) {
            instance = new MouseLogger();
        }
        return instance;
    }

    @Override
    public void start() {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        // Remove the listeners from the native system.
        GlobalScreen.removeNativeMouseListener(this);
        GlobalScreen.removeNativeMouseMotionListener(this);
        GlobalScreen.removeNativeMouseWheelListener(this);
        // Unregister the native hook.
        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        start();
        // Add the listeners to the native system.
        GlobalScreen.addNativeMouseListener(this);
        GlobalScreen.addNativeMouseMotionListener(this);
        GlobalScreen.addNativeMouseWheelListener(this);
    }

    @Override
    public void nativeMouseClicked(NativeMouseEvent nativeEvent) {
        System.out.println("Mouse clicked");

    }

    @Override
    public void nativeMousePressed(NativeMouseEvent nativeEvent) {
        MouseKey key = new MouseKey(nativeEvent);

        // Set the key to pressed time
        key.setPressTime(System.currentTimeMillis());

        // Add the key to the buffer
        keyBuffer.put(key.getCode(), getIndex());
        // Add the key to the list
        addKey(key);

        // Print list of keys
        for (Key key1y : keys) {
            System.out.println(key1y);
        }
        System.out.println("---------------------------------");

        // Print list of wheel events
        for (NativeMouseWheelEvent wheelEvent : wheelEvents) {
            System.out.println(wheelEvent);
        }
        System.out.println("---------------------------------");

        // Print list of mouse moves
        for (MouseMove mouseMove : mouseMoves) {
            System.out.println(mouseMove.getX() + " " + mouseMove.getY());
        }
        System.out.println("---------------------------------");
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nativeEvent) {
        MouseKey key = new MouseKey(nativeEvent);

        // Set the key to released time
        getKey(keyBuffer.get(key.getCode())).setReleaseTime(System.currentTimeMillis());

        // Remove the key from the buffer
        keyBuffer.remove(key.getCode());
    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent nativeEvent) {
        mouseMoves.add(new MouseMove(nativeEvent, MouseMove.Type.MOVED));
    }

    @Override
    public void nativeMouseDragged(NativeMouseEvent nativeEvent) {
        mouseMoves.add(new MouseMove(nativeEvent, MouseMove.Type.DRAGGED));
    }

    @Override
    public void nativeMouseWheelMoved(NativeMouseWheelEvent nativeEvent) {
        wheelEvents.add(new MouseWheel(nativeEvent));
    }

    // Test main
    public static void main(String[] args) {
        MouseLogger logger = new MouseLogger();
        logger.run();
    }
}
