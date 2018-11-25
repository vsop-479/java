package designPattern.singleton.holder;

/**
 * Created by zhouhui on 2018/11/25.
 */
public class Singleton {
    private Singleton(){}

    public static Singleton get(){
        return Holder.singleton;
    }

    private static class Holder{
        private static Singleton singleton = new Singleton();
    }
}
