package com.paco.core.controller;

import com.badlogic.gdx.Game;
import com.paco.core.gui.frameable.Menu;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Initializer extends Game {
    ScreenController sc;
    
    @Override
    public void create() {
        sc = ScreenController.getInst();
        
        if (sc != null) {
            sc.initialize(this);
            sc.showScreen(new Menu());
        }
    }
}