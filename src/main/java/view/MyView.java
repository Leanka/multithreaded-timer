package view;

import model.Timer;

public class MyView implements View {
    @Override
    public void printTimer(Timer timer) {
        System.out.println(timer);
    }

    @Override
    public void printWarning(String warning) {
        System.err.println(warning);
    }
}
