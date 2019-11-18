package algorithm.bloomFilter;

/**
 * 实现简单hash 函数功能。
 */
public class SimpleHash {
    private int cap;
    private int seed;

    public SimpleHash(int cap, int seed) {
        this.cap = cap;
        this.seed = seed;
    }

    //hash 函数，采用简单的加权和hash
    public int hash(String value){
        int result = 0;
        int len = value.length();
        for(int i = 0; i < len; i++){
            result = seed * result + value.charAt(i);
        }
        return (cap - 1) & result;
    }
}
