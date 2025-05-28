package com.code.monks.Controller;

import com.code.monks.Service.SmsService;
import com.code.monks.dtos.request.SmsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sms/send")
@RequiredArgsConstructor
public class SmsController {
    private final SmsService smsService;

    @PostMapping
    public String sendSms(@RequestBody SmsRequest request) {
        smsService.sendSms(request);
        return "SMS Sent Successfully";
    }
}
