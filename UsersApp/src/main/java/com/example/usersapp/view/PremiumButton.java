package com.example.usersapp.view;

import com.example.usersapp.event.PremiumPublisher;
import javax.swing.*;
import java.awt.event.ActionEvent;


/**
 * Кнопка «Показать PREMIUM», выступающая в роли издателя.
 */
public class PremiumButton extends JButton {

    private final PremiumPublisher publisher = new PremiumPublisher();

    /**
     * Создаёт кнопку и привязывает действие публикации к клику.
     */
    public PremiumButton() {
        super("Показать PREMIUM");
        addActionListener(this::onClick);
    }

    /**
     * Обработчик клика по кнопке.
     *
     * @param e событие клика
     */
    private void onClick(ActionEvent e) {
        publisher.notifySubscribers();
    }

    /**
     * Предоставляет доступ к издателю для регистрации подписчиков.
     *
     * @return издатель события
     */
    public PremiumPublisher getPublisher() {

        return publisher;
    }
}
