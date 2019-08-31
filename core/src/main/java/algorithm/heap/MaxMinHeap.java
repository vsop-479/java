package algorithm.heap;

import algorithm.util.ArrayUtil;

/**
 * Created by zhouhui on 2019/8/31.
 *
 * ���ν�������n-1,n-2,...,0�ĸ��ڵ㣬��shiftDown������
 * ���ɵõ����ѣ���С�ѣ���
 *
 * ���ڽڵ�
 *  ���i����0��ʼ��
 * �򸸽ڵ��ţ�(i - 1) / 2
 * �����ӽڵ��ţ�2i + 1
 * �����Խڵ��ţ�2i + 2
 *
 * �󶥶�ֻ�ܱ�֤���������ģ����ܱ�֤���һ���ڵ�����С�ġ�
 * С�����������С�ġ�
 *
 * topN����
 * ���������N����
 * ����ҪС���ѣ�
 * �ȹ���һ��N�ڵ��С����
 * �¼ӵ�Ԫ�غ͸��ڵ�Ƚϣ�������ڸ��ڵ㣬���滻���ڵ㣬Ȼ���³����ڵ㹹���ѣ�
 * �������滻��
 *
 * ������
 * ȡ�����ڵ㣨���/��С����Ȼ�����һ��Ԫ�طŵ����ڵ㣬�³����ڵ㹹���ѡ�
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
    //���������Ϊ�󶥶�
    public static void adjustToMax(int[] a){
        for(int i = a.length - 1; i >= 0; i--){
            int k = (i - 1) / 2;
            if(k < 0) break;
            shiftDownForMax(k, a);
        }
    }

    /**
     * ����һ���ڵ�
     * ����ýڵ�С�������ӽڵ㣬���������ӽڵ��û���
     * һֱ�����û���ֱ��Ҷ�ӽڵ㡣
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

    //���������ΪС����
    public static void adjustToMin(int[] a){
        for(int i = a.length - 1; i >= 0; i--){
            int k = (i - 1) / 2;
            if(k < 0) break;
            shiftDownForMin(k, a);
        }
    }

    /**
     * ����һ���ڵ�
     * ����ýڵ������С���ӽڵ㣬������С���ӽڵ��û���
     * һֱ�����û���ֱ��Ҷ�ӽڵ㡣
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
