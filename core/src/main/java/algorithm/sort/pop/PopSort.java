package algorithm.sort.pop;

import algorithm.util.ArrayUtil;

/**
 * Created by zhouhui on 2018/11/17.
 */
public class PopSort {
    public static void sort(int[] a){
        if(a == null || a.length == 0) return;
        int temp;
        for(int m = 0; m < a.length - 1; m++){
            for(int i = 0; i < a.length - 1; i++){
                if(a[i] > a[i + 1]){
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] a = ArrayUtil.generate(10);
        ArrayUtil.print(a);
        sort(a);
        ArrayUtil.print(a);
    }
}
