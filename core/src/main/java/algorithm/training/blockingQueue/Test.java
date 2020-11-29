package algorithm.training.blockingQueue;

public class Test {
    public static void main(String[] args){
        BlockingQueue<String> queue = new BlockingQueue<>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.printCurrentNode();
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.printCurrentNode();
    }
}
