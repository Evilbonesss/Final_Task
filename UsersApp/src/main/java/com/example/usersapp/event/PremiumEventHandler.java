package com.example.usersapp.event;

@FunctionalInterface
public interface PremiumEventHandler {

    void handle(PremiumPublisher source);
}
