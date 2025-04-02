package com.fav.fav.common.sse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/sse")
@Secured({ "ROLE_SYSTEM", "ROLE_SERVICE", "ROLE_USER" })
@RequiredArgsConstructor
public class SseController {
    private final SseEmitterStore sseEmitterStore;
    // private final String moduleName = "Server-Sent Events ";

    @GetMapping("/subscribe/{id}")
    public SseEmitter subscribe(@PathVariable String id) {
        return sseEmitterStore.addEmitter(id);
    }

    @PostMapping("/send/{id}")
    public ResponseEntity<String> sendEvent(@PathVariable String id, @RequestParam String message) {
        sseEmitterStore.sendEvent(id, message);
        return ResponseEntity.ok("Event sent");
    }
}
