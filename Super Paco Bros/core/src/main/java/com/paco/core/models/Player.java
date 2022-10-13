package com.paco.core.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.paco.core.controller.controls.types.ModelActions;
import com.paco.core.gui.Graphics;
import static com.paco.core.gui.elements.Assets.playerDir;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 * @author Brad Lopez
 */
public class Player extends ModelBase {
    public enum State {dead, alive;}
    
    private ModelActions.PlayerAction action;
    private State state;
    private boolean x, jumping, running, flying, dead;

    private float impulseForce, deadTime, time;
    private int beersAmount;
    
    public final TextureAtlas playerAtlas = new TextureAtlas(Gdx.files.internal(playerDir + "PlayerAsset.atlas"));

    public Player(Graphics screen) {super(screen);}
    
    public final void setDeadTime(float time) {this.time = time;}
    public final void drinkBeer() {beersAmount++; Gdx.app.log("Paco", "Glup");}
    public final float getNewPos() {return collider.getPosition().x <= (windowW / 2) ? (windowW / 2) : collider.getPosition().x;}
    public final float getDeadTime() {return deadTime;}
    public final boolean isDead() {return dead;}
    
    @Override public void onCollision() {}
    @Override public void onCollision(Player pl) {}
    @Override public void onCollision(String val) {}
    
    @Override public void setAction(ModelActions.PlayerAction a, boolean ggLeft) {if (!isDead()) action = a; x = ggLeft;}
    
    @Override
    public void initialize() {
        impulseForce = 220f;
        action = ModelActions.PlayerAction.stand;
        state = State.alive;
        actor = Actors.player;
        jumping = false;
        running = false;
        
        setCharacter(true);
        initModel();
        getBaldFixture().setUserData("fist");
        getBodyFixture().setUserData(this);
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
                jump.play();
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
                music.stop();
                lose.play();
                setRegion(new TextureRegion(playerAtlas.findRegion("0")));
                dead = true;
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
                
                setFlip(x, false);
                action = ModelActions.PlayerAction.stand;
                setPosition(collider.getPosition().x - (getWidth() / 2), collider.getPosition().y - ((getHeight()/ 2) - 2));
                
                break;
        }
    }
    
    @Override
    public void dispose() {
        getTexture().dispose();
        playerAtlas.dispose();
    }
    
    public final void kill() {
        state = State.dead;
        deadTime = time;
    }
}
