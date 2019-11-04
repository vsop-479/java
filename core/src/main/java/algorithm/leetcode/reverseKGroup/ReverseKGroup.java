package algorithm.leetcode.reverseKGroup;

/**
 * Created by zhouhui on 2019/10/27.
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *  1：定义newHead，newTail用来记录反转后的node，返回newHead。
 *  2：定义tmpTail，tmpCurrent用来从currentNode反转K个node后，tmpCurrent连接到newTail，tmpTail为newTail。
 *  3：定义currentNode，next = currentNode.next取当前node，连接到tmp，即currentNode.next = tmpCurrent;
 */
public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
//        新链表
        ListNode newHead = null, newTail = null;
//        记录反转后的node，达到K个后，连接到newTail
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
            }else if(i < k){
                currentNode.next = tmpCurrent;
                tmpCurrent = currentNode;
                i++;
                currentNode = next;
                if(next != null){
                    next = next.next;
                }
            }else if(i == k){
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

//        while结束后，将剩余的tmpNode连接到newTail。
//        tmpNode长度为K，或者1，直接连接到tail。
        if(i == k || i == 1){
            if(newTail == null){
                newHead = tmpCurrent;
            }else{
                newTail.next = tmpCurrent;
            }
//            tmpNode长度大于1，且小于K时，需要将tmp再反转接到newTail。
        }else if(i > 1 && i < k){
            ListNode tmpNode = reverseList(tmpCurrent);
            if(newTail == null){
                newHead = tmpNode;
            }else{
                newTail.next = tmpNode;
            }
        }
        return newHead;
    }

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
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        ListNode listNode = reverseKGroup(node1, 3);
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
