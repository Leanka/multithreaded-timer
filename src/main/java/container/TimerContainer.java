package container;

import model.Timer;
import java.util.HashMap;
import java.util.Map;

public class TimerContainer implements Container{
    Map <String, Timer> timers = new HashMap <>();

    @Override
    public void addTimer(Timer timer) {
        timers.put(timer.getName(), timer);
    }

    @Override
    public Timer getTimer(String name) {
        return timers.get(name);
    }

    @Override
    public void closeAllTimers() {
        timers.entrySet()
                .forEach(entrySet -> {
                    Timer tempTimer = entrySet.getValue();
                    timers.remove(tempTimer.getName());
                    tempTimer.stopTimer();
                });
    }

    @Override
    public boolean isNameAvailable(String name) {
        return !timers.containsKey(name);
    }
}
