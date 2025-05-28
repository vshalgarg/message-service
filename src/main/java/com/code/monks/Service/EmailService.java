package com.code.monks.Service;

import com.code.monks.dtos.request.EmailRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void sendEmail(EmailRequestDto emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getEmail());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getBody());
        javaMailSender.send(message);
    }
}
