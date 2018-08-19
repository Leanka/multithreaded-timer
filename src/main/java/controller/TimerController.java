package controller;

import model.Timer;

public interface TimerController {
    void startTimer(Timer timer);
    void stopTimer(Timer timer);
    void pauseTimer(Timer timer);
}
