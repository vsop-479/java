package constantPool.streng;

public class Test {
    public static void main(String[] args){
        String a = "aaa";
        String b = "aaa";
        System.out.println(a == b);
        String c = new String("aaa");
        System.out.println(a == c);
    }
}
