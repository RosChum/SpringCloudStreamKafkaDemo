package rost.example;

public interface EventHandler<R extends Event, T extends Event> {

    T handle(R event);

}
