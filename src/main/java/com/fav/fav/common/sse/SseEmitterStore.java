package com.fav.fav.common.sse;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Component
public class SseEmitterStore {
    private final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();

    public SseEmitter addEmitter(String id) {
        SseEmitter emitter = new SseEmitter(60_000L);
        emitters.put(id, emitter);
        emitter.onCompletion(() -> emitters.remove(id));
        emitter.onTimeout(() -> emitters.remove(id));
        return emitter;
    }

    public void sendEvent(String id, String message) {
        SseEmitter emitter = emitters.get(id);
        if (emitter != null) {
            try {
                emitter.send(SseEmitter.event().name("message").data(message));
            } catch (IOException e) {
                emitters.remove(id);
            }
        }
    }
}
