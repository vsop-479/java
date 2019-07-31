package oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM options: -Xms2048m -Xmx2048m
 * test1: 直接运行
 * 结果：得到异常日志java.lang.OutOfMemoryError: Java heap space，程序退出。
 *
 * test2: -XX:OnOutOfMemoryError="kill -9 %p"
 * 结果：得到异常日志java.lang.OutOfMemoryError: Java heap space，程序退出。
 *
 * test3: -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath="E:\dumps"
 * 结果：得到dump文件，及异常日志java.lang.OutOfMemoryError: Java heap space，程序退出。
 *
 * test4: -XX:OnOutOfMemoryError="kill -9 %p" -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath="E:\dumps"
 * 结果：得到dump文件，Executing "kill -9 19060"，及异常日志java.lang.OutOfMemoryError: Java heap space，程序退出。
 *
 * test5: try catch error oom后程序能否继续执行。
 * 结果：捕获error后，可以继续运行。
 */
public class OOMTest {
    private static final int MB = 1024 * 1024;

    public static void main(String[] args){
        try{
            //int[] 的元素在dump中不展示，但可以查到：select * from int[] s where s[0] = 1
            int[] i = new int[]{1, 2, 3, 4, 5, 6};
            byte[] a = new byte[MB * 1000];
            byte[] b = new byte[MB * 1000];
            byte[] c = new byte[MB * 1000];

            List<byte[]> bytes = new ArrayList<>();
            bytes.add(a);
            bytes.add(b);
            bytes.add(c);
        }catch(Error e){
            e.printStackTrace();
        }
        System.out.println("");
    }
}
