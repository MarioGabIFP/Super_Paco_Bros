package com.paco.model;

import com.badlogic.gdx.ApplicationAdapter;

/**
 * @author Mario Gabriel N��ez Alc�zar de Velasco
 */
public class Base extends ApplicationAdapter implements Elements{
	
	/*
	 * Creamos la escena que va actuar.
	 */
	@Override
	public void create() {
		/*
		 * Cargamos el men� del juego
		 */
		Menu menu = new Menu();
		menu.create();
	}
}
