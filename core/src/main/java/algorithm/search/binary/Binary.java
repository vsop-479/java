package algorithm.search.binary;

import algorithm.sort.pop.PopSort;

/**
 * Created by zhouhui on 2018/11/17.
 */
public class Binary {
    public static int search(int[] a, int start, int end, int target){
        if(a == null || a.length == 0) return -1;
        if(start > end) return -2; //Î´ÕÒµ½
        int m = (start + end) / 2;
        if(target == a[m]){
            return m;
        }else if(target < a[m]){
            return search(a, start, m - 1, target);
        }else{
            return search(a, m + 1, end, target);
        }
    }

    public static void main(String[] args){
        int[] a = PopSort.getRandom();
        PopSort.sort(a);
        PopSort.print(a);
        System.out.print(search(a, 0, a.length - 1, 62));
    }
}
