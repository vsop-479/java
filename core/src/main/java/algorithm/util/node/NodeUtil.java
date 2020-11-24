package algorithm.util.node;

public class NodeUtil {
    public static void printNode(Node node){
        while(node != null){
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println();
    }
    
    public static Node generateNode(){
        Node head = new Node();
        head.value = 1;
        Node currentNode = head;
        for(int i = 2; i <= 10; i++){
            Node node = new Node();
            node.value = i;
            currentNode.next = node;
            currentNode = node;
        }
        return head;
    }
}
