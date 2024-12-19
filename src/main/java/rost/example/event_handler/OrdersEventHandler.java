package rost.example.event_handler;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import rost.example.EventHandler;
import rost.example.OrderPurchaseEvent;
import rost.example.OrderStatus;
import rost.example.PaymentEvent;

import java.util.logging.Logger;

@Component
public class OrdersEventHandler implements EventHandler<OrderPurchaseEvent, PaymentEvent> {

    Logger log = Logger.getLogger(this.getClass().getName());
    @Override
    public PaymentEvent handle(@Payload OrderPurchaseEvent event) {

        log.info("OrdersEventHandler received =====================>>>>>>> " + event);

        return new PaymentEvent(1L,2L, 100.00, OrderStatus.PAID);
    }


}
