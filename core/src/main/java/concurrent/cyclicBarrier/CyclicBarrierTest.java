package concurrent.cyclicBarrier;

import java.util.Queue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 使用CyclicBarrier，使每个worker完成一个任务后，等待其他worker完成，再接续。
 * 可控制worker完成的数量均等，但不能保证每次拿到task的顺序。
 * 如果需要保证顺序，参照abc，使用count。
 */
public class CyclicBarrierTest {
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        ((LinkedBlockingQueue<Integer>) queue).offer(1);
        ((LinkedBlockingQueue<Integer>) queue).offer(2);
        ((LinkedBlockingQueue<Integer>) queue).offer(3);
        ((LinkedBlockingQueue<Integer>) queue).offer(4);
        ((LinkedBlockingQueue<Integer>) queue).offer(5);
        ((LinkedBlockingQueue<Integer>) queue).offer(6);

        CyclicBarrier cb = new CyclicBarrier(2);
        new Thread(new Worker(queue, cb)).start();
        new Thread(new Worker(queue, cb)).start();
    }
}

class Worker implements Runnable{
    private Queue<Integer> queue;
    private CyclicBarrier cb;

    public Worker(Queue<Integer> queue, CyclicBarrier cb ){
        this.queue = queue;
        this.cb = cb;
    }

    @Override
    public void run() {
        Integer i = null;
        while((i = queue.poll()) != null){
            System.out.print(Thread.currentThread().getName() + i);
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
