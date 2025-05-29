package com.code.monks.Service;

import com.code.monks.dtos.request.EmailRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService implements MessageService<EmailRequestDto>{

    private final JavaMailSender mailSender;

    @Override
    public void sendMessage(EmailRequestDto emailRequest) {
        if (emailRequest.getTo() == null || emailRequest.getMessage() == null) {
            throw new IllegalArgumentException("Email or body cannot be null");
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getMessage());

        mailSender.send(message);
    }
}
