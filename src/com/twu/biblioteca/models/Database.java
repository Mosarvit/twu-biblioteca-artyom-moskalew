package com.twu.biblioteca.models;

import com.twu.biblioteca.Session;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private static final HashMap<String, ArrayList<Model>> tables = new HashMap<>();

    public static void add(Model model) {

        String tableName = "BookTable";

        if (model.getClass() == Book.class){
            tableName = "BookTable";
        }else if(model.getClass() == Movie.class){
            tableName = "MovieTable";
        }else if(model.getClass() == User.class){
            tableName = "UserTable";
        }

        if (!tables.containsKey(tableName)) {
            tables.put(tableName, new ArrayList<Model>());
        }
        tables.get(tableName).add(model);
    }

    public static void clear() {
        tables.clear();
    }

    public static ArrayList<Media> selectAllBooksWhereCheckedOutIsFalse() {
        String tableName = "BookTable";
        ArrayList<Media> allBooksWhereCheckedOutIsFalse = new ArrayList<>();
        if (tables.containsKey(tableName)) {
            for (Model model : tables.get(tableName)) {
                Media media = ((Media)model);
                if (!media.isCheckedOut()) {
                    allBooksWhereCheckedOutIsFalse.add(media);
                }
            }
        }
        return allBooksWhereCheckedOutIsFalse;
    }

    public static ArrayList<Media> selectAllBooksWhereCheckedOutIsTrue() {
        String tableName = "BookTable";
        ArrayList<Media> allBooksWhereCheckedOutIsFalse = new ArrayList<>();
        if (tables.containsKey(tableName)) {
            for (Model model : tables.get(tableName)) {
                Media media = ((Media)model);
                if (media.isCheckedOut()) {
                    allBooksWhereCheckedOutIsFalse.add(media);
                }
            }
        }
        return allBooksWhereCheckedOutIsFalse;
    }

    public static ArrayList<Media> selectAllMoviesWhereCheckedOutIsFalse() {
        String tableName = "MovieTable";
        ArrayList<Media> allBooksWhereCheckedOutIsFalse = new ArrayList<>();
        if (tables.containsKey(tableName)) {
            for (Model model : tables.get(tableName)) {
                Media media = ((Media)model);
                if (!media.isCheckedOut()) {
                    allBooksWhereCheckedOutIsFalse.add(media);
                }
            }
        }
        return allBooksWhereCheckedOutIsFalse;
    }

    public static ArrayList<Media> selectAllMoviesWhereCheckedOutIsTrue() {
        String tableName = "MovieTable";
        ArrayList<Media> allBooksWhereCheckedOutIsFalse = new ArrayList<>();
        if (tables.containsKey(tableName)) {
            for (Model model : tables.get(tableName)) {
                Media media = ((Media)model);
                if (media.isCheckedOut()) {
                    allBooksWhereCheckedOutIsFalse.add(media);
                }
            }
        }
        return allBooksWhereCheckedOutIsFalse;
    }

    public static User selectUserWhereUsernameEquals(String userName) {
        String tableName = "UserTable";
        if (!tables.containsKey(tableName)) {
            return null;
        }
        for (Model model : tables.get(tableName)) {
            User user = ((User)model);
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }


    public static ArrayList<Media> selectAllCheckedOutMoviesVisibleToCurrentUser() {
        String tableName = "MovieTable";
        ArrayList<Media> allBooksWhereCheckedOutIsFalse = new ArrayList<>();
        if (tables.containsKey(tableName)) {
            for (Model model : tables.get(tableName)) {
                Media media = ((Media)model);
                if (media.holder == Session.getLoggedInUser()) {
                    allBooksWhereCheckedOutIsFalse.add(media);
                }
            }
        }
        return allBooksWhereCheckedOutIsFalse;
    }

    public static ArrayList<Media> selectAllCheckedOutBooksVisibleToCurrentUser() {
        String tableName = "BookTable";
        ArrayList<Media> allBooksWhereCheckedOutIsFalse = new ArrayList<>();
        if (tables.containsKey(tableName)) {
            for (Model model : tables.get(tableName)) {
                Media media = ((Media)model);
                if (media.holder == Session.getLoggedInUser()) {
                    allBooksWhereCheckedOutIsFalse.add(media);
                }
            }
        }
        return allBooksWhereCheckedOutIsFalse;
    }
}
