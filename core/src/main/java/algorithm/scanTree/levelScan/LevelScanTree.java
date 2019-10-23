package algorithm.scanTree.levelScan;

import java.util.LinkedList;

/**
 * 层序遍历二叉树
 * 使用队列记录需要遍历的node，
 * 从链表中取出head，打印value，将head的left，right加入队列。
 */
public class LevelScanTree {
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

    public static void levelScan(Node root){
        LinkedList<Node> list = new LinkedList<>();
        list.offer(root);

        Node node = null;
        while((node = list.poll()) != null){
            System.out.println(node.value);
            if(node.left != null){
                list.offer(node.left);
            }
            if(node.right != null){
                list.offer(node.right);
            }
        }
    }

    public static void main(String[] args){
        Node root = getTree();
        levelScan(root);
    }
}

class Node{
    public int value;
    public Node left;
    public Node right;

    public Node(int value){
        this.value = value;
    }
}
