package algorithm.leetcode.addTwoNumbers;

/**
 * Created by zhouhui on 2019/6/22.
 * ��������?�ǿ� ������������ʾ�����Ǹ������������У����Ǹ��Ե�λ���ǰ���?����?�ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢?һλ?���֡�

 ��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�

 �����Լ���������� 0 ֮�⣬���������������� 0?��ͷ��

 ʾ����

 ���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
 �����7 -> 0 -> 8
 ԭ��342 + 465 = 807

 ��Դ�����ۣ�LeetCode��
 ���ӣ�https://leetcode-cn.com/problems/add-two-numbers
 ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = null, p = null;
        int m = 0, n = 0;
        while(l1 != null || l2 != null || m != 0){
            int sum = 0;
            if(l1 != null){
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum = sum + l2.val;
                l2 = l2.next;
            }
            sum = sum + m;
            m = sum / 10;
            n = sum % 10;
            if(l == null){
                l = new ListNode(n);
                p = l;
            }else{
                p.next = new ListNode(n);
                p = p.next;
            }
        }

        return l;
    }
}