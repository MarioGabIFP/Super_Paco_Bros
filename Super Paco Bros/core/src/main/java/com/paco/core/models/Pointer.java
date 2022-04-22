package com.paco.core.models;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Pointer extends Actor {
    Image actualImage;
    
    public void initialize(Image Image) {
        actualImage = Image;
    }
    
    public Image getPointerImage() {return actualImage;}
    public void setPointerImage(Image actualSprite) {this.actualImage = actualSprite;}
}
