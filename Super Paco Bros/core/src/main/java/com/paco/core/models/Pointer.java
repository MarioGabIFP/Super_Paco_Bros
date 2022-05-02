package com.paco.core.models;

import com.badlogic.gdx.graphics.Texture;
import com.paco.core.controller.controls.types.ModelActions;
import static com.paco.core.gui.elements.Assets.pointers;

/**
 * @author Mario Gabriel N��ez Alc�zar de Velasco
 */
public class Pointer extends ModelBase {
    
    private static ModelActions.PointerAction actualAction;
    private static boolean y;
    
    public Pointer() {}
    
    @Override public void initialize() {setRegion(new Texture(pointers + "1.png"));}
    @Override public void dispose() {getTexture().dispose();}

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
    
    @Override
    public void setAction(ModelActions.PointerAction a, boolean ggUp) {
        actualAction = a;
        y = ggUp;
    }

    @Override
    public void setAction(ModelActions.PlayerAction a, boolean ggLeft) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
