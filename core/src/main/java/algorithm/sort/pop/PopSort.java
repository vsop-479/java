package algorithm.sort.pop;

import java.util.Random;

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

    public static void print(int[] a){
        if(a == null || a.length == 0) return;
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }

    public static int[] getRandom(){
        Random random = new Random();
        int[] a = new int[10];
        for(int i = 0; i < a.length; i++){
            a[i] = random.nextInt(100);
        }
        return a;
    }

    public static void main(String[] args){
        int[] a = getRandom();
        print(a);
        sort(a);
        print(a);
    }
}
