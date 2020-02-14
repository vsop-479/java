package reference.weak.property;

import java.lang.ref.WeakReference;

public class Test {
    public static void main(String[] args){
        User user = new User();
        Info i = new Info();
        WeakReference<Info> infoWR = new WeakReference<>(i);
        WeakReference<Info[]> infosWR = new WeakReference<>(new Info[2]);
        //需要把i指向info对象的强引用置为null，只保留weak reference。
        i = null;
        user.infoWR = infoWR;
        user.infosWR = infosWR;
//        i2同样增加了强引用。
//        Info i2 = user.infoWR.get();
//        for循环后不会回收。
        for(Info info : user.infosWR.get()){
            System.out.println(info);
            info = null;
        }
//        只get可以回收。
//        user.infosWR.get();
        System.out.println("info: " + user.infoWR.get());
        System.out.println("infos: " + user.infosWR.get());
        //增加虚拟机参数-XX:+PrintGCDetails，输出gc信息，确定gc发生了。
        System.gc();
        System.out.println("info: " + user.infoWR.get());
        System.out.println("infos: " + user.infosWR.get());

    }
}

class User{
    //不能Info info，因会增加强引用。
    WeakReference<Info> infoWR;
    WeakReference<Info[]> infosWR;

}

class Info{
}
