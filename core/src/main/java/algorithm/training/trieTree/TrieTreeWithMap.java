package algorithm.training.trieTree;

import java.util.HashMap;
import java.util.Map;

/**
 * like fst.
 */
public class TrieTreeWithMap {
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
            if(current.children.containsKey(str.charAt(i))){
                current = current.children.get(str.charAt(i));
                if(i == str.length() - 1){
                    current.value = value;
                }
            }else{
//                adding.
                while(i < str.length()){
                    current.children.put(str.charAt(i), new Node(-1));
                    if(i == str.length() - 1){
                        current.children.get(str.charAt(i)).value = value;
                    }
                    current = current.children.get(str.charAt(i));
                    i++;
                }
            }
        }
    }

    public int search(String str){
        Node current = root;
        int i = 0;
        while(i < str.length()){
            if(current.children.containsKey(str.charAt(i))){
                current = current.children.get(str.charAt(i));
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
        TrieTreeWithMap trieTree = new TrieTreeWithMap();
        trieTree.insert("apple", 1);
        trieTree.insert("app", 3);
        trieTree.insert("banana", 4);

        System.out.println(trieTree.search("apple"));
        System.out.println(trieTree.search("app"));
        System.out.println(trieTree.search("banana"));

        trieTree.insert("bus1", 6);
        trieTree.insert("bus2", 7);
        trieTree.insert("bp", 9);

        System.out.println(trieTree.search("bus1"));
        System.out.println(trieTree.search("bus2"));
        System.out.println(trieTree.search("bp"));
    }

    public TrieTreeWithMap(){
        root = new Node(-1);
    }

    private class Node{
        int value;
        Map<Character, Node> children = new HashMap<>();
        public Node(int value){
            this.value = value;
        }
    }
}
