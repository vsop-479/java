package algorithm.training.trieTree;

import java.util.HashMap;
import java.util.Map;

/**
 * like fst.
 */
public class TrieTreeWithArray {
    private Node root;

    /**
     * value like tim's block's start pointer.
     * @param str
     * @param value
     */
//    todo graceful.
    public void insert(String str, int value){
        Node current = root;
        for(int i = 0; i < str.length(); i++){
//            finding.
            if(current.children[str.charAt(i) - 97] != null){
                current = current.children[str.charAt(i) - 97];
                if(i == str.length() - 1){
                    current.value = value;
                }
            }else{
//                adding.
                while(i < str.length()){
                    current.children[str.charAt(i) - 97] = new Node(-1);
                    if(i == str.length() - 1){
                        current.children[str.charAt(i) - 97].value = value;
                    }
                    current = current.children[str.charAt(i) - 97];
                    i++;
                }
            }
        }
    }

    public int search(String str){
        Node current = root;
        int i = 0;
        while(i < str.length()){
            if(current.children[str.charAt(i) - 97] != null){
                current = current.children[str.charAt(i) - 97];
                if(i == str.length() - 1){
                    return current.value;
                }
                i++;
            }else{
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        TrieTreeWithArray trieTree = new TrieTreeWithArray();
        trieTree.insert("apple", 1);
        trieTree.insert("app", 3);
        trieTree.insert("banana", 4);

        System.out.println(trieTree.search("apple"));
        System.out.println(trieTree.search("app"));
        System.out.println(trieTree.search("banana"));

        trieTree.insert("bus", 6);
        trieTree.insert("bp", 9);

        System.out.println(trieTree.search("bus"));
        System.out.println(trieTree.search("bp"));
    }

    public TrieTreeWithArray(){
        root = new Node(-1);
    }

    private class Node{
        int value;
        Node[] children = new Node[26];
        public Node(int value){
            this.value = value;
        }
    }
}
