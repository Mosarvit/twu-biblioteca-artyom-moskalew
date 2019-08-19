package com.twu.biblioteca.controllers;

import com.twu.biblioteca.views.View;

public abstract class Controller {
    protected String viewHeader;
    protected View nextView;

    public String getViewHeader(){
        return this.viewHeader;
    }

    public View getNextView(){
        return this.nextView;
    }
}
