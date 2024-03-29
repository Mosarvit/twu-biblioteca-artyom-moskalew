package com.twu.biblioteca.views.parts;

import com.twu.biblioteca.Session;
import com.twu.biblioteca.views.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class NavigationBar {

    private static final NavigationBar navigationBar_Singleton = new NavigationBar();
    private LinkedHashMap<String, View> loggedInUserMenuOptionsHM = new LinkedHashMap<String, View>();
    private LinkedHashMap<String, View> loggedOutUserMenuOptionsHM = new LinkedHashMap<String, View>();

    private NavigationBar() {
        this.loggedInUserMenuOptionsHM.put("a", AccountInfoView.getInstance());
        this.loggedInUserMenuOptionsHM.put("b", BrowseBooksView.getInstance());
        this.loggedInUserMenuOptionsHM.put("rb", ReturnBooksView.getInstance());
        this.loggedInUserMenuOptionsHM.put("m", BrowseMoviesView.getInstance());
        this.loggedInUserMenuOptionsHM.put("rm", ReturnMoviesView.getInstance());
        this.loggedInUserMenuOptionsHM.put("lo", UserLogOutView.getInstance());
        this.loggedInUserMenuOptionsHM.put("x", QuitView.getInstance());

        this.loggedOutUserMenuOptionsHM.put("a", AccountInfoView.getInstance());
        this.loggedOutUserMenuOptionsHM.put("b", BrowseBooksView.getInstance());
        this.loggedOutUserMenuOptionsHM.put("m", BrowseMoviesView.getInstance());
        this.loggedOutUserMenuOptionsHM.put("li", UserLogInView.getInstance());
        this.loggedOutUserMenuOptionsHM.put("x", QuitView.getInstance());
    }

    public boolean hasOption(String optionString) {
        if(Session.userIsLoggedIn()){
            return this.loggedInUserMenuOptionsHM.containsKey(optionString);
        }else{
            return this.loggedOutUserMenuOptionsHM.containsKey(optionString);
        }

    }

    public static NavigationBar getInstance() {
        return navigationBar_Singleton;
    }

    public String toString() {
        String navString = "";
        navString += "Navigation Bar:" + UI_GLOBALS.LINE_BREAK;

        LinkedHashMap<String, View> menuOptionsHM = loggedOutUserMenuOptionsHM;
        if(Session.userIsLoggedIn()){
            menuOptionsHM = loggedInUserMenuOptionsHM;
        }

        for (Map.Entry<String, View> entry : menuOptionsHM.entrySet()) {
            navString += "[" + entry.getKey() + "] " + entry.getValue().getViewName() + UI_GLOBALS.LINE_BREAK;
        }
        return navString;
    }

    public View processValidUserInput(String viewKey) {
        if(Session.userIsLoggedIn()){
            return this.loggedInUserMenuOptionsHM.get(viewKey);
        }else{
            return this.loggedOutUserMenuOptionsHM.get(viewKey);
        }
    }
}
