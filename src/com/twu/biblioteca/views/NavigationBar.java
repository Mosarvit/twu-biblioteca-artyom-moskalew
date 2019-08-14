package com.twu.biblioteca.views;

import com.twu.biblioteca.IOHandler;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingDeque;

public class NavigationBar {

    private static final NavigationBar navigationBar_Singleton = new NavigationBar();
    private HashMap<String, View> menuOptionsHM = new HashMap<String, View>();

    private NavigationBar() {
        ViewAllBooksView viewAllBooksView = ViewAllBooksView.getInstance();
        QuitBibliotecaView quitBiblioteca = QuitBibliotecaView.getInstance();
        MainMenuView mainMenuView = MainMenuView.getInstance();

        this.menuOptionsHM.put("b", viewAllBooksView);
        this.menuOptionsHM.put("m", mainMenuView);
        this.menuOptionsHM.put("x", quitBiblioteca);
    }
    public void printNavigationBar(IOHandler ioHandler) {
        ioHandler.printOutput("Biblioteca Navigation:");
        ioHandler.printOutput("[m] Main Menu");
        ioHandler.printOutput("[b] All books");
        ioHandler.printOutput("[x] Quit Biblioteca");
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
