package model;

public interface Timer{
    void pauseTimer();
    void stopTimer();
    void start();
    String getName();
    boolean isStopped();
}
