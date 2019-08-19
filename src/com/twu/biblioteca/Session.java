package com.twu.biblioteca;

import com.twu.biblioteca.models.User;

public class Session {
    private static User loggedInUser;
    private static final User admin = new User("111-1111", "adminPassword");

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static boolean getUserIsLoggedIn() {
        return loggedInUser != null;
    }

    public static void setLoggedInUser(User user) {
        loggedInUser = user;
    }

    public static void clear() {
        loggedInUser = null;
    }

    public static boolean currenUserIsAdmin() {
        return loggedInUser.getUserName().equals(admin.getUserName());
    }
}
