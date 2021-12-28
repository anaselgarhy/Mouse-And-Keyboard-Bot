package com.anas.code.loggers.mouse;

import com.anas.code.loggers.Key;
import com.github.kwhat.jnativehook.mouse.NativeMouseWheelEvent;

public class MouseWheel extends NativeMouseWheelEvent implements Key {

    // Copy constructor
    public MouseWheel(NativeMouseWheelEvent nativeEvent) {
        super(nativeEvent.getID(),
                nativeEvent.getModifiers(),
                nativeEvent.getX(),
                nativeEvent.getY(),
                nativeEvent.getClickCount(),
                nativeEvent.getScrollType(),
                nativeEvent.getScrollAmount(),
                nativeEvent.getWheelRotation(),
                nativeEvent.getWheelDirection());
    }

    @Override
    public String getKeyName() {
        return getModifiersText(super.getModifiers());
    }

    @Override
    public int getCode() {
        return super.getID();
    }

    @Override
    public long getDuration() {
        return 0;
    }

    @Override
    public long getPressTime() {
        return 0;
    }

    @Override
    public long getReleaseTime() {
        return 0;
    }

    @Override
    public void setPressTime(long pressedTime) {

    }

    @Override
    public void setReleaseTime(long releasedTime) {

    }

    @Override
    public String toString() {
        return Key.super.toString(this) + " " + getWheelRotation() + " " + getWheelDirection();
    }
}
