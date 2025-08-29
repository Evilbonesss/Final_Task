package com.example.usersapp.model;

import java.util.UUID;

/**
 * Конкретный пользователь типа PREMIUM. Подписывается на событие «Показать
 * PREMIUM».
 */
public class PremiumUser extends User {

    /**
     * Создаёт PREMIUM-пользователя.
     *
     * @param id уникальный идентификатор
     * @param name имя
     * @param email e-mail
     */
    public PremiumUser(UUID id, String name, String email) {
        super(id, name, email, UserType.PREMIUM);
    }
}
