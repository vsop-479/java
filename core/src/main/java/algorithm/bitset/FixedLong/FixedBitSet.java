package algorithm.bitset.FixedLong;

import java.util.Arrays;

/**
 * SIMD:store bits with long[].
 *
 */
public class FixedBitSet {
    private final long[] bits;
    private final int numBits; // The number of bits in use
    private final int numWords; // The exact number of longs needed to hold numBits (<= bits.length)

    public FixedBitSet(int numBits) {
        this.numBits = numBits;
        bits = new long[bits2words(numBits)];
        numWords = bits.length;
    }

    public static void main(String[] args){
        FixedBitSet fixedBitSet = new FixedBitSet(1_000_000);
//        fixedBitSet.set(0, 1_000_000);
//        boolean b = fixedBitSet.get(50);
//        b = fixedBitSet.get(27);
        fixedBitSet.set(70);
        boolean b = fixedBitSet.get(70);


    }

    /**
     * bits2long
     * bits/64
     * @param numBits
     * @return
     */
    public static int bits2words(int numBits) {
        return ((numBits - 1) >> 6) + 1; // I.e.: get the word-offset of the last bit and add one (make sure to use >> so 0 returns 0!)
    }

    public void set(int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }

        int startWord = startIndex >> 6;
        int endWord = (endIndex-1) >> 6;

        long startmask = -1L << startIndex;
        long endmask = -1L >>> -endIndex;  // 64-(endIndex&0x3f) is the same as -endIndex since only the lowest 6 bits are used

        if (startWord == endWord) {
            bits[startWord] |= (startmask & endmask);
            return;
        }

        bits[startWord] |= startmask;
        Arrays.fill(bits, startWord+1, endWord, -1L);
        bits[endWord] |= endmask;
    }

    public void set(int index) {
        assert index >= 0 && index < numBits: "index=" + index + ", numBits=" + numBits;
        int wordNum = index >> 6;      // div 64
        long bitmask = 1L << index;
        bits[wordNum] |= bitmask;
    }

    public boolean get(int index) {
        assert index >= 0 && index < numBits: "index=" + index + ", numBits=" + numBits;
        int i = index >> 6;               // div 64
        // signed shift will keep a negative index and force an
        // array-index-out-of-bounds-exception, removing the need for an explicit check.
        long bitmask = 1L << index;
        return (bits[i] & bitmask) != 0;
    }
}
