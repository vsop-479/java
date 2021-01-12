package reference.gc;

import java.lang.ref.WeakReference;
import java.util.Arrays;

/**
 * https://blogs.oracle.com/poonam/weakreferences-and-gc
 */
public class WeakReferencesPromotion {
    private static final int BUFFER_SIZE = 65536;
    public static volatile MyObject strongRef;

    public static void main(String[] args) throws InterruptedException {
        final Object[] refs = new Object[BUFFER_SIZE];
        for (int index = 0;;) {
            MyObject object = MyObject.createMyObject();

            // hold a strong reference to this newly created object
            strongRef = object;
            // In the next iteration, at this point, this 'object' will only be reachable through
            // the WeakReference instance at refs[index]

            // create WeakReference instace holding 'object' as its referent
            // WeakReference instance itself is atrongly reachable through refs[]
            refs[index++] = new WeakReference<>(object);

            if (index == BUFFER_SIZE) {
                // make the WeakReference objects in the array unreachable
                Arrays.fill(refs, null);
                index = 0;
            }
        }
    }
}

class MyObject {
    byte[] bytes;
    public static MyObject createMyObject() {
        MyObject obj = new MyObject();
        obj.bytes = new byte[190];
        return obj;
    }
}
