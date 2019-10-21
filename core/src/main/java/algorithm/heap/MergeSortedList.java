package algorithm.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并M个有序的数组/链表
 * M个节点的堆，每个节点为一个数组，值为第一个元素。
 * 构建小顶堆，取堆顶元素，后堆顶值为数组的下一个元素，然后下沉，再取堆。
 *
 * 数组需要记录每个数组当前在堆中值的位置，可以转化成链表。
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class MergeSortedList {
    public static void main(String[] args){
        ListNode a1 = new ListNode(-1);
        ListNode a2 = new ListNode(-1);
        ListNode a3 = new ListNode(-1);
        a1.next = a2;
        a2.next = a3;
        a1.val = 1;
        a2.val = 3;
        a3.val = 5;

        ListNode b1 = new ListNode(-1);
        ListNode b2 = new ListNode(-1);
        ListNode b3 = new ListNode(-1);
        b1.next = b2;
        b2.next = b3;
        b1.val = 2;
        b2.val = 4;
        b3.val = 9;

        ListNode c1 = new ListNode(-1);
        ListNode c2 = new ListNode(-1);
        c1.next = c2;
        c1.val = 3;
        c2.val = 5;

        ListNode[] nodes = new ListNode[]{null, null, null};
        ListNode t = mergeSortedArray(nodes);
        printNode(t);
    }

    public static ListNode mergeSortedArray(ListNode[] listNodes){
        listNodes = filter(listNodes);
        if(listNodes == null || listNodes.length == 0){
            return null;
        }
        if(listNodes.length == 1){
            return listNodes[0];
        }

        ListNode node = new ListNode(-1);
        ListNode current = node;
        for(int i = listNodes.length - 1; i >= 0; i--){
            int k = (i - 1) / 2;
            if(k < 0) break;
            downForMin(listNodes, k);
        }
        while(listNodes[0] != null){
//            取堆顶，并更新堆顶为下一个元素
            current.val = listNodes[0].val;
            listNodes[0] = listNodes[0].next;
//            当堆顶链表取完时，向堆排序一样，将堆尾链表移到堆顶。
            if(listNodes[0] == null){
                if(listNodes.length == 1){
                    break;
                }
                listNodes[0] = listNodes[listNodes.length - 1];
                listNodes = Arrays.copyOfRange(listNodes, 0, listNodes.length - 1);
            }
            downForMin(listNodes, 0);

//            记录结果node位置
            current.next = new ListNode(-1);
            current = current.next;
        }
        return node;
    }

    public static void downForMin(ListNode[] nodes, int k){
        int min, minp;
        while (2 * k + 1 <= nodes.length - 1){
            min = nodes[2 * k + 1].val;
            minp = 2 * k + 1;
            if(2 * k + 2 <= nodes.length - 1 && min > nodes[2 * k + 2].val){
                min = nodes[2 * k + 2].val;
                minp = 2 * k + 2;
            }
            if(nodes[k].val > min){
                ListNode tmp = nodes[k];
                nodes[k] = nodes[minp];
                nodes[minp] = tmp;
                k = minp;
            }else{
                break;
            }
        }
    }

    public static ListNode[] filter(ListNode[] listNodes){
        List<ListNode> list = new ArrayList<>();
        for(ListNode node : listNodes){
            if(node != null){
                list.add(node);
            }
        }
        return list.toArray(new ListNode[0]);
    }

    static void printNode(ListNode node){
        StringBuilder stb = new StringBuilder();
        while(node != null){
            stb.append(node.val);
            node = node.next;
            if(node != null){
                stb.append("->");
            }
        }
        System.out.println(stb.toString());
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
