package com.paco.core.models.elements;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.paco.core.gui.elements.Assets;
import com.paco.core.gui.elements.FX;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface ModelFunctions extends Assets, FX {
    public Array<TextureRegion> getFrames(String[] index, TextureAtlas Atlas);
    public void initialize(World w);
    public void dispose();
    public void update(float delta);
}
