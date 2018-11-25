package designPattern.singleton.dcl;

/**
 * Created by zhouhui on 2018/11/25.
 */
public class Singleton {
//    �������volatile�������̲߳�����������singleton�����ٴ�new.
    private static volatile Singleton singleton = null;
    private Singleton(){}

    public static Singleton get(){
//       todo warning:�����߳̿����ڴ˿���δ������ɵ�singleton��
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
