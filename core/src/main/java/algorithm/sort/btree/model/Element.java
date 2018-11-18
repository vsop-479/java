package algorithm.sort.btree.model;

/**
 * Created by zhouhui on 2018/11/18.
 */
public class Element<T> {
    private Element<T> left;
    private Element<T> right;
    private T value;

    public Element<T> getLeft() {
        return left;
    }

    public void setLeft(Element<T> left) {
        this.left = left;
    }

    public Element<T> getRight() {
        return right;
    }

    public void setRight(Element<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Element{" +
                "value=" + value +
                '}';
    }
}
