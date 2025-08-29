package com.example.usersapp.event;

/**
 * Обработчик события «Показать PREMIUM». 
 * Функциональный интерфейс (один абстрактный метод).
 */
@FunctionalInterface
public interface PremiumEventHandler {
    /**
     * Вызывается при наступлении события публикации.
     * @param source издатель события
     */
    void handle(PremiumPublisher source);
}
