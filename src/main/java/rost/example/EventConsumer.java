package rost.example;

public interface EventConsumer <T extends Event>{
    void consumeEvent(T event);
}
