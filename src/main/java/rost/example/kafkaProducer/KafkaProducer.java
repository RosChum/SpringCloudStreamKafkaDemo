package rost.example.kafkaProducer;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import rost.example.OrderPurchaseEvent;
import rost.example.OrderStatus;

import java.util.logging.Logger;

@Component
@EnableScheduling
public class KafkaProducer {

    Logger log = Logger.getLogger(this.getClass().getName());
    public static int counter = 0;

//    @Autowired
//    private StreamBridge streamBridge;


    @Scheduled(cron = "*/2 * * * * *")
    public OrderPurchaseEvent sendMessage() {

        OrderPurchaseEvent orderPurchaseEvent = new OrderPurchaseEvent((long) ++counter, 2L, 100.00, OrderStatus.REGISTERED);

        log.info("Sending message: {}" + orderPurchaseEvent);

//        streamBridge.send("ordersProducer-out-0", orderPurchaseEvent);
        return orderPurchaseEvent;
    }
}
