package algorithm.training.sort.quick;

import algorithm.util.ArrayUtil;

public class Solution {
    public static void quickSort(int[] a, int start, int end){
        int mid = oneQuick(a, start, end);
        if(mid  - 1 > start){
            quickSort(a, start, mid - 1);
        }
        if(mid + 1 < end){
            quickSort(a, mid + 1, end);
        }
    }

    public static int oneQuick(int[] a, int start, int end){
        int base = a[start];
//        recording compare from tail(end --) or head (start++).
        boolean tailFlag = true;
        while(start < end){
            if(tailFlag){
                if(base > a[end]){
                    ArrayUtil.swap(a, start, end);
                    start++;
                    tailFlag = false;
                }else{
                    end--;
                }
            }else{
                if(base < a[start]){
                    ArrayUtil.swap(a, start, end);
                    end--;
                    tailFlag = true;
                }else{
                    start++;
                }
            }
        }
        return start;
    }

    public static void main(String[] args){
        int[] a = new int[]{30, 28, 36, 59, 21, 75};
        quickSort(a, 0, a.length - 1);
        ArrayUtil.print(a);

        a = ArrayUtil.generate(10, 100);
        ArrayUtil.print(a);
        quickSort(a, 0, a.length - 1);
        ArrayUtil.print(a);
    }
}
