package com.code.monks.Controller;

import com.code.monks.Service.EmailService;
import com.code.monks.Service.SmsService;
import com.code.monks.Service.WhatsAppService;
import com.code.monks.dtos.request.EmailRequestDto;
import com.code.monks.dtos.request.SmsRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sms/send")
@RequiredArgsConstructor
public class MessageController {
    private final SmsService smsService;
    private final EmailService emailService;
    private final WhatsAppService whatsAppService;

    @PostMapping
    public ResponseEntity<String> sendSms(@RequestBody SmsRequestDto smsRequest) {
        smsService.sendMessage(smsRequest);
        return ResponseEntity.ok("SMS sent successfully");
    }

    @PostMapping("/email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequestDto emailRequest) {
        emailService.sendMessage(emailRequest);
        return ResponseEntity.ok("Email sent successfully");
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendWhatsapp(@RequestBody SmsRequestDto smsRequest) {
        whatsAppService.sendWhatsapp(smsRequest);
        return ResponseEntity.ok("WhatsApp message sent successfully!");
    }
}
