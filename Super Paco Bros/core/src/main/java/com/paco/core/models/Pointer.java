package com.paco.core.models;

import com.badlogic.gdx.graphics.Texture;
import static com.paco.core.gui.elements.Assets.pointers;
import com.paco.core.models.Pointer.Action;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Pointer extends ModelBase {
    public enum Action {swwitch;}
    
    private static Action actualAction;
    private static boolean y;
    
    @Override
    public void initialize() {
        setRegion(new Texture(pointers + "1.png"));
    }
    
    @Override
    public void dispose() {
        getTexture().dispose();
    }

    @Override
    public void update(float delta) {
        if (actualAction != null) {
            switch (actualAction) {
                case swwitch: {
                    setY(y ? getY() + 50 : getY() - 50);
                }
            }
        }
        
        actualAction = null;
    }
    
    public void setAction(Action a, boolean ggUp) {
        actualAction = a;
        y = ggUp;
    }
}
