package com.paco.core.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.MassData;
import com.badlogic.gdx.physics.box2d.World;
import static com.paco.core.gui.elements.Assets.playerDir;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Player extends ModelBase {
    public enum Action {run, jump, stand;}
    public enum State {dead, alive;}
    
    private static Action action;
    private static State state;
    private static boolean x, jumping, running, flying;
    
    TextureAtlas playerAtlas;
    float impulseForce;
    
    public Player() {
        this.playerAtlas = new TextureAtlas(Gdx.files.internal(playerDir + "PlayerAsset.atlas"));
    }
    
    @Override
    public void initialize(World w) {
        bodyDef = new BodyDef();
        fixtureDef = new FixtureDef();
        shape = new CircleShape();
        massData = new MassData();
        impulseForce = 220f;
        action = Action.stand;
        state = State.alive;
        jumping = false;
        running = false;
        
        bodyDef.position.set(getX() + getWidth() / 2, getY() + getHeight() / 2);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        collider = w.createBody(bodyDef);
        shape.setRadius((getWidth()) / 4);
        fixtureDef.shape = shape;
        collider.createFixture(fixtureDef);
        massData.mass = 1;
        collider.setMassData(massData);
        
        setRegion(new TextureRegion(playerAtlas.findRegion("1")));
    }
    
    @Override
    public void update(float delta) {
        switch (action) {
            case run: {
                if (collider.getLinearVelocity().x != 0) collider.setLinearVelocity(new Vector2(0, 0));
                collider.applyLinearImpulse(new Vector2(x ? -impulseForce : impulseForce, -50), collider.getWorldCenter(), true);
                running = true;
                break;
            }
            case jump: {
                collider.applyLinearImpulse(new Vector2(collider.getLinearVelocity().x, impulseForce), collider.getWorldCenter(), true);
                jumping = true;
                break;
            }
            case stand: {
                setRegion(new TextureRegion(playerAtlas.findRegion(collider.getLinearVelocity().y != 0 ? "4" : "1")));
                running = false;
                break;
            }
        }
        
        switch (state) {
            case dead:
                setRegion(new TextureRegion(playerAtlas.findRegion("0")));
                break;
            case alive:
                Vector2 late = new Vector2(0, 0);
                Vector2 prev = new Vector2(0, 0);
                
                if (jumping || running) {
                    prev = collider.getLinearVelocity();
                    
                    if (flying) {setRegion(new TextureRegion(playerAtlas.findRegion(prev.y > late.y ? "2" : "4")));} else 
                    if (running) {setRegion(new TextureRegion(playerAtlas.findRegion("3")));} else 
                    if (jumping) {setRegion(new TextureRegion(playerAtlas.findRegion(prev.y > late.y ? "2" : "4")));}
                    
                    late = collider.getLinearVelocity();
                    
                    jumping = !(collider.getLinearVelocity().y == 0);
                    flying = (jumping && running);
                }
                
                break;
        }
        
        
        setFlip(x, false);
        action = Action.stand;
        setPosition(collider.getPosition().x - (getWidth() / 2), collider.getPosition().y - (getHeight()/ 2));
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

    public float getNewPos() {
        return collider.getPosition().x <= (windowW / 2) ? (windowW / 2) : collider.getPosition().x;
    }
}
