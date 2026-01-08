package service.atendimento.atendimento.config;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String USER_CREATED_QUEUE = "user.created.queue";

    @Bean
    public Queue userCreateQueue() {
        return QueueBuilder
                .durable(USER_CREATED_QUEUE)
                .build();
    }

}
