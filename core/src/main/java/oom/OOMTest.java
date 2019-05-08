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
 */
public class OOMTest {
    private static final int MB = 1024 * 1024;

    public static void main(String[] args){
        byte[] a = new byte[MB * 1000];
        byte[] b = new byte[MB * 1000];
        byte[] c = new byte[MB * 1000];

        List<byte[]> bytes = new ArrayList<>();
        bytes.add(a);
        bytes.add(b);
        bytes.add(c);
    }
}
