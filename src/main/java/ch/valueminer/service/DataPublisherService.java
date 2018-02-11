package ch.valueminer.service;

import ch.valueminer.model.device.Device;
import ch.valueminer.model.valueminer.ValueMinerInput;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by thomas on 20.01.18.
 */
@Component
public class DataPublisherService {

    @Autowired
    private RabbitTemplate rabbit;

    public void publish(ValueMinerInput valueMinerInput) {
        rabbit.convertAndSend("", "Foobot", valueMinerInput);
    }

    public void publish(Device device) {
        rabbit.convertAndSend("", "Devices", device);
    }

}
