package service;

public interface TimerOption {
    void showAllTimers();
    void showTimer(String name);
    void startTimer(String name);
    void stopTimer(String string);
    void pauseTimer(String name);
    void restartTimer(String name);
}
