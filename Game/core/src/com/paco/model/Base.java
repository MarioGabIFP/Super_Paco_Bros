package com.paco.model;

import com.badlogic.gdx.ApplicationAdapter;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Base extends ApplicationAdapter implements Elements{
	
	/*
	 * Creamos la escena que va actuar.
	 */
	@Override
	public void create() {
		/*
		 * Cargamos el menú del juego
		 */
		Menu menu = new Menu();
		menu.create();
	}
}
