package br.com.fiap.app.service;

import br.com.fiap.app.exception.NotFoundException;
import br.com.fiap.app.model.Collect;
import br.com.fiap.app.model.EmailData;
import br.com.fiap.app.repository.CollectRepository;
import br.com.fiap.app.response.CollectPostResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class EmailService {

    private final RabbitTemplate rabbitTemplate;
    private final CollectRepository collectRepository;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingKey;

    @Value("${email.from}")
    private String from;

    public void sendEmailNotificationCollectCreated(CollectPostResponse collect) {
        EmailData emailData = new EmailData();
        emailData.setTo(collect.getUser().getEmail());
        emailData.setSubject("Sua coleta foi agendada com sucesso");
        emailData.setBody("Olá " + collect.getUser().getUsername() +
                ", sua coleta foi agendada com sucesso para o dia " + collect.getCollectionDate());
        emailData.setFrom(from);
        sendEmail(emailData);
    }

    public void sendEmailNotificationCollectDeleted(Collect collect) {
        EmailData emailData = new EmailData();
        emailData.setTo(collect.getUser().getEmail());
        emailData.setSubject("Sua coleta foi cancelada com sucesso");
        emailData.setFrom(from);
        emailData.setBody("Olá " + collect.getUser().getUsername() + ", sua coleta marcada para o dia "
                + collect.getCollectionDate() + " foi cancelada com sucesso");
        sendEmail(emailData);
    }

    public void sendEmailNotificationCollectUpdated(Long id) {
        var collect = collectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Collect not found"));
        EmailData emailData = new EmailData();
        emailData.setTo(collect.getUser().getEmail());
        emailData.setSubject("Sua coleta foi atualizada com sucesso");
        emailData.setBody("Olá " + collect.getUser().getUsername() +
                ", sua coleta marcada para o dia " + collect.getCollectionDate()
                + " foi atualizada com sucesso para o dia ");
        emailData.setFrom(from);
        sendEmail(emailData);
    }

    public void sendEmail(EmailData email) {
        log.info("Sending email to: {}", email.getTo());
        rabbitTemplate.convertAndSend(exchange, routingKey,email);
    }

}
