package com.example.usersapp.model;

import java.util.UUID;

/**
 * Кнкретный пользователь типа REGULAR.
 */
public class RegularUser extends User {

    /**
     * КЛасс создаёт REGULAR-пользователя.
     *
     * @param id уникальный идентификатор
     * @param name имя
     * @param email почта
     */
    public RegularUser(UUID id, String name, String email) {
        super(id, name, email, UserType.REGULAR);
    }
}
