package algorithm.heap;

import algorithm.util.ArrayUtil;

/**
 * Created by zhouhui on 2019/8/31.
 *
 * 依次将数组中n-1,n-2,...,0的父节点，做shiftDown调整。
 * 即可得到最大堆（最小堆）。
 *
 * 对于节点
 *  编号i（从0开始）
 * 则父节点编号：(i - 1) / 2
 * 则左子节点编号：2i + 1
 * 则右自节点编号：2i + 2
 *
 * 大顶堆只能保证，根是最大的，不能保证最后一个节点是最小的。
 * 小顶堆则根是最小的。
 *
 * topN问题
 * 如果求最大的N个，
 * 则需要小顶堆：
 * 先构建一个N节点的小顶堆
 * 新加的元素和根节点比较，如果大于根节点，则替换根节点，然后下沉根节点构建堆；
 * 否则不用替换。
 *
 * 堆排序
 * 取出根节点（最大/最小），然后将最后一个元素放到根节点，下沉根节点构建堆。
 */
public class MaxMinHeap {
    public static void main(String[] args){
        int[] a = ArrayUtil.generate(10);
        ArrayUtil.print(a);
        adjustToMax(a);
        ArrayUtil.print(a);
        adjustToMin(a);
        ArrayUtil.print(a);
    }
    //将数组调整为大顶堆
    public static void adjustToMax(int[] a){
        for(int i = a.length - 1; i >= 0; i--){
            int k = (i - 1) / 2;
            if(k < 0) break;
            shiftDownForMax(k, a);
        }
    }

    /**
     * 调整一个节点
     * 如果该节点小于最大的子节点，则与最大的子节点置换。
     * 一直向下置换，直到叶子节点。
     * @param k
     * @param a
     */
    public static void shiftDownForMax(int k, int[] a){
        while(2 * k + 1 < a.length){
            int p = a[k];
            int ms = a[2 * k + 1];
            int msp = 2 * k + 1;
            if(2 * k + 2 < a.length && a[2 * k + 2] > ms){
                ms = a[2 * k + 2];
                msp = 2 * k + 2;
            }
            if(ms > p){
                a[k] = ms;
                a[msp] = p;
                k = msp;
            }else{
                break;
            }
        }
    }

    //将数组调整为小顶堆
    public static void adjustToMin(int[] a){
        for(int i = a.length - 1; i >= 0; i--){
            int k = (i - 1) / 2;
            if(k < 0) break;
            shiftDownForMin(k, a);
        }
    }

    /**
     * 调整一个节点
     * 如果该节点大于最小的子节点，则与最小的子节点置换。
     * 一直向下置换，直到叶子节点。
     * @param k
     * @param a
     */
    public static void shiftDownForMin(int k, int[] a){
        while(2 * k + 1 < a.length){
            int p = a[k];
            int ms = a[2 * k + 1];
            int msp = 2 * k + 1;
            if(2 * k + 2 < a.length && a[2 * k + 2] < ms){
                ms = a[2 * k + 2];
                msp = 2 * k + 2;
            }
            if(ms < p){
                a[k] = ms;
                a[msp] = p;
                k = msp;
            }else{
                break;
            }
        }
    }
}
