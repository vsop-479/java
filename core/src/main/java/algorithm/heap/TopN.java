package algorithm.heap;

import algorithm.util.ArrayUtil;

/**
 * Created by zhouhui on 2019/8/31.
 * 利用小顶堆，求出所给数据集中的最大N个元素。
 * 从长度1_000_000的int数组中找出最大的10个。
 * 1：前10个元素，构造小顶堆。
 * 2：遍历剩余元素，如果大于堆顶元素，
 * 则换掉堆顶元素，并调整堆（只需对堆顶元素下沉）。
 */
public class TopN {
    public static void main(String[] args){
        int[] total = ArrayUtil.generate(1_000_000, 1_000_000);
//        ArrayUtil.print(total);
        int[] topN = new int[10];
        for(int i = 0; i < 10 ; i++){
            topN[i] = total[i];
        }
        ArrayUtil.print(topN);
        MaxMinHeap.adjustToMin(topN);
        for(int i = 10; i < total.length; i++){
            if(total[i] > topN[0]){
                topN[0] = total[i];
                MaxMinHeap.shiftDownForMin(0, topN);
            }
        }
        ArrayUtil.print(topN);
    }
}
