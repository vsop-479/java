package reflect;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;

public class ListReflectMethod {
    public void listReflect() throws NoSuchFieldException {
        Class<User> clazz = User.class;
//        获取指定field
        Field mName = clazz.getDeclaredField("getName");
//        返回所有声明的
        clazz.getDeclaredField("name");
//        返回公有的
        clazz.getField("name");
        clazz.getMethods();
        clazz.getAnnotations();
        clazz.getInterfaces();
        AnnotatedType[] annotatedInterfaces = clazz.getAnnotatedInterfaces();
    }
}
