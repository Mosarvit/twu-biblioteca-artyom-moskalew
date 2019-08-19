package com.twu.biblioteca;

import com.twu.biblioteca.models.User;

public class Session {
    private static User loggedInUser;

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
}
