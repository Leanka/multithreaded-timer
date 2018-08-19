package model;

public class MyTimer extends Thread implements Timer{
    private final long startTime = System.currentTimeMillis();
    private long endTime = 0;
    private long totalPauseCountInMillis = 0;
    private volatile boolean isThreadSuspended = false;

    public MyTimer(String name) {
        super(name);
    }

    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(1000);
                synchronized (this){
                    while (isThreadSuspended){
                        wait();
                    }
                }

            } catch (InterruptedException e) {
                break; //quit if interrupted
            }
        }
    }

    public void stopTimer(){
        if(this.isAlive()){
            this.interrupt();
            this.endTime = System.currentTimeMillis();
            if(this.isThreadSuspended){
                pauseTimer();
            }
        }

    }

    @Override
    public boolean isStopped() {
        return !this.isAlive();
    }

    @Override
    public boolean isPaused() {
        return this.isThreadSuspended;
    }

    public synchronized void pauseTimer(){
        this.isThreadSuspended = !this.isThreadSuspended;
        if(!this.isThreadSuspended){
            long stopPause = System.currentTimeMillis();
            this.totalPauseCountInMillis += stopPause - endTime;

            endTime = 0;
            notify();
        }else{
            endTime = System.currentTimeMillis();
        }
    }

    private long getTimerValue(){
        long timerEndValue;
        if(this.isAlive()){
            timerEndValue = System.currentTimeMillis();
            if(this.isThreadSuspended){
                timerEndValue -= getCurrentPauseValue();
            }
        }else {
            timerEndValue = this.endTime;
        }
        return (timerEndValue - this.startTime - this.totalPauseCountInMillis)/1000;
    }

    private long getCurrentPauseValue(){
        return System.currentTimeMillis() - this.endTime;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Name: ");
        builder
                .append(this.getName())
                .append(", Thread ID: ")
                .append(this.getId())
                .append(", seconds: ")
                .append(this.getTimerValue());

        return builder.toString();
    }
}
