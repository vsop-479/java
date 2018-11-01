package paramInput;

public class StringInput {
    public static void f(String a){
        a = "ffff";
    }

    public static void main(String[] args){
        String a = "aaaa";
        f(a);
//        还是原值
        System.out.println(a);
    }
}
