package com.example.usersapp.view;

import com.example.usersapp.event.PremiumPublisher;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class PremiumButton extends JButton {

    private final PremiumPublisher publisher = new PremiumPublisher();

    public PremiumButton() {
        super("Показать PREMIUM");
        addActionListener(this::onClick);
    }

    private void onClick(ActionEvent e) {
        publisher.notifySubscribers();
    }

    public PremiumPublisher getPublisher() {
        return publisher;
    }
}
