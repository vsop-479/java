package designPattern.singleton.dcl;

/**
 * Created by zhouhui on 2018/11/25.
 */
public class Singleton {
//    如果不加volatile，其他线程不能立即看见singleton，会再次new.
    private static volatile Singleton singleton = null;
    private Singleton(){}

    public static Singleton get(){
//       todo warning:其他线程可以在此看见未构造完成的singleton。
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
