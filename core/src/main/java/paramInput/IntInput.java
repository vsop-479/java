package paramInput;

public class IntInput {
    public static void f(int a){
        a = 10;
    }

    public static void main(String[] args){
        int a = 5;
        f(a);
//        还是原值
        System.out.println(a);
    }
}
