package algorithm.heap;

import java.util.Arrays;

/**
 * 合并M个有序的数组/链表
 * M个节点的堆，每个节点为一个数组，值为第一个元素。
 * 构建小顶堆，取堆顶元素，后堆顶值为数组的下一个元素，然后下沉，再取堆。
 *
 * 数组需要记录每个数组当前在堆中值的位置，可以转化成链表。
 */
public class MergeSortedArray {
    public static void main(String[] args){
        Node a1 = new Node();
        Node a2 = new Node();
        Node a3 = new Node();
        a1.next = a2;
        a2.next = a3;
        a1.value = 1;
        a2.value = 3;
        a3.value = 5;

        Node b1 = new Node();
        Node b2 = new Node();
        Node b3 = new Node();
        b1.next = b2;
        b2.next = b3;
        b1.value = 2;
        b2.value = 4;
        b3.value = 9;

        Node c1 = new Node();
        Node c2 = new Node();
        c1.next = c2;
        c1.value = 3;
        c2.value = 5;

        Node[] nodes = new Node[]{a1, b1, c1};
        Node t = mergeSortedArray(nodes);
        printNode(t);
    }

    public static Node mergeSortedArray(Node[] nodes){
        Node node = new Node();
        Node current = node;
        for(int i = nodes.length - 1; i >= 0; i--){
            int k = (i - 1) / 2;
            if(k < 0) break;
            downForMin(nodes, k);
        }
        while(nodes[0] != null){
//            取堆顶，并更新堆顶为下一个元素
            current.value = nodes[0].value;
            nodes[0] = nodes[0].next;
//            当堆顶链表取完时，向堆排序一样，将堆尾链表移到堆顶。
            if(nodes[0] == null){
                if(nodes.length == 1){
                    break;
                }
                nodes[0] = nodes[nodes.length - 1];
                nodes = Arrays.copyOfRange(nodes, 0, nodes.length - 1);
            }
            downForMin(nodes, 0);

//            记录结果node位置
            current.next = new Node();
            current = current.next;
        }
        return node;
    }

    public static void downForMin(Node[] nodes, int k){
        int min, minp;
        while (2 * k + 1 <= nodes.length - 1){
            min = nodes[2 * k + 1].value;
            minp = 2 * k + 1;
            if(2 * k + 2 <= nodes.length - 1 && min > nodes[2 * k + 2].value){
                min = nodes[2 * k + 2].value;
                minp = 2 * k + 2;
            }
            if(nodes[k].value > min){
                Node tmp = nodes[k];
                nodes[k] = nodes[minp];
                nodes[minp] = tmp;
                k = minp;
            }else{
                break;
            }
        }
    }

    static void printNode(Node node){
        StringBuilder stb = new StringBuilder();
        while(node != null){
            stb.append(node.value);
            node = node.next;
            if(node != null){
                stb.append("->");
            }
        }
        System.out.println(stb.toString());
    }
}

class Node{
    public int value;
    public Node next;
}
