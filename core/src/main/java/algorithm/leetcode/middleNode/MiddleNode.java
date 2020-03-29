package algorithm.leetcode.middleNode;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class MiddleNode {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode2(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode current = head;
        ListNode middle = head;

        while(current != null){
            current = current.next;
            if(current != null){
                current = current.next;
                middle = middle.next;
            }
        }
        return middle;
    }


    public ListNode middleListNode(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode current = head;
        int length = 0;

        while(current != null){
            length++;
            current = current.next;
        }

        int mid = length / 2;
        current = head;
        int i = 0;

        while(current != null && i < mid){
            current = current.next;
            i++;
        }
        return current;
    }
    
    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
    }
}
