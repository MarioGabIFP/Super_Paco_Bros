package com.paco.core.gui.frameable;

import com.badlogic.gdx.Gdx;
import com.paco.core.gui.Graphics;
import com.paco.core.controller.controls.Action;
import com.paco.core.controller.controls.Charge;
import com.paco.core.models.elements.LevelModel;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Level extends Map implements LevelModel{
    Action a = new Action();
    Charge c = new Charge();
    
    public Level() {
        super();
        createWorldCollaiders();
        music.play();
        player.setBounds(0, 32, 64, 64);
        player.initialize(world);
    }

    @Override
    public void buildStage() {
        addSp(player);
    }
    
    @Override
    public void update(float delta) {
        cam.position.x = player.getNewPos();
        cam.update();
        player.update(delta);
        renderer.setView(cam);
    }

    @Override
    public void dispose() {
        player.dispose();
        music.dispose();
        super.dispose();
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
