package service.atendimento.atendimento.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import service.atendimento.atendimento.config.RabbitMQConfig;
import service.atendimento.atendimento.events.UserCreatedEvent;
import service.atendimento.atendimento.service.AtendimentoService;
import tools.jackson.databind.ObjectMapper;

@Component
@AllArgsConstructor
@Slf4j
public class UserCreatedConsumer {

    private final AtendimentoService service;

    @RabbitListener(queues = RabbitMQConfig.USER_CREATED_QUEUE)
    public void consumer(String message) {

        log.info("Raw event received: {}", message);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            UserCreatedEvent userCreatedEvent = objectMapper.readValue(message, UserCreatedEvent.class);

            service.save(
                    userCreatedEvent.id(),
                    "USER_SERVICE"
            );
        } catch (Exception e) {
            throw new RuntimeException("Error processing UserCreatedEvent", e);
        }

    }

}
