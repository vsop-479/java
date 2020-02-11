package reference.weak.property;

import java.lang.ref.WeakReference;

public class Test {
    public static void main(String[] args){
        User user = new User();
        Info i = new Info();
        WeakReference<Info> infoWR = new WeakReference<>(i);
        //需要把i指向info对象的强引用置为null，只保留weak reference。
        i = null;
        user.infoWR = infoWR;
//        i2同样增加了强引用。
//        Info i2 = user.infoWR.get();
        System.out.println(user.infoWR.get());
        //增加虚拟机参数-XX:+PrintGCDetails，输出gc信息，确定gc发生了。
        System.gc();
        System.out.println(user.infoWR.get());
    }
}

class User{
    //不能Info info，因会增加强引用。
    WeakReference<Info> infoWR;
}

class Info{
}
