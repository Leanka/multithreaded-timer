package service;


import view.Input;
import view.View;

public class MyTimerService implements TimerService{
    private final int commandIndex = 0;
    private final int timerNameIndex = 1;
    private boolean isProgramRunning = true;
    private TimerOption option;
    private Input input;
    private View view;

    public MyTimerService(TimerOption option, Input input, View view) {
        this.option = option;
        this.input = input;
        this.view = view;
    }

    @Override
    public void runTimerService() {
        option.showProgramOptions();
        while(isProgramRunning){

            String [] userInput = input.getInput();
            if(userInput.length != 0){
                try{
                    this.programOptions(userInput);
                }catch (IndexOutOfBoundsException e){
                    view.printWarning(String.format("Timer name for option \"%s\" is required!%n", userInput[commandIndex]));
                }
            }else {
                option.showProgramOptions();
            }
        }
    }

    private void programOptions(String [] userInput) throws IndexOutOfBoundsException{
        switch(userInput[commandIndex].toUpperCase()){
            case "EXIT":
                option.terminateTimers();
                this.isProgramRunning = false;
                break;
            case "START":
                option.startTimer(userInput[timerNameIndex]);
                break;
            case "STOP":
                option.stopTimer(userInput[timerNameIndex]);
                break;
            case "PAUSE":
                option.pauseTimer(userInput[timerNameIndex]);
                break;
            case "UNPAUSE":
                option.unpauseTimer(userInput[timerNameIndex]);
                break;
            case "CHECK":
                if(userInput.length == 1){
                    option.showAllTimers();
                }else {
                    option.showTimer(userInput[timerNameIndex]);
                }
                break;
            default:
                view.printWarning(String.format("Option \"%s\" is not available.%n"));
                option.showProgramOptions();
        }
    }

}
