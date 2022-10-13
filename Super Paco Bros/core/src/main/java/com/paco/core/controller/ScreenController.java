package com.paco.core.controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.paco.core.gui.Graphics;
import com.paco.core.gui.elements.Base;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class ScreenController implements Base {
    private static ScreenController inst;
    private static Game game;

    private ScreenController() {super();}

    public static ScreenController getInst() {
        if (inst == null) inst = new ScreenController();
        return inst;
    }

    public void initialize(Game currentGame) {game = currentGame;}

    public void showScreen(Graphics graphics) {
        Screen currentScreen = game.getScreen();
        
        graphics.buildStage();
        graphics.initControl(graphics);
        game.setScreen(graphics);

        if (currentScreen != null) currentScreen.dispose();
    }
}
