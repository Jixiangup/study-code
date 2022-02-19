package com.bnyte.thread.acreateanduse;

/**
 * 买票窗口
 *
 * @author bnyte
 * @date 2022/1/12 12:57
 * @mail bnytezz@gmail.com
 */
public class AWindow extends Thread {

    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized ("1") {
                if (ticket > 0) {
                    System.out.println(getName() + "卖的票号为: " + ticket);
                    ticket--;
                } else break;
            }
        }
    }
}

class WindowTest {

    public static void main(String[] args) {
        AWindow window1 = new AWindow();
        AWindow window2 = new AWindow();
        window2.setName("窗口2");
        window1.setName("窗口1");
        window1.start();
        window2.start();
    }
}
