package algorithm.scanTree.depthScan;

import java.util.Stack;

public class DepthScanTree {
    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node getTree(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        return node1;
    }

    public static void depthScan(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.value);
        depthScan(node.left);
        depthScan(node.right);
    }

    public static void depthScanWithStack(Node node){
        if(node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        Node topNode;
        while(!stack.empty()){
            topNode = stack.pop();
            if(topNode != null){
                System.out.println(topNode.value);
            }
            if(topNode.right != null){
                stack.push(topNode.right);
            }
            if(topNode.left != null){
                stack.push(topNode.left);
            }
        }
    }

    public static void main(String[] args){
       Node node = getTree();
       depthScan(node);
       depthScanWithStack(node);
    }
}
