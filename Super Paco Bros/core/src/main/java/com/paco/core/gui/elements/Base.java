package com.paco.core.gui.elements;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.OrthographicCamera;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface Base {
    public final int windowW = 512;
    public final int windowH = 480;
    
    OrthographicCamera cam = new OrthographicCamera();
    Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
    Dimension screenBounds = Toolkit.getDefaultToolkit().getScreenSize();
}
