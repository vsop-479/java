package designPattern.adapter;

/**
 * Created by zhouhui on 2018/12/2.
 */
public class B2A implements A{
    private B b;

    @Override
    public void a() {
        b.b();
    }
}
