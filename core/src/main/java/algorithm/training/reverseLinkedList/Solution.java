package algorithm.training.reverseLinkedList;

import algorithm.util.node.Node;
import algorithm.util.node.NodeUtil;

public class Solution {

    public static Node reverseNode(Node node){
        Node currentNode = node;
        Node next = currentNode.next;

        Node targetHead = null;

        while(currentNode != null){
            currentNode.next = targetHead;
            targetHead = currentNode;

            currentNode = next;
            if(next != null){
                next = next.next;
            }
        }
        return targetHead;
    }

    public static void main(String[] args){
        Node node = NodeUtil.generateNode();
        NodeUtil.printNode(node);
        Node tNode = reverseNode(node);
        NodeUtil.printNode(tNode);
    }
}