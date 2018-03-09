package com.nivtech.observeasy;

import com.nivtech.observeasy.views.Menu;
import com.nivtech.observeasy.views.TabbedPanes;
import com.nivtech.observeasy.views.Window;

public class Main
{
    public static void main(String[] args)
    {
        Window window = new Window();
        window.setJMenuBar(new Menu());
        window.add(new TabbedPanes());
        window.setSize(1000,800);
    }
}
