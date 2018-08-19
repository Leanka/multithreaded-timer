package service;

import container.Container;
import controller.TimerController;
import model.Timer;
import timer.TimerFactory;
import view.View;

import java.util.Arrays;

public class MyTimerOption implements TimerOption{
    private TimerController controller;
    private Container container;
    private View view;

    public MyTimerOption(TimerController controller, Container timerContainer, View view) {
        this.controller = controller;
        this.container = timerContainer;
        this.view = view;
    }

    @Override
    public void showAllTimers() {
        Timer [] timers = container.getAllTimers();
        if(timers.length == 0){
            view.printWarning("There are no timers yet!");
        }else{
            Arrays.stream(timers).forEach(view::printTimer);
        }
    }

    @Override
    public void showTimer(String name) {
        if(!container.isNameAvailable(name)){
            view.printTimer(container.getTimer(name));
        }else{
            view.printWarning(String.format("No such timer as \"%s\"!", name));
        }
    }

    @Override
    public void startTimer(String name) {
        if(container.isNameAvailable(name)){
            Timer timer = TimerFactory.getTimer(name);
            controller.startTimer(timer);
            container.addTimer(timer);
        }else {
            this.restartTimer(name);
        }

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
        if(!container.isNameAvailable(name)){
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
        if(!container.isNameAvailable(name)){
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

    private void restartTimer(String name) {
        if(!container.isNameAvailable(name)){
            Timer oldTimer = container.getTimer(name);
            controller.stopTimer(oldTimer); //in case it was not stopped before

            Timer newTimer = TimerFactory.getTimer(oldTimer.getName());
            controller.startTimer(newTimer);
            container.addTimer(newTimer);
        }else {
            view.printWarning(String.format("No such timer as \"%s\"!", name));
        }
    }

    @Override
    public void terminateTimers() {
        container.terminateAllTimers();
    }

    @Override
    public void showProgramOptions() {
        System.out.println("options to be implemented\n");
    }
}
