package com.twu.biblioteca.views;

import com.twu.biblioteca.IOHandler;

import java.util.LinkedHashMap;
import java.util.Map;

public class NavigationBar {

    private static final NavigationBar navigationBar_Singleton = new NavigationBar();
    private LinkedHashMap<String, View> menuOptionsHM = new LinkedHashMap<String, View>();

    private NavigationBar() {
        BrowseAllBooksView browseAllBooksView = BrowseAllBooksView.getInstance();
        QuitBibliotecaView quitBiblioteca = QuitBibliotecaView.getInstance();
        MainMenuView mainMenuView = MainMenuView.getInstance();

        this.menuOptionsHM.put("m", mainMenuView);
        this.menuOptionsHM.put("b", browseAllBooksView);
        this.menuOptionsHM.put("x", quitBiblioteca);
    }
    public void printNavigationBar(IOHandler ioHandler) {
        ioHandler.printOutput("Navigation Bar:");
        for (Map.Entry<String, View> entry : this.menuOptionsHM.entrySet()) {
            ioHandler.printOutput("["+ entry.getKey() +"] "+ entry.getValue().getViewName());
        }
        ioHandler.printOutput("");
    }

    public boolean hasOption(String optionString) {
        return this.menuOptionsHM.containsKey(optionString);
    }

    public static NavigationBar getInstance(){
        NavigationBar nb = navigationBar_Singleton;
        return navigationBar_Singleton;
    }

    public View getView(String viewKey) {
        return this.menuOptionsHM.get(viewKey);
    }
}
