package com.anas.code.loggers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Logger implements Runnable {
    protected ArrayList<Key> keys; // list of keys pressed
    protected Map<Integer, Integer> keyBuffer; // map of key codes to key codes temporarily


    public Logger() {
        keys = new ArrayList<>(); // initialize keys array list
        keyBuffer = new HashMap<>(); // initialize key buffer hash map
    }

    // Add a key to the list of keys pressed method
    public void addKey(Key key) {
        keys.add(key);
    }

    // Remove a key from the list of keys pressed method
    public void removeKey(Key key) {
        keys.remove(key);
    }

    // Get the specific key from the list of keys pressed method
    public Key getKey(int index) {
        return keys.get(index);
    }

    // Get current index
    public int getIndex() {
        return keys.size() - 1;
    }

    // Start logging method
    public abstract void start();

    // Stop logging method
    public abstract void stop();
}
