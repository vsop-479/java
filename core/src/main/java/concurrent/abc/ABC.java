package concurrent.abc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhouhui on 2019/8/25.
 */
public class ABC {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        int limit = 30;
        Signal signal = new Signal(0);

        new Thread(new A(lock, signal, limit)).start();
        new Thread(new B(lock, signal, limit)).start();
        new Thread(new C(lock, signal, limit)).start();
    }
}

class A implements Runnable{
    private Lock lock;
    private Signal signal;
    private int limit;

    public A(Lock lock, Signal signal, int limit){
        this.lock = lock;
        this.signal = signal;
        this.limit = limit;
    }

    @Override
    public void run() {
        while (true){
            if(signal.getCount() > limit){
                return;
            }
            try{
                lock.lock();
//                如果未到自己的signal，只循环，由其他线程print，signalCount++。
                if(signal.getCount() % 3 == 0){
                    System.out.print("A");
                    signal.increment();
                }
            }finally {
                lock.unlock();
            }
        }
    }
}

class B implements Runnable{
    private Lock lock;
    private Signal signal;
    private int limit;

    public B(Lock lock, Signal signal, int limit){
        this.lock = lock;
        this.signal = signal;
        this.limit = limit;
    }

    @Override
    public void run() {
        while (true){
            if(signal.getCount() > limit){
                return;
            }
            try{
                lock.lock();
//                如果未到自己的signal，只循环，由其他线程print，signalCount++。
                if(signal.getCount() % 3 == 1){
                    System.out.print("B");
                    signal.increment();
                }
            }finally {
                lock.unlock();
            }
        }
    }
}

class C implements Runnable{
    private Lock lock;
    private Signal signal;
    private int limit;

    public C(Lock lock, Signal signal, int limit){
        this.lock = lock;
        this.signal = signal;
        this.limit = limit;
    }

    @Override
    public void run() {
        while (true){
            if(signal.getCount() > limit){
                return;
            }
            try{
                lock.lock();
//                如果未到自己的signal，只循环，由其他线程print，signalCount++。
                if(signal.getCount() % 3 == 2){
                    System.out.print("C");
                    signal.increment();
                }
            }finally {
                lock.unlock();
            }
        }
    }
}

class Signal{
    private int count;
    public Signal(int count){
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void increment(){
        this.count = this.count + 1;
    }
}
