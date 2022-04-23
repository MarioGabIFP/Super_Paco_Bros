package com.paco.core.gui.frameable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.paco.core.gui.Graphics;
import com.paco.core.controller.controls.Action;
import com.paco.core.controller.controls.Charge;
import com.paco.core.models.elements.LevelModel;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Level extends Background implements LevelModel{
    Action a = new Action();
    Charge c = new Charge();
    
    public Level() {
        super();
        
        music.play();
        player.setBounds(0, 48, 64, 64);
        player.initialize();
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
    public void update(float delta) {
        player.update(delta);
    }

    @Override
    public void dispose() {
        player.dispose();
        atlas.dispose();
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
