package com.paco.core.models.elements;

import com.paco.core.gui.elements.Assets;
import com.paco.core.gui.elements.FX;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface ModelFunctions extends Assets, FX {
    public void initialize();
    public void dispose();
    public void update(float delta);
    public void onCollision();
}
