package com.anas.code.loggers;

public interface Key {
    // Getters.
    public String getKeyName();
    public int getCode();

    // Get duration of key press.
    public long getDuration();

    public long getPressTime();
    public long getReleaseTime();

    // Setters.
    public void setPressTime(long pressTime);
    public void setReleaseTime(long releaseTime);

    // toString method.
    default public String toString(Key key) {
        return "Key{" +
                "keyName='" + key.getKeyName() + '\'' +
                ", code=" + key.getCode() +
                ", pressedTime=" + getPressTime() +
                ", releasedTime=" + getPressTime() +
                ", duration=" + getDuration() +
                '}';
    }
}
