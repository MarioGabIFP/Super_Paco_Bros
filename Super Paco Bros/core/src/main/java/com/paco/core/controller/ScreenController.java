package com.paco.core.controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.paco.core.gui.Graphics;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class ScreenController {

    private static ScreenController inst;
    private Game game;

    private ScreenController() {super();}

    public static ScreenController getInst() {
        if (inst == null) inst = new ScreenController();
        return inst;
    }

    public void initialize(Game game) {this.game = game;}

    public void showScreen(Graphics screen) {
        Screen currentScreen = game.getScreen();

        screen.buildStage();
        screen.initControl(screen);
        game.setScreen(screen);

        if (currentScreen != null) currentScreen.dispose();
    }
}
