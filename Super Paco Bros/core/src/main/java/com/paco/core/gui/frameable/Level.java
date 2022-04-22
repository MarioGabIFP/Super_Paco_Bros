package com.paco.core.gui.frameable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.paco.core.gui.Graphics;
import com.paco.core.controller.controls.Action;
import com.paco.core.controller.controls.Charge;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Level extends Background {
    Action a = new Action();
    Charge c = new Charge();
    
    public Level() {
        super();
        music.play();
    }

    @Override
    public void buildStage() {
        Gdx.gl.glClearColor(0.435f, 0.518f, 1f, 0);
        
        for (Image image : mapArr) {
            addActor(image);
        }
        
        addSp(player);
    }

    @Override
    public void dispose() {
        atlas.dispose();
        player.dispose();
    }

    @Override
    public void listen() {
        a.pressKey(Gdx.input);
    }

    @Override
    public void initControl(Graphics screen) {
        c.initialize(screen);
    }
}
