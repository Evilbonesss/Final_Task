package com.example.usersapp.factory;

import com.example.usersapp.model.*;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

public class UserFactory {

    private final Faker faker = new Faker(new Locale("en"));
    private final Random random = new Random();

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

    /**
     * Создаёт список пользователей указанного размера. Основной метод фабрики
     * для базовой части приложения.
     *
     * @param count требуемое количество пользователей (>= 0)
     * @return список пользователей
     * @throws IllegalArgumentException если count отрицателен
     */
    public List<User> createUsers(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("count must be >= 0");
        }
        List<User> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            result.add(createRandomUser());
        }
        return result;
    }
}
