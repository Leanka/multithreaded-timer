package container;

import model.Timer;

public interface Container {
    void addTimer(Timer timer);
    Timer getTimer(String name);
    void terminateAllTimers();
    Timer [] getAllTimers();
    boolean isNameAvailable(String name);
}
