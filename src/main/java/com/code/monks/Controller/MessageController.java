package com.code.monks.Controller;

import com.code.monks.Services.MessageInvoker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/message")
@RequiredArgsConstructor
public class MessageController {

    @Autowired
    private MessageInvoker dispatcher;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestParam String type, @RequestBody String jsonPayload) {
        try {
            dispatcher.dispatch(type, jsonPayload);
            return ResponseEntity.ok("Message sent");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
