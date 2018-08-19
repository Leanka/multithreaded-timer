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
    public void stopTimer(String name) {
        if(!container.isNameAvailable(name)){
            Timer timer = container.getTimer(name);
            if(timer.isStopped()){
                view.printWarning(String.format("Timer \"%s\" is already stopped!", name));
            }else {
                controller.stopTimer(timer);
            }
        }else {
            view.printWarning(String.format("No such timer as \"%s\"!", name));
        }
    }

    @Override
    public void pauseTimer(String name) {
        if(container.isNameAvailable(name)){
            Timer timer = container.getTimer(name);
            if(timer.isStopped()){
                view.printWarning("Cannot pause stopped timer!");
            }else if(timer.isPaused()){
                view.printWarning("Cannot pause paused timer!");
            }else {
                controller.pauseTimer(timer);
            }
        }else{
            view.printWarning(String.format("No such timer as \"%s\"!", name));
        }
    }

    @Override
    public void unpauseTimer(String name) {
        if(container.isNameAvailable(name)){
            Timer timer = container.getTimer(name);
            if(timer.isStopped()){
                view.printWarning("Cannot unpause stopped timer!");
            }else if(!timer.isPaused()){
                view.printWarning("Cannot unpause unpaused timer!");
            }else {
                controller.pauseTimer(timer);
            }
        }else{
            view.printWarning(String.format("No such timer as \"%s\"!", name));
        }
    }

    @Override
    public void restartTimer(String name) {
        if(!container.isNameAvailable(name)){
            Timer timer = container.getTimer(name);
            controller.stopTimer(timer); //in case it was not stopped before
            controller.restartTimer(timer);
        }else {
            view.printWarning(String.format("No such timer as \"%s\"!", name));
        }
    }

    @Override
    public void terminateTimers() {
        container.terminateAllTimers();
    }
}
