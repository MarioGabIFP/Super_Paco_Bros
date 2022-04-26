package com.paco.core.models;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.MassData;
import com.badlogic.gdx.utils.Array;
import com.paco.core.models.elements.ModelFunctions;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public abstract class ModelBase extends Sprite implements ModelFunctions{
    BodyDef bodyDef;
    Body collider;
    FixtureDef fixtureDef;
    CircleShape shape;
    MassData massData;
    
    @Override
    public Array<TextureRegion> getFrames(String[] index, TextureAtlas Atlas) {
        Array<TextureRegion> Frames = new Array<>();
        
        for (String i : index) {
            Frames.add(Atlas.findRegion(i));
        }
        
        return Frames;
    }
}
