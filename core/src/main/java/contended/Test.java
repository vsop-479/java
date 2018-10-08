package contended;

import sun.misc.Contended;

/**
 * 在变量前面添加128字节的padding.
 * 消除缓存行的伪共享.
 * 要注意的是user classpath使用此注解默认是无效的，
 * 需要在jvm启动时设置-XX:-RestrictContended.
 */
public class Test {
    A a;
    @Contended
    B b;
    public static void main(String[] args){
      System.out.println("sdf");
    }
}

@Contended
class A{}

class B{}