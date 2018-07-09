package classloader.init.array;

public class Test {
    public static void main(String[] args){
//通过数组定义来引用类，不会触发此类的初始化。
        A[] a = new A[10];
    }
}
