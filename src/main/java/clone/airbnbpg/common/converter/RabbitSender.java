package clone.airbnbpg.common.converter;

import clone.airbnbpg.common.config.RabbitMqConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public record RabbitSender(ObjectMapper objectMapper, RabbitTemplate rabbitTemplate) {

    public <T> void send(T dto) {
        try {
            String convertedDto = objectMapper.writeValueAsString(dto);
            rabbitTemplate.convertAndSend(RabbitMqConfig.topicExchangeName, "airbnb.clone.foo", convertedDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
