package com.code.monks.Services.impl;

import com.code.monks.Services.GenericMessageService;
import com.code.monks.dtos.request.EmailRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailServiceImpl implements GenericMessageService<EmailRequestDto> {

    @Value("${spring.mail.username}")
    private String senderEmail;

    private final JavaMailSender mailSender;

    @Override
    public void sendMessage(EmailRequestDto request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(request.getEmail());
        message.setFrom(senderEmail);
        message.setSubject(defaultIfNull(request.getSubject(), "Welcome to Code Monks!"));
        message.setText(defaultIfNull(request.getBody(), "Hi there!\n\nThank you for joining Code Monks."));

        message.setFrom(senderEmail);
        try {
            mailSender.send(message);
            log.info("Email successfully sent to {}", request.getEmail());
        } catch (Exception e) {
            log.error("Failed to send email to {}: {}", request.getEmail(), e.getMessage());
        }
    }
    private String defaultIfNull(String value, String defaultValue) {
        return (value == null || value.trim().isEmpty()) ? defaultValue : value;
    }
}