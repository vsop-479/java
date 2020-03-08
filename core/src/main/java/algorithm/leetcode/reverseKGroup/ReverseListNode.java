package algorithm.leetcode.reverseKGroup;

/**
 * Created by zhouhui on 2019/10/27.
 * 反转链表：
 * 定义newNode = head，currentNode = head.next，next = currentNode.next，
 * 将链表中的元素，移动到newNode头上。
 */
public class ReverseListNode {

    /**
     * 向新链表转移实现。
     * @param head
     * @return
     */
    public static ListNode reverseListNode(ListNode head){
        ListNode newHead = null;

        ListNode currentNode = head;
        ListNode next = null;
        while(currentNode != null){
            next = currentNode.next;
            currentNode.next = newHead;
            newHead = currentNode;

            currentNode = next;
        }
        return newHead;
    }

    /**
     * 递归实现。
     * @param node
     * @return
     */
    public static ListNode reverseListNodeRecursive(ListNode node){
        if(node == null){
            return null;
        }
        ListNode next = node.next;
        if(next == null) {
            return node;
        }
        ListNode newNode = reverseListNodeRecursive(next);
        next.next = node;
        node.next = null;
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

        printNode(node1);
        ListNode rNode = reverseListNodeRecursive(node1);
        printNode(rNode);
    }

    public static void printNode(ListNode node){
        while (node != null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }

}
