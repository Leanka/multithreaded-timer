package controller;

import model.Timer;
import timer.TimerFactory;

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

}
