package reference.weak.extendz;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class TestQueue {
    private static final ReferenceQueue<Object> queue = new ReferenceQueue<>();

    public static void main(String[] args){

        Info2 i = new Info2();
//queue中存放回收后的weakReference(User2), info为referent，回收后referent为null。
        User2 user = new User2(i, queue);
//        需要把i指向info对象的强引用置为null，只保留weak reference。
        i = null;
        System.out.println(user.get());
        System.out.println(queue.poll());
        //增加虚拟机参数-XX:+PrintGCDetails，输出gc信息，确定gc发生了。
        System.gc();
        System.out.println(user.get());
        System.out.println(queue.poll());
    }
}

class User2 extends WeakReference<Info2> {
    public User2(Info2 info, ReferenceQueue<Object> queue) {
        super(info, queue);
    }
}

class Info2{
}
