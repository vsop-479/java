package annotation;

import annotation.def.A;
import annotation.use.S;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException {
        Method f = S.class.getMethod("f");
        Annotation[] annotations = f.getAnnotations();
        for(Annotation annotation : annotations){
            if (annotation instanceof A){
                A a = (A) annotation;
                System.out.println(a.age());
                System.out.println(a.name());
            }
        }
    }

}
