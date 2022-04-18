package com.paco.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.paco.model.Base;
import com.paco.model.MenuElements;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Behavior extends Base implements Events{
	public void addListeners() {

		/*******************************************************************************
		 * Listener del Menú
		 *******************************************************************************/
		MenuElements.button.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				System.out.println("boton pulsado");
				
			}
			
		});
		
	}
	
	/*******************************************************************************
	 * Eventos del Menú
	 *******************************************************************************/
	
	/**
	 * Iniciamos el Juego
	 */
	@Override
	public void play() {
		System.out.println("Empezar Juego");
	}


	/**
	 * Ranking de puntos
	 */
	@Override
	public void Ranking() {
		System.out.println("pantalla Ranking");
	}

	/*
	 * Cerrar el Juego
	 */
	@Override
	public void closeAPP() {
		Gdx.app.exit();
	}
}