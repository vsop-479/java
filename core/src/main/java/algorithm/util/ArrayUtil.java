package algorithm.util;

import java.util.Random;

/**
 * Created by zhouhui on 2018/12/1.
 */
public class ArrayUtil {
    public static int[] generate(int length){
        Random random = new Random();
        int[] a = new int[length];
        for(int i = 0; i < a.length; i++){
            a[i] = random.nextInt(100);
        }
        return a;
    }

    public static void print(int[] a){
        if(a == null || a.length == 0) return;
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }

    public static void swap(int[] a, int i, int j){
        if(a == null || a.length == 0) return;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void check(int[] a){
        if(a == null || a.length == 0) System.out.println("sorted");
        for(int i = 0; i < a.length - 1; i++){
            if(a[i] > a[i + 1]){
                System.out.println("sorted wrong: a[" + i + "] = " + a[i] + " greater than a[" + (i + 1) + "] = " + a[i+1]);
                return;
            }
        }
        System.out.println("sorted");
    }
}
