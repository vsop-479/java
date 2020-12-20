package concurrent.thread;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 100; i++){
                System.out.println("t1====" + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 100; i++){
                System.out.println("t2====" + i);
            }
        });

        t1.start();
        t2.start();
        System.out.println("main thread t1 join");
        t1.join();
        System.out.println("main thread t1 yield");
        t1.yield();
    }
}
