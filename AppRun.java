package com.hpe.Run;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.ThreadMXBean;

/**
 * Created by DELL on 2017/2/8.
 */
public class AppRun implements Runnable {
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(3000);
//                MemoryUsage memoryUsage = new MemoryUsage(-1,0,0,-1);
//                System.out.println("Java 虚拟机使用的内存量"+memoryUsage.getCommitted());
                MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
                MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();
                System.out.println("Java 虚拟机使用的内存量"+nonHeapMemoryUsage.getCommitted());
                ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
                long[] allThreadIds = threadMXBean.getAllThreadIds();
                System.out.println("allthreadIds:"+allThreadIds.length);
                System.out.println("守护线程和非守护线程:"+threadMXBean.getThreadCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
