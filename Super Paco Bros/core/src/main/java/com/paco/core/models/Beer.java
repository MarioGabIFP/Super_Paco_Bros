package com.paco.core.models;

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
        if (getCell(3, (int) getObjFixture().getBody().getPosition().x / 16, (int) getObjFixture().getBody().getPosition().y / 16) == null) {
            destroy(this, 2);
            drink.play();
            pl.drinkBeer();
        }
    }
}
