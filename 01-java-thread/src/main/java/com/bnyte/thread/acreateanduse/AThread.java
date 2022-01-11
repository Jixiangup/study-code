package com.bnyte.thread.acreateanduse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * 线程的创建和使用
 *
 * @author bnyte
 * @date 2022/1/11 19:26
 * @mail bnytezz@gmail.com
 */
public class AThread extends Thread {
    public Integer number = 100;
//    public ConcurrentSkipListSet<Integer> oldNumbers = new ConcurrentSkipListSet<Integer>();
    public List<Integer> oldNumbers = new ArrayList<>();

    @Override
    public void run() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException ignored) {}
        for (int i = 0; i < 100; i++) {
            if (number % 2 != 0) {
                this.oldNumbers.add(number);
            }
            number--;
        }
//        System.out.println("run thread = id: " + Thread.currentThread().getId() + ", name: " + currentThread().getName()); // a-thread线程
    }
}

class AThreadTest {
    public static void main(String[] args) {
        AThread aThread = new AThread();
        aThread.start();
        System.out.println("after result: " + aThread.oldNumbers); // 空数组 | 真正执行结果 | 报错 ConcurrentModificationException
        System.out.println("main thread = id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName()); // main线程
    }
}
