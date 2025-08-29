package com.example.usersapp.view;

import com.example.usersapp.event.PremiumPublisher;
import com.example.usersapp.factory.UserFactory;
import com.example.usersapp.model.User;
import com.example.usersapp.model.UserType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Главное окно приложения.
 */
public class MainFrame extends JFrame {

    private final JButton createButton = new JButton("Создать пользователей");
    private final PremiumButton showPremiumButton = new PremiumButton();
    private final JTextArea output = new JTextArea(10, 40);

    private final List<User> lastCreated = new ArrayList<>(); // - хпранение последней пятерки
    private final UserFactory factory = new UserFactory(); // - генерация случайных пользователей

    /**
     * Создаёт и настраивает главное окно.
     */
    public MainFrame() {
        setTitle("UsersApp — Factory + Publisher/Subscriber + Lambdas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.add(createButton);
        top.add(showPremiumButton);
        add(top, BorderLayout.NORTH);

        output.setEditable(false);
        add(new JScrollPane(output), BorderLayout.CENTER);

        createButton.addActionListener(e -> onCreateUsers());
    }

    /**
     * Создаёт 5 пользователей через фабрику и подписывает PREMIUM-пользователей
     * на событие «Показать PREMIUM» с использованием лямбда-выражений.
     */
    private void onCreateUsers() {
        output.append("— Создаём 5 пользователей…\n");
        lastCreated.clear();

        PremiumPublisher publisher = showPremiumButton.getPublisher();

        for (int i = 0; i < 5; i++) {
            User u = factory.createRandomUser();
            lastCreated.add(u);

            output.append("  • " + u.getUserType() + " — " + u.getName() + " (" + u.getEmail() + ")\n");

            if (u.getUserType() == UserType.PREMIUM) {
                publisher.subscribe(src -> output.append(u.formatForOutput() + "\n"));
            }
        }
        output.append("Готово. Нажми «Показать PREMIUM», чтобы вывести премиум-пользователей.\n\n");
    }
}
