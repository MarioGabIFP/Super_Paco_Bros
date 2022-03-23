package com.paco.view;

import com.paco.controller.Behavior;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Screen extends Behavior {
	/**
	 * Constructor del Screen
	 */
	public Screen() {
		//Llamamos al padre
		super();
	}

	/**
	 * Renderiza la Vista Screen
	 */
	@Override
	public void render () {
		// Renderizamos el padre Base a través de ApplicationAdapter
		super.render();
		
		// Inicializamos la escena
		stage.act();
		
		// Dibujamos la escena
		stage.draw();
		
		//Ralizamos las llamadas al controlador
		addListeners();
	}
	
	/**
	 * cuando la vista deje de existir, limpia todos los elementos visibles y cierra
	 */
	@Override
	public void dispose () {
		// limpiamos todos los elementos del padre Base.
		super.dispose();
		
		//Lismpiamos todos los elementos de la escena
		stage.dispose();
	}
}
