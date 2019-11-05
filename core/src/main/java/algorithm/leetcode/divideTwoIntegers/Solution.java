package algorithm.leetcode.divideTwoIntegers;

/**
 * 不使用乘法、除法和 mod 运算符实现除法。
 * https://leetcode-cn.com/problems/divide-two-integers/
 */
public class Solution {
    /**
     * 考虑使用减法，防止溢出Math.abs(Integer.MIN_VALUE)会溢出，用负数相减。
     * @param dividend
     * @param divisor
     * @return
     */
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

    /**
     * 10 / 1：则10 - 8，2 - 1。
     * 10 / 3：则10 - 9， 1 /3。
     * 每次减去dividend下divisor的最大倍数。
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide2(int dividend, int divisor) {
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

        int x, y;
        int i = 0;
        while (dividend <= divisor) {
            x = divisor;
            y = 1;
//            找出dividend下，divisor的最大倍数。
            while (dividend - x <= x) {
                x += x;
                y += y;
            }
            dividend -= x;
            i += y;
        }
        return sameSigned ? i : -i;
    }

    /**
     * 10 / 1：则10 - 1 * 2 ^ 3，2 - 1。
     * 10 / 3：则10 - 3 * 2 ^ 1， 4 - 3。
     * 每次减去dividend下divisor的最大2的指数倍。
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide3(int dividend, int divisor) {
        if (dividend < divisor)
            return 0;
        int x = divisor;
        int y = 1;
        while (dividend >= (x << 1)) {
            x <<= 1;
            y <<= 1;
        }
        return divide3(dividend - x, divisor) + y;
    }

    public static void main(String[] args){
        int divide = -10;
        int divisor = 2;
        int i = divide(divide, divisor);
        int i2 = divide2(divide, divisor);
        System.out.println(i);
        System.out.println(i2);
    }
}
