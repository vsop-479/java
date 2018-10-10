package lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 * 1:同一线程可递归获取锁，最大2147483648.
 * 2:相对sync只能固定的代码块，lock,unlock可在不同的方法中更灵活.
 * 3:tryLock.
 */
public class Test {
    private ReentrantLock lock = new ReentrantLock(false);
    public void l1(){
        try{
            lock.lock();
            System.out.println("f getHoldCount: " + lock.getHoldCount());
            l2();
        }finally {
            lock.unlock();
        }
    }
    public void l2(){
        if(lock.tryLock()){
            try{
                System.out.println("g getHoldCount: " + lock.getHoldCount());
            }finally {
                lock.unlock();
            }
        }
    }

    public synchronized void s1(){
        System.out.println("s1 ");
        s2();
    }

    public synchronized void s2(){
        System.out.println("s2 ");
    }

    public static void main(String[] args){
        Test t = new Test();
        t.l1();

        t.s1();
    }
}