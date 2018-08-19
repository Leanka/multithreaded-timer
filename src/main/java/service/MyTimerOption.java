package service;

import container.Container;
import controller.TimerController;
import model.Timer;
import view.TimerView;

public class MyTimerOption implements TimerOption{
    private TimerController controller;
    private Container container;
    private TimerView view;

    public MyTimerOption(TimerController controller, Container timerContainer, TimerView view) {
        this.controller = controller;
        this.container = timerContainer;
        this.view = view;
    }

    @Override
    public void showAllTimers() {

    }

    @Override
    public void showTimer(String name) {

    }

    @Override
    public void startTimer(String name) {

    }

    @Override
    public void stopTimer(String string) {

    }

    @Override
    public void pauseTimer(String name) {

    }

    @Override
    public void restartTimer(String name) {
        if(!container.isNameAvailable(name)){
            Timer timer = container.getTimer(name);
            controller.stopTimer(timer); //in case it was not stopped before
            controller.restartTimer(timer);
        }else {
            view.printWarning(String.format("No such timer as \"%s\"!"));
        }
    }

    @Override
    public void terminateTimers() {
        container.terminateAllTimers();
    }
}
