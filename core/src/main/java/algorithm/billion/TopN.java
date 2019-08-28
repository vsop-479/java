package algorithm.billion;

import java.util.*;

/**
 * VM options: -Xms8192m -Xmx8192m.
 */
public class TopN {
    public static void main(String[] args){
//        10亿, 将byte转成gb.
        int len = 1_000_000_000;
//        4gb的数组
        int[] a = new int[len];
        fill(a);
        System.out.println("");
    }

    public static List getMax(int len, int[] a){
        int[] t = new int[len];
//        使用linkedlist插入效率高，但不能真正二分查找。
//        使用数组可以二分查找，但插入效率低。
//        推荐使用堆。
        List list = new LinkedList();
        for(int i = 0; i < len; i++){
            list.add(a[i]);
        }
        Collections.sort(list);
        for(int i = len; i < a.length; i++){

        }
        return list;
    }

    public static void fill(int[] a){
        Random random = new Random();
        for(int i = 0; i < a.length; i++){
            a[i] = random.nextInt(Integer.MAX_VALUE);
        }
    }
}
