package model;

public class MyTimer extends Thread implements Timer{
    private final long startTime = System.currentTimeMillis();
    private long endTime = 0;
    private long startPause;
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

    
}
