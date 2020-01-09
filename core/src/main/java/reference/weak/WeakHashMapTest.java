package reference.weak;

import java.util.Objects;
import java.util.WeakHashMap;

/**
 * Entry继承WeakReference，为key创建weak reference，并注册到queue。
 * gc时，当key没有其他的引用（强引用，soft引用）时，该Entry可以回收。String 类型的key不能回收（equals为值判断，而非先用引用判断）。
 */
public class WeakHashMapTest {
    public static void main(String[] args){
        WeakHashMap<User, Integer> map = new WeakHashMap<>();
        map.put(new User("lili", 7), 33);
        map.put(new User("gigi", 8), 33);
        map.put(new User("nini", 9), 33);
        System.out.println("dsf");
        System.gc();
        System.out.println("dsf");
    }
}

class User{
    private String name;
    private int age;

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
