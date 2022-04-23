package com.paco.core.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.paco.core.gui.elements.Form;
import java.util.ArrayList;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public abstract class Graphics extends Stage implements Screen, Form {
    ArrayList<Sprite> sp;
    
    protected Graphics() {
        super(new StretchViewport(windowW, windowH, cam));
        
        this.sp = new ArrayList<>();
    }
    
    public abstract void buildStage();
    public abstract void listen();
    public abstract void initControl(Graphics screen);
    public abstract void update(float delta);
    
    @Override
    public void render(float delta) {
        super.act(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update(delta);
        super.draw();
        drawBatch(delta);
        listen();
    }

    public void drawBatch(float delta) {
        Batch batch = this.getBatch();
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        
        for (Sprite sprite : sp) {
            sprite.draw(this.getBatch(), 1);
        }
        
        update(delta);
        
        batch.end();
    }
    
    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }
 
    @Override
    public void resize(int width, int height) {
        getViewport().update(width, height, true);
    }
 
    @Override public void hide() {}
    @Override public void pause() {}
    @Override public void resume() {}
    
    @Override
    public Image loadImage(Texture image, float x, float y, float w, float h) {
        Image t = new Image(image);
        t.setBounds(x, y, w, h);
        
        return t;
    }
    
    @Override
    public Image loadImage(AtlasRegion image, float x, float y, float w, float h) {
        Image t = new Image(image);
        t.setBounds(x, y, w, h);
        
        return t;
    }

    public void addSp(Sprite sp) {
        this.sp.add(sp);
    }
}
