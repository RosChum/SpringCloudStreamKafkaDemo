package rost.example.configurationStreamCloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rost.example.EventConsumer;
import rost.example.EventHandler;
import rost.example.OrderPurchaseEvent;
import rost.example.PaymentEvent;
import rost.example.kafkaProducer.KafkaProducer;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Logger;

@Configuration
public class StreamCloudConfig {

    Logger logger = Logger.getLogger(StreamCloudConfig.class.getName());

    @Autowired
    EventConsumer<PaymentEvent> paymentEventHandlerEventConsumer;

    @Autowired
    EventHandler<OrderPurchaseEvent, PaymentEvent> paymentEventHandler;

    @Autowired
    private KafkaProducer kafkaProducer;


    @Bean
    public Consumer<PaymentEvent> paymentEventConsumer() {
//        logger.log(Level.INFO, "ordersConsumer");
//        return ordersEventHandler -> logger.log(Level.INFO, "ordersConsumer" + ordersEventHandler.toString());
        return paymentEventHandlerEventConsumer::consumeEvent;
    }

    @Bean
    public Supplier<OrderPurchaseEvent> ordersProducer() {
        return () -> kafkaProducer.sendMessage();
    }

    @Bean
    public Function<OrderPurchaseEvent, PaymentEvent> ordersProcessor() {
        return paymentEventHandler::handle;

    }


}
