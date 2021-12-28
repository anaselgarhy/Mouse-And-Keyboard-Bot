package com.anas.code.loggers.keyboard;

import com.anas.code.loggers.Key;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

public class KeyboardKey extends NativeKeyEvent implements Key {
    private long pressTime; // time when key was pressed
    private long releaseTime; // time when key was released

    // Constructor.
    // Copy constructor.
    public KeyboardKey(NativeKeyEvent key) {
        super(key.getID(),
                key.getModifiers(),
                key.getKeyLocation(),
                key.getKeyCode(),
                key.getKeyChar(),
                key.getKeyLocation());
    }

    // Getters.
    @Override
    public String getKeyName() {
        return getKeyText(super.getKeyCode());
    }
    @Override
    public int getCode() {
        return this.getKeyCode();
    }

    // Get duration of key press.
    @Override
    public long getDuration() {
        return releaseTime - pressTime;
    }

    @Override
    public long getPressTime() {
        return pressTime;
    }
    @Override
    public long getReleaseTime() {
        return releaseTime;
    }

    // Setters.
    @Override
    public void setPressTime(long pressedTime) {
        this.pressTime = pressedTime;
    }
    @Override
    public void setReleaseTime(long releasedTime) {
        this.releaseTime = releasedTime;
    }

    @Override
    public String toString() {
        return Key.super.toString(this);
    }
}
