package constantPool.streng;

public class Test {
    public static void main(String[] args){
        String a = "aaa";//使用常量池中的对象
        String b = "aaa";
        System.out.println(a == b);
        String c = new String("aaa");//在堆中创建对象
        System.out.println(a == c);

        String str1 = "str";
        String str2 = "ing";

        String str3 = "str" + "ing";//常量池中的对象
        String str4 = str1 + str2; //只要不是""，就在堆上创建的新的对象
        String str5 = "string";//常量池中的对象
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false
    }
}
