package com.paco.core.models;

import com.badlogic.gdx.maps.MapObject;
import com.paco.core.gui.Graphics;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Brick extends ModelBase {
    private boolean gift = false, 
                    destroyable = false;
    
    public Brick(Graphics screen, MapObject obj) {
        super(screen, obj);
        gift = (boolean) obj.getProperties().get("gift");
        destroyable = (boolean) obj.getProperties().get("destroyable");
    }
    
    @Override public void initialize() {}
    @Override public void dispose() {}
    @Override public void update(float delta) {}
    @Override public void onCollision() {}    
    @Override public void onCollision(Player pl) {}
    @Override public void onCollision(String val) {if (destroyable && "fist".equals(val)) destroy(this, 3);}
}
