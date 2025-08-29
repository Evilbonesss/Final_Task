package com.example.usersapp.model;

import java.util.UUID;

/**
 * Базовый абстрактный пользователь. Содержит идентификатор, имя, e-mail и тип
 * пользователя.
 */
public abstract class User {

    protected final UUID id;

    protected final String name;

    protected final String email;

    protected final UserType userType;

    /**
     * Конструктор базового пользователя.
     *
     * @param id уникальный идентификатор
     * @param name имя
     * @param email e-mail
     * @param userType тип пользователя
     */
    protected User(UUID id, String name, String email, UserType userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userType = userType;
    }

    /**
     * @return уникальный идентификатор пользователя
     */
    public UUID getId() {
        return id;
    }

    /**
     * @return имя пользователя
     */
    public String getName() {
        return name;
    }

    /**
     * @return e-mail пользователя
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return тип пользователя
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Форматирует пользователя для вывода в интерфейсе.
     *
     * @return строка вида "(name] | {email}"
     */
    public String formatForOutput() {
        return "(" + name + "] | {" + email + "}";
    }
}
