package com.paco.core.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapObject;
import com.paco.core.gui.Graphics;

/**
 * @author Brad Lopez
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Beer extends ModelBase {
    public Beer(Graphics screen, MapObject obj) {super(screen, obj);}
    
    @Override public void initialize() {}
    @Override public void dispose() {}
    @Override public void update(float delta) {}
    @Override public void onCollision() {}
    @Override public void onCollision(String val) {}

    @Override 
    public void onCollision(Player pl) {
        pl.drinkBeer();
        Gdx.app.log("Paco", "Glup");
    }
}
