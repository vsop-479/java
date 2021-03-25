package algorithm.leetcode.deleteDuplicates;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class Solution {
    public static ListNode deleteDuplicatesBesidesFirst(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode currentNode = head;
        ListNode prevNode = null, prevPrev = null;
        boolean dupFlag = false;
        while(currentNode != null){
            if(prevNode != null){
                if(prevNode.val == currentNode.val){
                    prevNode.next = currentNode.next;
                    currentNode.next = null;
                    currentNode = prevNode.next;
                }else{
                    if(dupFlag){
                        if(prevPrev != null){
                            prevPrev.next = prevNode.next;
                            prevNode.next = null;
                        }
                        dupFlag = false;
                    }
                    prevNode = currentNode;
                    currentNode = currentNode.next;
                }
            }else{
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode currentNode = head;
        ListNode prevNode = null;
        while(currentNode != null){
            if(prevNode != null){
                if(prevNode.val == currentNode.val){
                    prevNode.next = currentNode.next;
                    currentNode.next = null;
                    currentNode = prevNode.next;
                }else{
                    prevNode = currentNode;
                    currentNode = currentNode.next;
                }
            }else{
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        printNode(node1);
        printNode(deleteDuplicates(node1));

    }

    static void printNode(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println();
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}