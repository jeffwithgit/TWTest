package com.thoughtworks;

/**
 * 会议建模
 */
public class Session {
    private String name;

    private int timeDuration;

    public Session(String name, int timeDuration) {
        this.name = name;
        this.timeDuration = timeDuration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(int timeDuration) {
        this.timeDuration = timeDuration;
    }

    @Override
    public String toString() {
        return "Session{" +
                "name='" + name + '\'' +
                ", timeDuration=" + timeDuration +
                '}';
    }
}
