package com.bnyte.message.push.sse.product;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author bnyte
 * @since 1.0.0
 */
public class SseProduct implements Runnable {

    private SseEmitter sse;
    private final AtomicInteger count = new AtomicInteger();

    public SseProduct(SseEmitter sseEmitter) {
        this.sse = sseEmitter;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sse.send("this is sse push a message, current number is: " + count.getAndIncrement());
                Thread.sleep(2000L);
            } catch (IOException | InterruptedException e) {
//                throw new RuntimeException(e);
                sse = new SseEmitter();
                try {
                    sse.send("this is sse push a message, current number is: " + count.getAndIncrement());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public SseEmitter getSse() {
        return sse;
    }
}
