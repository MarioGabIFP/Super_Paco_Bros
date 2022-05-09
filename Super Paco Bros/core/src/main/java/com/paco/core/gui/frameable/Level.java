package com.paco.core.gui.frameable;

import com.badlogic.gdx.Gdx;
import com.paco.core.controller.controls.Action;
import com.paco.core.gui.Graphics;
import com.paco.core.models.Player;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Level extends Map{
    Player paco = new Player(super.getMe());
    
    public Level() {
        super();
        music.play();
        paco.setBounds(0, 32, 64, 64);
        paco.initialize();
    }

    @Override public void buildStage() {addSp(paco);}
    @Override public void listen() {((Action) a).pressKey(Gdx.input, paco);}
    @Override public void initControl(Graphics screen) {c.initialize(screen);}
    
    @Override
    public void update(float delta) {
        if (!paco.isDead()) {
            cam.position.x = paco.getNewPos();
            cam.update();
            paco.update(delta);
            renderer.setView(cam);
        }
    }

    @Override
    public void dispose() {
        paco.dispose();
        music.dispose();
        super.dispose();
    }
}
