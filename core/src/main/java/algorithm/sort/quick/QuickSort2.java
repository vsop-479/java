package algorithm.sort.quick;

import algorithm.util.ArrayUtil;

/**
 * Created by zhouhui on 2019/8/11.
 * keys:
 * 1：一趟排序过后，基准值所在的位置已经确定。
 * 2：再分别对基准值前后的数组进行快排。
 */
public class QuickSort2 {
    public static void quickSort(int[]a, int i, int j){
        if(a == null || a.length <= 1) return;
        if(i >= j) return;

        int p = oneSort(a, i, j);
        if(p - 1 > i){
            quickSort(a, i , p - 1);
        }
        if(p + 1 < j){
            quickSort(a, p + 1, j);
        }
    }
    public static int oneSort(int[] a, int i, int j){
        int s = a[i];
        boolean flag = true;
        while(i != j){
            if(flag){
                if(s > a[j]){
                    ArrayUtil.swap(a, i, j);
                    i++;
                    flag = false;
                }else{
                    j--;
                }
            }else{
                if(s < a[i]){
                    ArrayUtil.swap(a, i, j);
                    j--;
                    flag = true;
                }else{
                    i++;
                }
            }
        }
        return i;
    }

    public static void main(String[] args){
        int[] a = ArrayUtil.generate(100);
        ArrayUtil.check(a);
        ArrayUtil.print(a);
        quickSort(a, 0, a.length - 1);
        ArrayUtil.print(a);
        ArrayUtil.check(a);
    }
}
