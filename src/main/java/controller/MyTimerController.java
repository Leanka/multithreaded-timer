package controller;

import model.MyTimer;
import model.Timer;

public class MyTimerController implements TimerController {

    public void startTimer(Timer timer) {
        timer.start();
    }

    public void stopTimer(Timer timer) {
        timer.stopTimer();
    }

    public void pauseTimer(Timer timer) {
        timer.pauseTimer();
    }

    public void restartTimer(Timer timer) {
        timer = new MyTimer(timer.getName());
        timer.start();
    }
}
