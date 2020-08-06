package designPattern.singleton.dcl;

/**
 * Created by zhouhui on 2018/11/25.
 */
public class Singleton {
//    如果不加volatile，其他线程不能立即看见singleton，会再次new.
    private static volatile Singleton singleton = null;
    private Singleton(){}

    public static Singleton get(){
//     1.5之前的volatile，没有happens-before，volatile不禁用重排序。其他线程可以在此看见未构造完成的singleton。
//  happens-before & volatile: 对一个volatile变量的写(new Singleton)，happens-before与对它的读。
        if(singleton == null){
            synchronized(Singleton.class) {
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
