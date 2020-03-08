package concurrent.abc;

import java.util.Queue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;

public class ABCUseWait_Notify {
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        for(int i = 0; i < 100; i++){
            queue.offer(i);
        }

        Signal signal = new Signal(0);
        new Thread(new Worker(queue, signal, 0), "T1").start();
        new Thread(new Worker(queue, signal, 1), "T2").start();
    }
}

class Worker implements Runnable{
    private Queue<Integer> queue;
    private Signal signal;
    private final int N;

    public Worker(Queue<Integer> queue, Signal signal, int n){
        this.queue = queue;
        this.signal = signal;
        this.N = n;
    }

    @Override
    public void run() {
        while (queue.size() > 0){
            synchronized (signal){
                if(signal.getCount() % 2 == N){
                    System.out.print(Thread.currentThread().getName() + ": " + queue.poll() + ", ");
                    signal.increment();
                    signal.notify();
                }else{
                    try {
                        signal.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
