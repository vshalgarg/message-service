package com.code.monks.Controller;

import com.code.monks.Service.EmailService;
import com.code.monks.dtos.request.EmailRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/send/email")
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    public String sendEmail(@RequestBody EmailRequestDto emailRequest) {
        emailService.sendEmail(emailRequest);
        return "Email Sent Successfully";
    }
}
