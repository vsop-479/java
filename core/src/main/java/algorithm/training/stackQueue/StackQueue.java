package algorithm.training.stackQueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

/**
 * implements queue with two stack
 */
public class StackQueue<E> implements Queue<E>{
    Stack<E> current = new Stack<>();
    Stack<E> target = new Stack<>();
    boolean pushFlag = false;

    private void change(){
        while(!current.isEmpty()){
            target.push(current.pop());
        }
        Stack tmp = current;
        current = target;
        target = tmp;
    }

    @Override
    public boolean offer(E o) {
        if(!pushFlag){
            change();
            pushFlag = true;
        }
        current.push(o);
        return false;
    }

    @Override
    public E poll() {
        if(pushFlag){
            change();
            pushFlag = false;
        }
        if(current.isEmpty()){
            return null;
        }
        return current.pop();
    }

    @Override
    public E peek() {
        return current.peek();
    }

    @Override
    public int size() {
        return current.size();
    }

    @Override
    public boolean isEmpty() {
        return current.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return current.contains(o);
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


}
