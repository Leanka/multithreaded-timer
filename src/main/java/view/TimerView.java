package view;

import model.Timer;

public interface TimerView {
    String [] getInput();
    void printTimer(Timer timer);
    void printWarning(String warning);
}
