package com.twu.biblioteca.views.parts;

import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.views.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class NavigationBar {

    private static final NavigationBar navigationBar_Singleton = new NavigationBar();
    private LinkedHashMap<String, View> menuOptionsHM = new LinkedHashMap<String, View>();

    private NavigationBar() {
        this.menuOptionsHM.put("m", MainMenuView.getInstance());
        this.menuOptionsHM.put("l", BrowseView.getInstance());
        this.menuOptionsHM.put("r", ReturnView.getInstance());
        this.menuOptionsHM.put("x", QuitView.getInstance());
    }

    public boolean hasOption(String optionString) {
        return this.menuOptionsHM.containsKey(optionString);
    }

    public static NavigationBar getInstance(){
        NavigationBar nb = navigationBar_Singleton;
        return navigationBar_Singleton;
    }

    public String toString(){
        String navString = "";
        navString += "Navigation Bar:  ";
        for (Map.Entry<String, View> entry : this.menuOptionsHM.entrySet()) {
            navString += "["+ entry.getKey() +"] "+ entry.getValue().getViewName() + "  ";
        }
        navString += "\n";
        return navString;
    }

    public View processValidUserInput(String viewKey) {
        return this.menuOptionsHM.get(viewKey);
    }
}
