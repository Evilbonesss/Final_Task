package com.example.usersapp.event;

import java.util.ArrayList;
import java.util.List;

/**
 * Издатель события «Показать PREMIUM».
 */
public class PremiumPublisher {

    private final List<PremiumEventHandler> handlers = new ArrayList<>();

    /**
     * Регистрирует обработчик события.
     * @param handler обработчик (обычно лямбда)
     */
    public void subscribe(PremiumEventHandler handler) {
        handlers.add(handler);
    }

    /**
     * Уведомляет всех подписчиков и очищает список подписок.
     * Повторные клики не повторяют вывод предыдущих подписчиков.
     */
    public void notifySubscribers() {
        List<PremiumEventHandler> snapshot = new ArrayList<>(handlers);
        for (PremiumEventHandler h : snapshot) {
            h.handle(this);
        }
        handlers.clear();
    }

    /**
     * Возвращает текущее число подписчиков (диагностика/обучение).
     * @return количество подписчиков
     */
    public int getSubscriberCount() {
        return handlers.size();
    }
}
