package com.bnyte.message.push.sse.controller;

import com.bnyte.message.push.sse.product.SseProduct;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

/**
 * @author bnyte
 * @since 1.0.0
 */
@RestController
@RequestMapping("/sse")
@CrossOrigin
public class SseController {
    private static SseEmitter sse = null;
    private static SseProduct sseProduct = null;

    @GetMapping("/starter/{key}")
    public SseEmitter starter(@PathVariable("key") String key) throws IOException {
        if (sse == null) {
            synchronized (SseController.class) {
                if (sse == null) {
                    sse = new SseEmitter();
                    sse.onTimeout(() -> {
                        sse = new SseEmitter();
                        sseProduct = null;
                    });
                    sse.onError((throwable) -> {
                        System.out.println("过期了 看看会不会重试");
                        sse = new SseEmitter();
                    });
                }
            }
        }
        if (sseProduct == null) {
            sseProduct = new SseProduct(sse);
            sseProduct.run();
        }
        return sse;
    }

}
