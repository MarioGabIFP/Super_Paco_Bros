package com.paco.core.models;

import com.badlogic.gdx.maps.MapObject;
import com.paco.core.controller.controls.types.ModelActions;
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
    public void setAction(ModelActions.PlayerAction a, boolean ggLeft) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAction(ModelActions.PointerAction a, boolean ggLeft) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
