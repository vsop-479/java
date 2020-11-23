package algorithm.splitNode;

public class Solution {
    public static void main(String[] args){
        Node head = new Node();
        head.value = 1;
        Node currentNode = head;
        for(int i = 2; i <= 10; i++){
            Node node = new Node();
            node.value = i;
            currentNode.next = node;
            currentNode = node;
        }
        printNode(head);
        splitNode(head);
    }

    public static void splitNode(Node node){
        Node head1 = null, tail1 = null;
        Node head2 = null, tail2 = null;

        boolean node1Flag = true;
        while (node != null){
            if(node1Flag){
                if(head1 == null){
                    head1 = node;
                    tail1 = node;
                }else{
                    tail1.next = node;
                    tail1 = node;
                }
                node1Flag = false;
            }else{
                if(head2 == null){
                    head2 = node;
                    tail2 = node;
                }else{
                    tail2.next = node;
                    tail2 = node;
                }
                node1Flag = true;
            }
            node = node.next;
        }
        tail1.next = null;
        tail2.next = null;
        printNode(head1);
        printNode(head2);
    }

    public static void printNode(Node node){
        while(node != null){
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println();
    }
}


class Node{
    int value;
    Node next;
}