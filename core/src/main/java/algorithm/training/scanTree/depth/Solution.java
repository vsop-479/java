package algorithm.training.scanTree.depth;

import algorithm.util.tree.TreeNode;
import algorithm.util.tree.TreeNodeUtil;

import java.util.Stack;

public class Solution {

    public static void depthScanWithRecursion(TreeNode node){
        if(node != null){
            System.out.print(node.value + ", ");
        }
        if(node.left != null){
            depthScanWithRecursion(node.left);
        }
        if(node.right != null){
            depthScanWithRecursion(node.right);
        }
    }

    public static void depthScanWithStack(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        TreeNode currentNode;
        while(!stack.empty()){
            currentNode = stack.pop();
            System.out.print(currentNode.value + ", ");
            if(currentNode.right != null){
                stack.push(currentNode.right);
            }
            if(currentNode.left != null){
                stack.push(currentNode.left);
            }
        }
    }

    public static void main(String[] args){
        TreeNode treeNode = TreeNodeUtil.generateTree();
        depthScanWithRecursion(treeNode);
        System.out.println();
        depthScanWithStack(treeNode);
    }
}
