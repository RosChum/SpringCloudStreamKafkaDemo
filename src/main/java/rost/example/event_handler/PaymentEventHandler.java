package rost.example.event_handler;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import rost.example.EventConsumer;
import rost.example.PaymentEvent;

import java.util.logging.Logger;

@Component
public class PaymentEventHandler implements EventConsumer<PaymentEvent> {

    Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public void consumeEvent(@Payload PaymentEvent event) {
        log.info("PaymentEventHandler ===========>: " + event);

    }
}
