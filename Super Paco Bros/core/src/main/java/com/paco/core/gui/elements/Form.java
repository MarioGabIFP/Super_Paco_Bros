package com.paco.core.gui.elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface Form extends Assets, FX{
    public Image loadImage(Texture image, float x, float y, float w, float h);
    public Image loadImage(AtlasRegion image, float x, float y, float w, float h);
}
