package timer;

import model.Timer;

public interface TimerFactory {
    Timer getTimer(String name);
}
