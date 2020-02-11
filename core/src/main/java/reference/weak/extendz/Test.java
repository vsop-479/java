package reference.weak.extendz;

import java.lang.ref.WeakReference;

public class Test {
    public static void main(String[] args){
        Info i = new Info();
        User user = new User(i);
//        需要把i指向info对象的强引用置为null，只保留weak reference。
        i = null;
        System.out.println(user.get());
        //增加虚拟机参数-XX:+PrintGCDetails，输出gc信息，确定gc发生了。
        System.gc();
        System.out.println(user.get());
    }
}

class User extends WeakReference<Info>{
    public User(Info info) {
        super(info);
    }
}

class Info{
}
