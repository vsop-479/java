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
