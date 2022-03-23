package com.paco.model;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Base extends ApplicationAdapter implements Elements{
	
	/**
	 * Declara los elementos que van a jugar en la escena
	 */
	@Override
	public void create() {
		/*
		 *  Establcemos las diferentes posiciones posibles del boton con sus respectivos cambios en el Sprite
		 */
		// Posicion inicial (UP).
		buttonSprite.setColor(Color.GREEN);
		buttonSprite.fill();// Establecemos que el Sprite ocupe todo el ancho y el alto del colaider.
		
		//Declaro la textura del boton sin accionar
		Texture buttonUP = new Texture(buttonSprite);
		
		// Posicion Final (Down)
		buttonSprite.setColor(Color.RED);
		buttonSprite.fill();// Establecemos que el Sprite ocupe todo el ancho y el alto del colaider.
		
		//Declaro la textura del boton accionado
		Texture buttonDOWN = new Texture(buttonSprite);
		
		//Limpiamos el Sprite
		buttonSprite.dispose();
		
		//Insertamos los Srpites del botón en el Asset del mismo.
		buttonAsset.up = new TextureRegionDrawable(new TextureRegion(buttonUP));
		buttonAsset.down = new TextureRegionDrawable(new TextureRegion(buttonDOWN));
		
		//Añadimos el botón al layout
		layout.add(button);
		
		//Añadimos el layout como un Actor a la Escena
		stage.addActor(layout);
		
		//Añadimos el procesador de inputs
		Gdx.input.setInputProcessor(stage);
	}
}
