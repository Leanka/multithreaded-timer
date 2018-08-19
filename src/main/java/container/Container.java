package container;

import model.Timer;

public interface Container {
    void addTimer(Timer timer);
    Timer getTimer(String name);
    void closeAllTimers();
    Timer [] getAllTimers();
    boolean isNameAvailable(String name);
}
