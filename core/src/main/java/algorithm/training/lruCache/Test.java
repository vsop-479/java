package algorithm.training.lruCache;

public class Test {
    public static void main(String[] args){
        LRUCache<String, Integer> cache = new LRUCache<>(5);
        cache.put("a", 1);
        cache.put("b", 1);
        cache.put("c", 1);
        cache.put("d", 1);
        cache.put("e", 1);
        cache.get("e");
        cache.get("d");
        cache.get("c");
        cache.get("b");
        cache.get("a");

        cache.put("f", 1);
        cache.printCurrentNode();
    }
}
