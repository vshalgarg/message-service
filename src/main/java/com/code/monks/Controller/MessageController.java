package com.code.monks.Controller;

import com.code.monks.Services.impl.EmailServiceImpl;
import com.code.monks.Services.impl.SmsServiceImpl;
import com.code.monks.dtos.request.EmailRequestDto;
import com.code.monks.dtos.request.SmsRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.code.monks.constants.UrlConstants.*;

@RestController
@RequestMapping(BASE)
@RequiredArgsConstructor
public class MessageController {

    private final EmailServiceImpl emailService;
    private final SmsServiceImpl smsService;

    @PostMapping(SEND_EMAIL)
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequestDto emailRequest) {
        try {
            emailService.sendMessage(emailRequest);
            return ResponseEntity.ok("Email sent");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(SEND_SMS)
    public ResponseEntity<String> sendSms(@RequestBody SmsRequestDto smsRequest) {
        try {
            smsService.sendMessage(smsRequest);
            return ResponseEntity.ok("SMS sent");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
