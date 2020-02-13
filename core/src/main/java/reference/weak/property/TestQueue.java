package reference.weak.property;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class TestQueue {
    private static final ReferenceQueue<Object> queue = new ReferenceQueue<>();

    public static void main(String[] args) {
        User2 user = new User2();
        Info2 i = new Info2();
//queue中存放回收后的weakReference(没有子类型）, info为referent，回收后referent为null。
        WeakReference<Info2> infoWR = new WeakReference<>(i, queue);
//需要把i指向info对象的强引用置为null，只保留weak reference。
        i = null;
        user.infoWR = infoWR;
//        i2同样增加了强引用。
//        Info i2 = user.infoWR.get();
        System.out.println(user.infoWR.get());
        System.out.println(queue.poll());
        //增加虚拟机参数-XX:+PrintGCDetails，输出gc信息，确定gc发生了。
        System.gc();
        System.out.println(user.infoWR.get());
        System.out.println(queue.poll());
    }
}

class User2{
    //不能Info info，因会增加强引用。
    WeakReference<Info2> infoWR;
}

class Info2{
}
