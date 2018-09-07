package algorithm.ipTree.model;

public class Element<T> {
    private Element<T> left;
    private Element<T> right;
    private T value;

    public boolean isLeaf(){
        return left == null && right == null;
    }

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
}
