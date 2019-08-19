package com.twu.biblioteca.models;

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
        }

        if (!tables.containsKey(tableName)) {
            tables.put(tableName, new ArrayList<Model>());
        }
        tables.get(tableName).add(model);
    }

    public static void clear() {
        tables.clear();
    }

    public static ArrayList<Model> selectAllBooksWhereCheckedOutIsFalse() {
        String tableName = "BookTable";
        ArrayList<Model> allBooksWhereCheckedOutIsFalse = new ArrayList<>();
        if (tables.containsKey(tableName)) {
            for (Model model : tables.get(tableName)) {
                if (!model.isCheckedOut()) {
                    allBooksWhereCheckedOutIsFalse.add(model);
                }
            }
        }
        return allBooksWhereCheckedOutIsFalse;
    }

    public static ArrayList<Model> selectAllBooksWhereCheckedOutIsTrue() {
        String tableName = "BookTable";
        ArrayList<Model> allBooksWhereCheckedOutIsFalse = new ArrayList<>();
        if (tables.containsKey(tableName)) {
            for (Model model : tables.get(tableName)) {
                if (model.isCheckedOut()) {
                    allBooksWhereCheckedOutIsFalse.add(model);
                }
            }
        }
        return allBooksWhereCheckedOutIsFalse;
    }

    public static ArrayList<Model> selectAllMoviesWhereCheckedOutIsFalse() {
        String tableName = "MovieTable";
        ArrayList<Model> allBooksWhereCheckedOutIsFalse = new ArrayList<>();
        if (tables.containsKey(tableName)) {
            for (Model model : tables.get(tableName)) {
                if (!model.isCheckedOut()) {
                    allBooksWhereCheckedOutIsFalse.add(model);
                }
            }
        }
        return allBooksWhereCheckedOutIsFalse;
    }

    public static ArrayList<Model> selectAllMoviesWhereCheckedOutIsTrue() {
        String tableName = "MovieTable";
        ArrayList<Model> allBooksWhereCheckedOutIsFalse = new ArrayList<>();
        if (tables.containsKey(tableName)) {
            for (Model model : tables.get(tableName)) {
                if (model.isCheckedOut()) {
                    allBooksWhereCheckedOutIsFalse.add(model);
                }
            }
        }
        return allBooksWhereCheckedOutIsFalse;
    }
}
