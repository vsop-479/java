package integer;

public class TestInt {
    public static void main(String[] args){
        int l = 1000000000;
        int maxValue = Integer.MAX_VALUE;
        System.out.println(maxValue);
//        负数：补码：符号位不变，数据位取反+1.
//        0xffffffff:-1的补码.
        System.out.println(0xffffffff);
        System.out.println(0x80000001);
    }
}
