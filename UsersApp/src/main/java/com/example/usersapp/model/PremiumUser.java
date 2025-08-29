package com.example.usersapp.model;

import java.util.UUID;

public class PremiumUser extends User {

    public PremiumUser(UUID id, String name, String email) {
        super(id, name, email, UserType.PREMIUM);
    }
}
