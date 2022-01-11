package com.bnyte.thread.acreateanduse;

/**
 * thread方法测试
 *
 * @author bnyte
 * @date 2022/1/11 21:52
 * @mail bnytezz@gmail.com
 */
public class AThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        ThreadMethod method = new ThreadMethod();

        method.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            if (i == 1) method.join();
        }

    }
}

class ThreadMethod extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(currentThread().getName() + ": " + i);
        }
    }
}
