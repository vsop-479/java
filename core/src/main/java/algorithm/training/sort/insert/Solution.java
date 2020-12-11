package algorithm.training.sort.insert;

import algorithm.util.node.NodeUtil;

public class Solution {
    static class Node{
        int value;
        Node prev;
        Node next;
        Node(int value){
            this.value = value;
        }
    }

    public static Node insertSort(int[] a){
        Node head = null, tail = null;
        for(int i : a){
            if(head == null){
                head = new Node(i);
                tail = head;
            }else{
                Node currentNode = head;
                while(currentNode != null){
                    if(i >= currentNode.value){
                        if(currentNode == tail){
                            //link to tail.
                            Node newNode = new Node(i);
                            tail.next = newNode;
                            newNode.prev = tail;
                            tail = newNode;
                            break;
                        }
                        currentNode = currentNode.next;
                    }else{
                        Node newNode = new Node(i);
                        if(currentNode == head){
                            //link to head.
                            newNode.next = head;
                            head.prev = newNode;
                            head = newNode;
                            break;
                        }else{
                            //insert node.
                            currentNode.prev.next = newNode;
                            newNode.prev = currentNode.prev;
                            currentNode.prev = newNode;
                            newNode.next = currentNode;
                            break;
                        }
                    }
                }
            }
        }
        return head;
    }

    public static void main(String[] args){
        int[] a = new int[]{3, 5, 2, 1, 6, 9, 6, 5};
        Node node = insertSort(a);
        printNode(node);
        a = new int[]{4, 1, 22, 5, 24, 6, 1, 10, 13};
        node = insertSort(a);
        printNode(node);
    }

    public static void printNode(Node node){
        Node currentNode = node;
        while(currentNode != null){
            System.out.print(currentNode.value + "->");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}
