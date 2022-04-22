package com.paco.core.controller;

import com.badlogic.gdx.Game;
import com.paco.core.gui.frameable.MenuPrincipal;

/**
 * @author Mario Gabriel N��ez Alc�zar de Velasco
 */
public class Initializer extends Game {
    @Override
    public void create() {
        ScreenController.getInst().initialize(this);
        ScreenController.getInst().showScreen(new MenuPrincipal());
    }
}