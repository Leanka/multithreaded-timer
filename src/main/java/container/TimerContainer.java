package container;

import model.Timer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimerContainer implements Container{
    private Map <String, Timer> timers = new HashMap <>();

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
                    tempTimer.stopTimer();
                });
        timers.clear();
    }

    @Override
    public Timer [] getAllTimers() {
        return this.timers.values().toArray(new Timer[this.timers.size()]);
    }

    @Override
    public boolean isNameAvailable(String name) {
        return !timers.containsKey(name);
    }
}
