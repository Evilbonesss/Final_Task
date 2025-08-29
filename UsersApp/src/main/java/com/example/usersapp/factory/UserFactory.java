package com.example.usersapp.factory;

import com.example.usersapp.model.*;
import net.datafaker.Faker;

import java.util.Locale;
import java.util.Random;
import java.util.UUID;

/**
 * Фабрика пользователей. Инкапсулирует процесс создания и наполнение полей
 * тестовыми данными.
 */
public class UserFactory {

    private final Faker faker = new Faker(new Locale("en"));
    private final Random random = new Random();

    /**
     * Создаёт одного пользователя со случайным типом и сгенерированными
     * данными.
     *
     * @return экземпляр {@link User} (RegularUser или PremiumUser)
     */
    public User createRandomUser() {
        UUID id = UUID.randomUUID();
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        boolean premium = random.nextBoolean();
        if (premium) {
            return new PremiumUser(id, name, email);
        } else {
            return new RegularUser(id, name, email);
        }

    }
}
