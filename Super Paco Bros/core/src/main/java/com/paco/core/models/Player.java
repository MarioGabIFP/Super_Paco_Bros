package com.paco.core.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import static com.paco.core.gui.elements.Assets.playerDir;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Player extends ModelBase {
    public enum Action {run, jump, stand, bend, fall, grow;}
    public enum State {big, small, dead, alive;}
    
    private static Action action;
    private static State state;
    private static boolean x;
    
    TextureAtlas playerAtlas;
    Animation run;
    float speed;
    
    public Player() {
        this.playerAtlas = new TextureAtlas(Gdx.files.internal(playerDir + "PlayerAsset.atlas"));
        this.run = new Animation(0.4f, getFrames(new String[]{"5","4","3"}, playerAtlas));
    }
    
    @Override
    public void initialize() {
        speed = 0.1f;
        action = Action.stand;
        state = State.alive;
        
        setRegion(new TextureRegion(playerAtlas.findRegion("1")));
    }
    
    @Override
    public void update(float delta) {
        switch (action) {
            case run: {
                setRegion((TextureRegion) run.getKeyFrame(delta, true));
                break;
            }
            case jump: {
                setRegion(new TextureRegion(playerAtlas.findRegion("2")));
                break;
            }
            case bend: {
                System.out.println("agacha");
                break;
            }
            case stand: {
                setRegion(new TextureRegion(playerAtlas.findRegion("1")));
                break;
            }
            case fall: {
                setRegion(new TextureRegion(playerAtlas.findRegion("3")));
                break;
            }
            case grow: {
                System.out.println("creciendo");
                break;
            }
        }
        
        switch (state) {
            case big:
                System.out.println("grande");
                break;
            case small:
                System.out.println("pequeño");
                break;
            case dead:
                setRegion(new TextureRegion(playerAtlas.findRegion("0")));
                break;
            case alive:
                System.out.println("vivo");
                break;
        }

        setFlip(x, false);
        action = Action.stand;
    }
    
    @Override
    public void dispose() {
        getTexture().dispose();
        playerAtlas.dispose();
    }
    
    public void setAction(Action a, boolean ggLeft) {
        action = a;
        x = ggLeft;
    }
    
    public void setState(State s, boolean ggLeft) {
        state = s;
        x = ggLeft;
    }
}
