package algorithm.training.stackQueue;

import java.util.Queue;

public class Test {
    public static void main(String[] args){
        Queue<Integer> queue = new StackQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue.poll());
        queue.offer(5);
        queue.offer(6);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.offer(7);
        queue.offer(8);
        System.out.println(queue.poll());
        queue.offer(9);
        queue.offer(10);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
