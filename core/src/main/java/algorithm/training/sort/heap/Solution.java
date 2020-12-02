package algorithm.training.sort.heap;

import algorithm.util.ArrayUtil;

public class Solution {
//    sort: get a min top heap, remove the top node(to sort), move last node to top, rebuilding the min top heap...
    public static void minTopHeap(int[] a){
        for(int i = a.length -1; i > 0; i--){
            int left = shiftForMinTopHeap(a, i);
//          we have shift the right node, the left node should not duplicate shift.
//            skip left.
            i = left;
        }
    }

//    sort: same to min.
    public static void maxTopHeap(int[] a){
        for(int i = a.length -1; i > 0; i--){
            int left = shiftForMaxTopHeap(a, i);
//          we have shift the right node, the left node should not duplicate shift.
//            skip left.
            i = left;
        }
    }

    public static int shiftForMinTopHeap(int[] a, int current){
        int parent = (current - 1) / 2;
        if(parent >= 0 && parent < a.length){
            int left = parent * 2 + 1;
            int right = parent * 2 + 2;
            if(right < a.length){
                if(a[right] < a[left] && a[right] < a[parent]){
                    ArrayUtil.swap(a, right, parent);
                }else if(a[left] < a[right] && a[left] < a[parent]){
                    ArrayUtil.swap(a, left, parent);
                }
            }else if(left < a.length){
                if(a[left] < a[parent]){
                    ArrayUtil.swap(a, left, parent);
                }
            }
            return left;
        }
        return 0;
    }

    public static int shiftForMaxTopHeap(int[] a, int current){
        int parent = (current - 1) / 2;
        if(parent >= 0 && parent < a.length){
            int left = parent * 2 + 1;
            int right = parent * 2 + 2;
            if(right < a.length){
                if(a[right] > a[left] && a[right] > a[parent]){
                    ArrayUtil.swap(a, right, parent);
                }else if(a[left] > a[right] && a[left] > a[parent]){
                    ArrayUtil.swap(a, left, parent);
                }
            }else if(left < a.length){
                if(a[left] > a[parent]){
                    ArrayUtil.swap(a, left, parent);
                }
            }
            return left;
        }
        return 0;
    }


    public static void main(String[] args){
        int[] a = ArrayUtil.generate(10, 100);
        ArrayUtil.print(a);
        minTopHeap(a);
        ArrayUtil.print(a);
        maxTopHeap(a);
        ArrayUtil.print(a);

        a = ArrayUtil.generate(10, 100);
        ArrayUtil.print(a);
        maxTopHeap(a);
        ArrayUtil.print(a);
        minTopHeap(a);
        ArrayUtil.print(a);
    }
}
