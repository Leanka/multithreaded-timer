package service;

public class MyTimerService implements TimerService{
    private TimerOption option;

    public MyTimerService(TimerOption option) {
        this.option = option;
    }

    @Override
    public void runTimerService() {

    }
}
