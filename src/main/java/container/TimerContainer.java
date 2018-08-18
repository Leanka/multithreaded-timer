package container;

import model.Timer;
import java.util.HashMap;
import java.util.Map;

public class TimerContainer implements Container{
    Map <String, Timer> timers = new HashMap <>();

    @Override
    public void addTimer(Timer timer) {

    }

    @Override
    public Timer getTimer(String name) {
        return null;
    }

    @Override
    public void closeAllTimers() {

    }

    @Override
    public boolean isNameAvailable(String name) {
        return false;
    }
}
