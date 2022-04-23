package com.paco.core.models;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.paco.core.models.elements.ModelFunctions;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public abstract class ModelBase extends Sprite implements ModelFunctions{
    @Override
    public Array<TextureRegion> getFrames(String[] index, TextureAtlas Atlas) {
        Array<TextureRegion> Frames = new Array<>();
        
        for (String i : index) {
            Frames.add(Atlas.findRegion(i));
        }
        
        return Frames;
    }
}
