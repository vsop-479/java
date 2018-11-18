package algorithm.search.binary;

import algorithm.sort.pop.PopSort;

import java.util.Random;

/**
 * Created by zhouhui on 2018/11/17.
 */
public class Binary {
    //    while(start <= end)
    public static int nonRecursiveWhile(int[] a, int start, int end, int target){
        if(a == null || a.length == 0) return -1;
        int m;
        while(start <= end){
            m = (start + end) / 2;
            if(target == a[m]){
                return m;
            }else if(target < a[m]){
                end  = m - 1;
            }else{
                start = m + 1;
            }
        }
        return -2;
    }
//    for(; start <= end;)
    public static int nonRecursiveFor(int[] a, int start, int end, int target){
        if(a == null || a.length == 0) return -1;
        int m;
        for(; start <= end;){
            m = (start + end) / 2;
            if(target == a[m]){
                return m;
            }else if(target < a[m]){
                end  = m - 1;
            }else{
                start = m + 1;
            }
        }
        return -2;
    }

    public static int recursive(int[] a, int start, int end, int target){
        if(a == null || a.length == 0) return -1;
        if(start > end) return -2; //Œ¥’“µΩ
        int m = (start + end) / 2;
        if(target == a[m]){
            return m;
        }else if(target < a[m]){
            return recursive(a, start, m - 1, target);
        }else{
            return recursive(a, m + 1, end, target);
        }
    }

    public static void main(String[] args){
        int[] a = PopSort.getRandom();
        int target = a[new Random().nextInt(a.length)];
        PopSort.sort(a);
        PopSort.print(a);
        System.out.print(recursive(a, 0, a.length - 1, 62));
        System.out.println();
        System.out.print(nonRecursiveFor(a, 0, a.length - 1, 62));
        System.out.println();
        System.out.print(nonRecursiveWhile(a, 0, a.length - 1, 62));
        System.out.println();
        System.out.println("target: " + target);
        System.out.print(recursive(a, 0, a.length - 1, target));
        System.out.println();
        System.out.print(nonRecursiveFor(a, 0, a.length - 1, target));
        System.out.println();
        System.out.print(nonRecursiveWhile(a, 0, a.length - 1, target));
    }
}
