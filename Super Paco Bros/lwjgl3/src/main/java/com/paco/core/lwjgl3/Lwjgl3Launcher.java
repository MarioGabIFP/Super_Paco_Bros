package com.paco.core.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.paco.core.controller.Initializer;
import com.paco.core.gui.elements.Base;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Lwjgl3Launcher implements Base {
    public static void main(String[] args) {   
        configuration.setTitle("Super Paco Bros");
        configuration.useVsync(true);
        configuration.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate);
        configuration.setWindowedMode(windowW, windowH);
        
        new Lwjgl3Application(new Initializer(), configuration);
    }
}
