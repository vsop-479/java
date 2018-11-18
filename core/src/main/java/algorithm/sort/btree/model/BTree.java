package algorithm.sort.btree.model;

/**
 * Created by zhouhui on 2018/11/18.
 */
public class BTree<T> {
    private Element<T> root;

    public Element<T> getRoot() {
        return root;
    }

    public void setRoot(Element<T> root) {
        this.root = root;
    }
}
