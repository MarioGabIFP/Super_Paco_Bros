package com.paco.core.models;

import com.badlogic.gdx.graphics.Texture;
import com.paco.core.controller.controls.types.ModelActions;
import static com.paco.core.gui.elements.Assets.pointers;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Pointer extends ModelBase {
    
    private static ModelActions.PointerAction actualAction;
    private static boolean y;
    
    public Pointer() {}
    
    @Override public void onCollision() {}
    @Override public void onCollision(Player pl) {}
    @Override public void onCollision(String val) {}
    
    @Override public void dispose() {getTexture().dispose();}
    
    @Override 
    public void initialize() {
        actor = Actors.pointer;
        setRegion(new Texture(pointers + "1.png"));
    }
    
    @Override
    public void setAction(ModelActions.PointerAction a, boolean ggUp) {
        actualAction = a;
        y = ggUp;
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
}
