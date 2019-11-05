package algorithm.leetcode.divideTwoIntegers;

/**
 * 不使用乘法、除法和 mod 运算符实现除法。
 * https://leetcode-cn.com/problems/divide-two-integers/
 * 考虑使用减法，防止溢出Math.abs(Integer.MIN_VALUE)会溢出，用负数相减。
 * 右移（只能除数是2的n次方时)
 */
public class Solution {
    public static int divide(int dividend, int divisor) {
        if(dividend == 0 || divisor == 1){
            return dividend;
        }
        if(divisor == -1){
            if(dividend == Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }else{
                return -dividend;
            }
        }
        boolean sameSigned = false;
        if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)){
            sameSigned = true;
        }

        if(dividend > 0){
            dividend = -dividend;
        }
        if(divisor > 0){
            divisor = -divisor;
        }

        int i = 0;
        while(dividend <= divisor){
            dividend = dividend - divisor;
            i++;
        }
        return sameSigned ? i : -i;
    }

    public static void main(String[] args){
        int i = divide(-2147483648, 2);
        System.out.println(i);
    }
}
