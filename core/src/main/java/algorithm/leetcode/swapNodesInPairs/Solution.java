package algorithm.leetcode.swapNodesInPairs;

/**
 * Created by zhouhui on 2019/11/3.
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * 将链表移动到新链表。
 */
public class Solution {
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
//        新链表
        ListNode newHead = null, newTail = null;
//        记录反转后的node，达到2或K个后，连接到newTail
        ListNode tmpTail = null, tmpCurrent = null;
//        被反转的链表
        ListNode currentNode = head, next = currentNode.next;
        int i = 0;

        while(currentNode != null){
            if(i == 0){
                tmpCurrent = currentNode;
                tmpTail = tmpCurrent;
                tmpTail.next = null;
                i++;
                currentNode = next;
                if(next != null){
                    next = next.next;
                }
            }else if(i < 2){
                currentNode.next = tmpCurrent;
                tmpCurrent = currentNode;
                i++;
                currentNode = next;
                if(next != null){
                    next = next.next;
                }
            }else if(i == 2){
                if(newTail == null){
                    newHead = tmpCurrent;
                    newTail = tmpTail;
                }else{
                    newTail.next = tmpCurrent;
                    newTail = tmpTail;
                }
                i = 0;
            }
        }
        if(i == 2){
            if(newTail == null){
                newHead = tmpCurrent;
            }else{
                newTail.next = tmpCurrent;
            }
//            如果是K反转，小于K时需要将tmp再反转接到newTail。
        }else if(i == 1){
            if(newTail == null){
                newHead = tmpCurrent;
            }else{
                newTail.next = tmpCurrent;
            }
        }
        return newHead;
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

        ListNode listNode = swapPairs(node1);
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}