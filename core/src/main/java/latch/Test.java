package latch;

import java.util.concurrent.CountDownLatch;

public class Test {
    public static void main(String[] args){
        try {
            CountDownLatch latch = new CountDownLatch(1);
            new Thread(new A(latch)).start();
            String a = null;
            a.length();
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }
}

class A implements Runnable{
    private CountDownLatch latch;

    public A(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("dsf");
        latch.countDown();
    }
}