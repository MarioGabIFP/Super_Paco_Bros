package com.paco.core.gui.elements;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface Base {
    final int windowW = 512;
    final int windowH = 416;
    
    OrthographicCamera cam = new OrthographicCamera();
    Viewport viewPort = new ScalingViewport(Scaling.fit, windowW, windowH, cam);
    TmxMapLoader mapLoader = new TmxMapLoader();
    Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
    Dimension screenBounds = Toolkit.getDefaultToolkit().getScreenSize();
}
