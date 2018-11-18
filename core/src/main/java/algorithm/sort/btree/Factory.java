package algorithm.sort.btree;

import algorithm.sort.btree.model.BTree;
import algorithm.sort.btree.model.Element;
import algorithm.sort.pop.PopSort;

/**
 * Created by zhouhui on 2018/11/18.
 */
public class Factory {
    public static BTree getBtree(int[] a){
        if(a == null || a.length == 0) return null;
        BTree<Integer> btree = new BTree();
        Element<Integer> root = new Element();
        root.setValue(a[0]);
        btree.setRoot(root);
        for(int i = 1; i < a.length; i++){
            Element<Integer> element = btree.getRoot();
            while(true){
                if(a[i] < element.getValue()){
                    Element<Integer> left = element.getLeft();
                    if(left == null){
                        left = new Element();
                        left.setValue(a[i]);
                        element.setLeft(left);
                        break;
                    }else{
                        element = left;
                    }
                }else {
                    Element<Integer> right = element.getRight();
                    if(right == null){
                        right = new Element();
                        right.setValue(a[i]);
                        element.setRight(right);
                        break;
                    }else {
                        element = right;
                    }
                }
            }
        }
        return btree;
    }

    public static void main(String[] args){
        getBtree(PopSort.getRandom());
    }
}
