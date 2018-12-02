package algorithm.sort.quick;

import algorithm.util.ArrayUtil;

/**
 * Created by zhouhui on 2018/12/1.
 */
public class QuickSort{

    public static void quickSort(int[] a, int i, int j){
        if(i >= j){
            return;
        }
        int p = oneSort(a, i, j);
        if(p - 1 > 0){
            quickSort(a, i, p - 1);
        }
        if(p + 1 < a.length - 1){
            quickSort(a, p + 1, j);
        }
    }
    public static int oneSort(int[] a, int i, int j){
        int s = a[i];
        while(i != j){
            while(s <= a[j] && j > i){
                j--;
            }
            ArrayUtil.swap(a, i, j);
            while(s >= a[i] && i < j){
                i++;
            }
            ArrayUtil.swap(a, i, j);
        }
        return i;
    }

    public static void main(String[] args){
        int[] a = ArrayUtil.generate(100);
        ArrayUtil.check(a);
//        int[] a = new int[]{1, 5, 9, 6, 7};
//        int[] a = new int[]{ 9, 6, 7};
        ArrayUtil.print(a);
        quickSort(a, 0, a.length - 1);
        ArrayUtil.print(a);
        ArrayUtil.check(a);
    }
}
