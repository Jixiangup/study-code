package com.bnyte.thread.acreateanduse;

/**
 * 使用实现Runnable创建多线程
 *
 * @author bnyte
 * @date 2022/1/12 13:05
 * @mail bnytezz@gmail.com
 */
public class BRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

class BRunnableTest {
    public static void main(String[] args) {
        BRunnable runnable = new BRunnable();

        Thread t1 = new Thread(runnable);
        t1.setName("线程一");
        t1.start();
    }
}
