package com.paco.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.paco.view.Screen;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class DesktopLauncher {
	public static void main (String[] arg) {
		
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
		config.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate);
		config.setForegroundFPS(60);
		new Lwjgl3Application(new Screen(), config);
	}
}