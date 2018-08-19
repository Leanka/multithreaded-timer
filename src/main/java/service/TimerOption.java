package service;

public interface TimerOption {
    void showAllTimers();
    void showTimer(String name);
    void startTimer(String name);
    void stopTimer(String name);
    void pauseTimer(String name);
    void unpauseTimer(String name);
    void terminateTimers();
}
