package com.learning.sse.sse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sse/clients")
@RequiredArgsConstructor
public class ClientSseController {
    private final ClientBalanceSseEmitter sseService;

    @GetMapping(
        value = "/subscribe",
        produces = MediaType.TEXT_EVENT_STREAM_VALUE
    )    public SseEmitter subscribe() {
        return sseService.subscribe();
    }
}
