package algorithm.search.btree;

import algorithm.sort.btree.Factory;
import algorithm.sort.btree.model.BTree;
import algorithm.sort.btree.model.Element;
import algorithm.sort.pop.PopSort;

/**
 * Created by zhouhui on 2018/11/18.
 */
public class BTreeSearch {
    public static Element search(BTree<Integer> bTree, int target){
        Element<Integer> element = bTree.getRoot();
        while (element != null){
            if(target == element.getValue()){
                return element;
            }else if(target < element.getValue()){
                element = element.getLeft();
            }else {
                element = element.getRight();
            }
        }
        return element;
    }

    public static void main(String[] args){
        int[] a = PopSort.getRandom();
        PopSort.print(a);
        BTree btree = Factory.getBtree(a);
        System.out.println(search(btree, a[4]));
    }
}
