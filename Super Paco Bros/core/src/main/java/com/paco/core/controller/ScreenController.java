package com.paco.core.controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.paco.core.gui.Graphics;
import com.paco.core.gui.elements.Base;
import java.util.ArrayList;

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
