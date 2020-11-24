package algorithm.training.scanTree.breadth;

import algorithm.util.tree.TreeNode;
import algorithm.util.tree.TreeNodeUtil;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

public class Solution {
    public static void breadthScan(TreeNode node){
        Queue<TreeNode> queue = new LinkedTransferQueue<>();
        queue.offer(node);

        TreeNode currentNode;
        while((currentNode = queue.poll()) != null){
            System.out.println(currentNode.value);
            if(currentNode.left != null){
                queue.offer(currentNode.left);
            }
            if(currentNode.right != null){
                queue.offer(currentNode.right);
            }
        }
    }

    public static void main(String[] args){
        TreeNode treeNode = TreeNodeUtil.generateTree();
        breadthScan(treeNode);
    }
}
