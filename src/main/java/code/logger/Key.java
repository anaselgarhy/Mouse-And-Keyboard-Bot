package code.logger;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

public class Key {
    public enum From {
        KEYBOARD,
        MOUSE
    }
    private String keyName; // key name
    private int code; // key code
    private From from; // key from (keyboard or mouse)
    private long pressedTime; // time when key was pressed
    private long releasedTime; // time when key was released

    // Constructor.
    public Key(int code, From from) {
        this.keyName = NativeKeyEvent.getKeyText(code);
        this.code = code;
        this.from = from;
    }

    // Getters.
    public String getKeyName() {
        return keyName;
    }
    public int getCode() {
        return code;
    }
    public From getFrom() {
        return from;
    }
    public long getPressedTime() {
        return pressedTime;
    }
    public long getReleasedTime() {
        return releasedTime;
    }

    // Setters.
    public void setPressedTime(long pressedTime) {
        this.pressedTime = pressedTime;
    }
    public void setReleasedTime(long releasedTime) {
        this.releasedTime = releasedTime;
    }

    // toString method.

    @Override
    public String toString() {
        return "Key{" +
                "keyName='" + keyName + '\'' +
                ", code=" + code +
                ", from=" + from +
                ", pressedTime=" + pressedTime +
                ", releasedTime=" + releasedTime +
                '}';
    }
}
