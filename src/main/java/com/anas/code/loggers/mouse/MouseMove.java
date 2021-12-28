package com.anas.code.loggers.mouse;

import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;

import java.awt.*;

public class MouseMove {

    public static enum Type {
        MOVED,
        DRAGGED;
    }
    private int x;
    private int y;
    private Type type;

    // Constructor
    public MouseMove(NativeMouseEvent event, Type type) {
        this.x = event.getX();
        this.y = event.getY();
        this.type = type;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Type getType() {
        return type;
    }

    // Get point function
    public Point getPoint() {
        return new Point(x, y);
    }

    // Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
