package view;

import model.Timer;

public interface View {
    void printTimer(Timer timer);
    void printWarning(String warning);
    void printMessage(String message);
}
