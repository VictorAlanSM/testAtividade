package br.com.fiap.mail.listener;

import br.com.fiap.mail.model.EmailData;
import br.com.fiap.mail.service.SendEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MessageListener {

    private final SendEmailService service;

    @RabbitListener(queues = "mail_queue")
    public void receiveMessage(EmailData message) {
        service.sendEmail(message);
    }

}
