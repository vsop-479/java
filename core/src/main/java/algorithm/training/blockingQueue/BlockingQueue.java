package algorithm.training.blockingQueue;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue <T>{
    class Node<T>{
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value){
            this.value = value;
        }
    }

    private Node<T> head, tail;
    private Lock lock = new ReentrantLock();

    public void offer(T value){
        if(lock.tryLock()){
            try{
                Node<T> node = new Node<>(value);
                if(head == null){
                    head = node;
                    tail = node;
                }else{
//                    link to tail.
                    tail.next = node;
                    node.prev = tail;
                    tail = node;
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public T poll(){
        if(lock.tryLock()){
            try{
                if(head == null){
                    return null;
                }
                Node<T> oldHead = head;

//                set new head.
                head = head.next;
                if(head != null){
                    head.prev = null;
                }

//                naked old head.
                oldHead.next = null;
                return oldHead.value;
            }finally {
                lock.unlock();
            }
        }else{
            return null;
        }
    }

    public void printCurrentNode(){
        Node node = head;
        while(node != null){
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println();
    }
}
