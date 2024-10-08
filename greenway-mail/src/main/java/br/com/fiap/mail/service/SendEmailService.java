package br.com.fiap.mail.service;

import br.com.fiap.mail.model.EmailData;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class SendEmailService {

    private final JavaMailSender mailSender;

    public void sendEmail(EmailData email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.getFrom());
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getBody());

        log.info("Sending email to: {}", email.getTo());

        mailSender.send(message);

        log.info("Email sent successfully");
    }

}
