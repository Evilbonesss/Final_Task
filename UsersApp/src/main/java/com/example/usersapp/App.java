package com.example.usersapp;

import com.example.usersapp.view.MainFrame;
import javax.swing.*;

/**
 * Точка входа приложения.
 */
public class App {
    /**
     * Запускает главное окно приложения.
     * Не принимает аргументов командной строки.
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
