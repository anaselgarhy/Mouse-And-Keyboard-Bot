package com.anas.code.loggers.keyboard;

import com.anas.code.loggers.Key;
import com.anas.code.loggers.Logger;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class KeyboardLogger extends Logger implements NativeKeyListener {

    // Singleton pattern.
    // The instance of the logger.
    private static KeyboardLogger instance = null;

    // The constructor.
    private KeyboardLogger() {
        super();
    }

    // The getInstance method.
    public static KeyboardLogger getInstance() {
        if (instance == null) {
            instance = new KeyboardLogger();
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
        // Add the key listeners.
        GlobalScreen.addNativeKeyListener(this);
    }

    @Override
    public void stop() {
        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // Start the logger.
        this.start();
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        // Check if the key is not already in the buffer or the buffer is empty.
        if (!keyBuffer.containsKey(nativeKeyEvent.getKeyCode()) || keyBuffer.isEmpty()) {
            // Store the key pressed.
            KeyboardKey key = new KeyboardKey(nativeKeyEvent);
            // Add current time to the key.
            key.setPressTime(System.currentTimeMillis());
            // print current time.
            System.out.println("key.getPressedTime() = " + key.getPressTime());
            // Add the key to the list of keys.
            addKey(key);
            // Add the key to buffer.
            keyBuffer.put(nativeKeyEvent.getKeyCode(), getIndex());
            System.out.println("Key pressed.");
        }

        // Test
        if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            // Print the list of keys.
            for (Key k : keys) {
                System.out.println(k);
            }
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        // Add current time to the key.
        getKey(keyBuffer.get(nativeKeyEvent.getKeyCode())).setReleaseTime(System.currentTimeMillis());
        // print current time.
        System.out.println("key.getReleasedTime() = " + getKey(keyBuffer.get(nativeKeyEvent.getKeyCode())).getReleaseTime());
        // Remove the key from the buffer.
        keyBuffer.remove(nativeKeyEvent.getKeyCode());
        System.out.println("Key released.");
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    // Test main

    public static void main(String[] args) {
        KeyboardLogger logger = new KeyboardLogger();
        logger.start();
    }
}