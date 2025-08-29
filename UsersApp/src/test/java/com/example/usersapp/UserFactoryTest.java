package com.example.usersapp;

import com.example.usersapp.factory.UserFactory;
import com.example.usersapp.model.User;
import com.example.usersapp.model.UserType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserFactoryTest {

    @Test
    @DisplayName("createRandomUser: фабрика возвращает не-null и заполненные поля")
    void createRandomUser_returnsValidUser() {
        UserFactory f = new UserFactory();
        User u = f.createRandomUser();
        assertNotNull(u, "Фабрика должна вернуть объект");
        assertNotNull(u.getId(), "id должен быть задан");
        assertNotNull(u.getName(), "name должен быть задан");
        assertNotNull(u.getEmail(), "email должен быть задан");
        assertNotNull(u.getUserType(), "userType должен быть задан");
    }

    @RepeatedTest(5)
    @DisplayName("createRandomUser: тип пользователя допустим (REGULAR или PREMIUM)")
    void createRandomUser_hasValidUserType() {
        UserFactory f = new UserFactory();
        User u = f.createRandomUser();
        assertTrue(u.getUserType() == UserType.REGULAR || u.getUserType() == UserType.PREMIUM,
                "userType должен быть REGULAR или PREMIUM");
    }

    @Test
    @DisplayName("createUsers: возвращает список заданного размера")
    void createUsers_returnsListOfGivenSize() {
        UserFactory f = new UserFactory();
        int n = 5;
        List<User> users = f.createUsers(n);
        assertEquals(n, users.size(), "Размер списка должен совпадать с параметром");
        assertTrue(users.stream().allMatch(u -> u != null), "Все элементы списка должны быть не-null");
    }
}
