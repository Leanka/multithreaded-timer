package timer;

import model.MyTimer;
import model.Timer;

public final class TimerFactory{

    private TimerFactory(){}

    public static Timer getTimer(String name) {
        return new MyTimer(name);
    }
}
