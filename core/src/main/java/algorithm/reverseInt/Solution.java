package algorithm.reverseInt;

/**
 * 123 -> 321.
 */
public class Solution {
    public static int reverseInt(int i){
        int target = 0;
        while(i > 0){
            target = target * 10 + i % 10;
            i = i / 10;
        }
        return target;
    }

    public static void main(String[] args){
        System.out.println(reverseInt(123));
        System.out.println(reverseInt(1230));
        System.out.println(reverseInt(1023));
    }
}
