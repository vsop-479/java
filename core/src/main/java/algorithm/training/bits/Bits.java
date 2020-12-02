package algorithm.training.bits;

import java.util.BitSet;

public class Bits {

    //int max value 2^31 - 1. size.
    //size: 2^31 bit -> 2^28 byte -> 2^8 Mb.
    public static void bitMaxSize(){
        BitSet bitSet = new BitSet(Integer.MAX_VALUE);
        bitSet.set(0);
    }

//    get Nth bit.
    public static int getNthBit(int num, int N){
        return num >> (N - 1) & 1;
    }


}
