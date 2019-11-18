package algorithm.bloomFilter;

import java.util.BitSet;

public class BloomFilter {
//    bit set 初始大小2^24个bit
    private static final int DEFAULT_SIZE = 1 << 25;
//    多个hash函数的种子，取质数
    private static final int[] seeds = new int[]{5, 7, 11, 13, 31, 37, 61};
    private BitSet bitSet = new BitSet(DEFAULT_SIZE);
    private SimpleHash[] func = new SimpleHash[seeds.length];

    public BloomFilter(){
        for(int i = 0; i < seeds.length; i++){
            func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
        }
    }

//    将str各个hash 函数求到的index，都设置为1。
    public void add(String str){
        for(int i = 0; i < func.length; i++){
            int index = func[i].hash(str);
            bitSet.set(index);
        }
    }

//    如果有一个函数值为0，则该str不存在。
//    如果全部为1，则有误差。
    public boolean contains(String str){
        if(str == null){
            return false;
        }
        for(int i = 0; i < func.length; i++){
            int index = func[i].hash(str);
            if(!bitSet.get(index)){
                return false;
            }
        }
        return true;
    }
}
