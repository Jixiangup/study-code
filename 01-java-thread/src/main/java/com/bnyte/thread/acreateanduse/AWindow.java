package com.bnyte.thread.acreateanduse;

import java.util.ArrayList;
import java.util.List;

/**
 * 买票窗口
 *
 * @author bnyte
 * @date 2022/1/12 12:57
 * @mail bnytezz@gmail.com
 */
public class AWindow extends Thread {

    private static int ticket = 3;

    @Override
    public void run() {
    }
}

class WindowTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (Integer integer : list ) {
            if (integer == 3) list.remove(integer);
            System.out.println(list);
        }
    }
}
