package com.twu.biblioteca.views.parts;

import com.twu.biblioteca.Session;
import com.twu.biblioteca.controllers.UserLogInController;
import com.twu.biblioteca.views.*;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class NavigationBar {

    private static final NavigationBar navigationBar_Singleton = new NavigationBar();
    private LinkedHashMap<String, View> loggedInUserMenuOptionsHM = new LinkedHashMap<String, View>();
    private LinkedHashMap<String, View> loggedOutUserMenuOptionsHM = new LinkedHashMap<String, View>();

    private NavigationBar() {
        this.loggedInUserMenuOptionsHM.put("h", MainMenuView.getInstance());
        this.loggedInUserMenuOptionsHM.put("b", BrowseBooksView.getInstance());
        this.loggedInUserMenuOptionsHM.put("rb", ReturnBooksView.getInstance());
        this.loggedInUserMenuOptionsHM.put("m", BrowseMoviesView.getInstance());
        this.loggedInUserMenuOptionsHM.put("rm", ReturnMoviesView.getInstance());
        this.loggedInUserMenuOptionsHM.put("lo", UserLogOutView.getInstance());
        this.loggedInUserMenuOptionsHM.put("x", QuitView.getInstance());

        this.loggedOutUserMenuOptionsHM.put("h", MainMenuView.getInstance());
        this.loggedOutUserMenuOptionsHM.put("b", BrowseBooksView.getInstance());
        this.loggedOutUserMenuOptionsHM.put("m", BrowseMoviesView.getInstance());
        this.loggedOutUserMenuOptionsHM.put("li", UserLogInView.getInstance());
        this.loggedOutUserMenuOptionsHM.put("x", QuitView.getInstance());
    }

    public boolean hasOption(String optionString) {
        return this.loggedInUserMenuOptionsHM.containsKey(optionString);
    }

    public static NavigationBar getInstance() {
        return navigationBar_Singleton;
    }

    public String toString() {
        String navString = "";
        navString += "Navigation Bar:  ";

        LinkedHashMap<String, View> menuOptionsHM = loggedOutUserMenuOptionsHM;
        if(Session.getUserIsLoggedIn()){
            menuOptionsHM = loggedInUserMenuOptionsHM;
        }

        for (Map.Entry<String, View> entry : menuOptionsHM.entrySet()) {
            navString += "[" + entry.getKey() + "] " + entry.getValue().getViewName() + " ";
        }

        navString += "\n";
        return navString;
    }

    public View processValidUserInput(String viewKey) {

        return this.loggedInUserMenuOptionsHM.get(viewKey);
    }
}
