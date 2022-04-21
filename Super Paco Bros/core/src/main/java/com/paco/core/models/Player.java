package com.paco.core.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import static com.paco.core.gui.elements.Assets.playerDir;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Player extends Sprite {
        
    public enum Dir {
        left, right;
    }
    
    Dir dir;
    TextureAtlas playerAtlas;
    Animation run;
    boolean flipX;
    
    public Player() {
        this.playerAtlas = new TextureAtlas(Gdx.files.internal(playerDir + "PlayerAsset.atlas"));
        this.run = new Animation(0.4f, getRunFrames());
        setRegion(new TextureRegion(playerAtlas.findRegion("1")));
        setBounds(0, 48, 64, 64);
    }
    
    public void run() {
        float i = Gdx.graphics.getDeltaTime();
        switch (dir) {
            case right:
//                setRegion((TextureRegion) run.getKeyFrame(i, true));
                setX(getX() + 4);
                break;
            case left: 
//                setRegion((TextureRegion) run.getKeyFrame(Gdx.graphics.getDeltaTime(), true));
                setX(getX() - 4);
                break;
        }
        i++;
    }
    
    public void setDir(Dir dir) {
        this.dir = dir;
        
        switch (dir) {
            case right: 
                flipX = false;
                break;
            case left:
                flipX = true;
                break;
        }
        
        setFlip(flipX, false);
    }
    
    public void dispose() {
        playerAtlas.dispose();
    }
    
    private Array<TextureRegion> getRunFrames() {
        Array<TextureRegion> Frames = new Array<>();
        Frames.add(playerAtlas.findRegion("5"), playerAtlas.findRegion("3"));
        return Frames;
    }
}
