package algorithm.heap;

import algorithm.util.ArrayUtil;

/**
 * Created by zhouhui on 2019/8/31.
 * ����С���ѣ�����������ݼ��е����N��Ԫ�ء�
 * �ӳ���1_000_000��int�������ҳ�����10����
 * 1��ǰ10��Ԫ�أ�����С���ѡ�
 * 2������ʣ��Ԫ�أ�������ڶѶ�Ԫ�أ�
 * �򻻵��Ѷ�Ԫ�أ��������ѣ�ֻ��ԶѶ�Ԫ���³�����
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
