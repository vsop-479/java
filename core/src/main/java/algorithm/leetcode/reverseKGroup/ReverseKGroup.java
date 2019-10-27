package algorithm.leetcode.reverseKGroup;

/**
 * Created by zhouhui on 2019/10/27.
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseKGroup {
    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode listNode = reverseKGroup(node1, 2);
        System.out.println();
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}