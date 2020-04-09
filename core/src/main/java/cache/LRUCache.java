package cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V>{
    private final Map<K, Node<K, V>> map;
    private final int limit;

    Node<K, V> head;
    Node<K, V> tail;

    public LRUCache(int limit){
        map = new HashMap<>();
        this.limit = limit;
    }

    public synchronized void put(K key, V value){
        evict();
        Node<K, V> newNode = new Node<>(key, value);
        Node<K, V> oldNode = map.put(key, newNode);

//        key已存在，unlink key，并将key放到head.
        if(oldNode != null){
            promoteNode(oldNode);
        }else{
//            key不存在，直接将key放到head。
            linkAtHead(newNode);
        }
    }

    public V get(K key){
        Node<K, V> node = map.get(key);
        promoteNode(node);
        return node.value;
    }

//    将已经存在的node，从链表移除，并加到表头。
    private synchronized void promoteNode(Node<K, V> node){
        unLink(node);
        linkAtHead(node);
    }

    private synchronized void linkAtHead(Node<K, V> node){
        Node<K, V> h = head;
        node.before = null;
        node.after = head;
        head = node;
        if (h == null) {
            tail = node;
        } else {
            h.before = node;
        }
    }

    private synchronized boolean shouldEvict() {
        return map.size() > limit;
    }

    private synchronized void evict(){
        while(tail != null && shouldEvict()){
            evictNode(tail);
        }
    }

    private void evictNode(Node<K, V> current){
        unLink(current);
    }

    private synchronized void unLink(Node<K, V> current){
        final Node<K, V> before = current.before;
        final Node<K, V> after = current.after;

//        remove head
        if(before == null){
            head = after;
            if (head != null) {
                head.before = null;
            }
        }else {
            // remove inner
            before.after = after;
            current.before = null;
        }

//        remove tail
        if(after == null){
            tail = before;
            if (tail != null) {
                tail.after = null;
            }
        }else{
            // remove inner
            after.before = before;
            current.after = null;
        }
    }

    class Node<K, V>{
        final K key;
        final V value;
        Node<K, V> before;
        Node<K, V> after;

        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}



