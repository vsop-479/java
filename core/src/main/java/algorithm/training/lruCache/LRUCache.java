package algorithm.training.lruCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    class Node<K>{
        K key;
        Node<K> next;
        Node<K> prev;
        private Node(K key){
            this.key = key;
        }
    }

    private Map<K, V> map = new HashMap<>();
    private Node<K> head, tail;
    private final int limit;

    public LRUCache(int limit){
        this.limit = limit;
    }

    public void put(K key, V value){
        if(map.containsKey(key)){
            promotion(key);
        }else{
            linkToHead(new Node<>(key));
        }
        map.put(key, value);
        while(map.size() > limit){
            evict();
        }
    }

    public V get(K key){
        promotion(key);
        return map.get(key);
    }

    public void remove(K key){
        if(map.containsKey(key)){
            unlink(key);
        }
        map.remove(key);
    }

    private Node<K> unlink(K key){
        if(head == null){
            return null;
        }
        Node currentNode = head;
        while(currentNode != null){
            if(currentNode.key.equals(key)){
                if(currentNode == head){
                    head = head.next;
                    if(head != null){
                        head.prev = null;
                    }
                }else if(currentNode == tail){
                    tail = tail.prev;
                    if(tail != null){
                        tail.next = null;
                    }
                }else{
                    currentNode.prev.next = currentNode.next;
                    currentNode.next.prev = currentNode.prev;
                }

                //trim current node naked.
                currentNode.prev = null;
                currentNode.next = null;
                return currentNode;
            }else{
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    private void linkToHead(Node<K> node){
        if(head == null){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    private void promotion(K key){
        if(head == null){
            linkToHead(new Node(key));
        }else{
            if(key.equals(head.key)){
                //do nothing.
            }else{
                Node<K> currentNode = unlink(key);
                if(currentNode == null){
//                    put a new value, link to head.
                    linkToHead(new Node(key));
                }else{
                    linkToHead(currentNode);
                }
            }
        }
    }

    private void evict(){
        if(tail == null){
            return;
        }
        map.remove(tail.key);
        if(tail == head){
            head = null;
            tail = null;
        }else{
            tail = tail.prev;
            //clean old tail.
            tail.next.prev = null;
            //clean new tail.
            tail.next = null;
        }
    }

    public void printCurrentNode(){
        Node node = head;
        while(node != null){
            System.out.print(node.key + " -> ");
            node = node.next;
        }
    }
}
