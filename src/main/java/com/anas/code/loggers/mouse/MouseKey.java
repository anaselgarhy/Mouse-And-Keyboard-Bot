package com.anas.code.loggers.mouse;

import com.anas.code.loggers.Key;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;

public class MouseKey extends NativeMouseEvent implements Key {
    private long pressedTime; // time when key was pressed
    private long releasedTime; // time when key was released

    // Copy constructor
    public MouseKey(NativeMouseEvent e) {
        super(e.getID(),
                e.getModifiers(),
                e.getX(),
                e.getY(),
                e.getClickCount(),
                e.getButton());
    }
    @Override
    public String getKeyName() {
        return getModifiersText(super.getModifiers());
    }

    @Override
    public int getCode() {
        return super.getButton();
    }

    @Override
    public long getDuration() {
        return releasedTime - pressedTime;
    }

    @Override
    public long getPressTime() {
        return pressedTime;
    }

    @Override
    public long getReleaseTime() {
        return releasedTime;
    }

    @Override
    public void setPressTime(long pressedTime) {
        this.pressedTime = pressedTime;
    }

    @Override
    public void setReleaseTime(long releasedTime) {
        this.releasedTime = releasedTime;
    }

    // To string
    @Override
    public String toString() {
        return Key.super.toString(this) + "\n X= " + super.getX() + " Y= " + super.getY();
    }
}
