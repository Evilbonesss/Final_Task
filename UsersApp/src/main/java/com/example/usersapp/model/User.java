package com.example.usersapp.model;

import java.util.UUID;

/**
 * Базовый пользователь. Поля: id — уникальный идентификатор (UUID); name — имя
 * пользователя; email — адрес электронной почты; userType — тип пользователя
 * (REGULAR или PREMIUM).
 *
 */
public abstract class User {

    protected final UUID id;
    protected final String name;
    protected final String email;
    protected final UserType userType;

    public User(UUID id, String name, String email, UserType userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userType = userType;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UserType getUserType() {
        return userType;
    }

    public String formatForOutput() {
        return "(" + name + "] | {" + email + "}";
    }
}
