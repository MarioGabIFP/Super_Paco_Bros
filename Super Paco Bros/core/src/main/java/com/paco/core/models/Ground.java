package com.paco.core.models;

import com.badlogic.gdx.maps.MapObject;
import com.paco.core.gui.Graphics;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Ground extends ModelBase {
    public Ground(Graphics screen, MapObject obj) {super(screen, obj);}
    
    @Override
    public void initialize() {}
    
    @Override
    public void dispose() {}

    @Override
    public void update(float delta) {}
    
    @Override
    public void onCollision() {}
    
    @Override public void onCollision(Player pl) {}
    @Override public void onCollision(String val) {}
}
