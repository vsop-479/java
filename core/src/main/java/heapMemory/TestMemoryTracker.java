package heapMemory;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;

public class TestMemoryTracker {
    private static final MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
    private static final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    void f(){
        memoryMXBean.gc();
        memoryMXBean.getHeapMemoryUsage().getUsed();
    }

    public static void main(String[] args){
        System.out.println("heap used: " + memoryMXBean.getHeapMemoryUsage().getUsed());
        System.out.println("heap max: " + memoryMXBean.getHeapMemoryUsage().getMax());

        System.out.println("thread count: " + threadMXBean.getThreadCount());
    }
}
