package algorithm.leetcode.reverseKGroup;

/**
 * Created by zhouhui on 2019/10/27.
 * 反转链表：
 * 定义newNode = head，currentNode = head.next，next = currentNode.next，
 * 将链表中的元素，移动到newNode头上。
 */
public class ReverseListNode {
    public static ListNode reverseList(ListNode head){
        ListNode newNode = head;
        ListNode newTail = head;
        ListNode currentNode = head.next;
        ListNode next = currentNode.next;

        while(currentNode != null){
            currentNode.next = newNode;
            newNode = currentNode;

            currentNode = next;
            if(next != null){
                next = next.next;
            }
        }
        newTail.next = null;
        return newNode;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode listNode = reverseList(node1);
        System.out.println();
    }
}