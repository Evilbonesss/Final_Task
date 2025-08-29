package com.example.usersapp.model;

import java.util.UUID;

public class RegularUser extends User {

    public RegularUser(UUID id, String name, String email) {
        super(id, name, email, UserType.REGULAR);
    }
}
