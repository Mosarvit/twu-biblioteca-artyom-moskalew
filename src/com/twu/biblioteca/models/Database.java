package com.twu.biblioteca.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private static final HashMap<String, ArrayList<Media>> tables = new HashMap<>();

    public static void add(Media media) {

        String tableName = "BookTable";

        if (media.getClass() == Book.class){
            tableName = "BookTable";
        }else if(media.getClass() == Movie.class){
            tableName = "MovieTable";
        }

        if (!tables.containsKey(tableName)) {
            tables.put(tableName, new ArrayList<Media>());
        }
        tables.get(tableName).add(media);
    }

    public static void clear() {
        tables.clear();
    }

    public static ArrayList<Media> selectAllBooksWhereCheckedOutIsFalse() {
        String tableName = "BookTable";
        ArrayList<Media> allBooksWhereCheckedOutIsFalse = new ArrayList<>();
        if (tables.containsKey(tableName)) {
            for (Media media : tables.get(tableName)) {
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
            for (Media media : tables.get(tableName)) {
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
            for (Media media : tables.get(tableName)) {
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
            for (Media media : tables.get(tableName)) {
                if (media.isCheckedOut()) {
                    allBooksWhereCheckedOutIsFalse.add(media);
                }
            }
        }
        return allBooksWhereCheckedOutIsFalse;
    }
}
