package com.paco.model;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * @author Mario Gabriel N��ez Alc�zar de Velasco
 */
public interface Elements {
	/*
	 * Declaramos el Layout
	 */
	Table layout = new Table();
	
	/*
	 * Declaramos el escenario (Stage)
	 * 
	 * contiene Actores (Actor)
	 */
	Stage stage = new Stage();
	
	/*
	 *  Declaramos el duendecillo (Sprite) a usar como bot�n.
	 *  
	 *  Un duendecillo es una imagen que representa un objeto que es capaz de interaccionar con el usuario
	 *  en un videojuego
	 */
	Pixmap buttonSprite = new Pixmap(100,100,Format.RGBA4444);
	
	/*
	 * Declaramos el Asset del bot�n (ButtonStyle)
	 * 
	 * Esto har� que se dibuje el boton, en definitiva, 
	 * es el Asset que contiene los Sprites del bot�n en cada uno de sus estados
	 * 
	 * Un Asset es un objeto que contiene todos los sprites posibles para cada estado del boton.  
	 */
	ButtonStyle buttonAsset = new ButtonStyle();
	
	/*
	 * Declaramos el objeto Bot�n y le insertamos el asset
	 */
	Button button = new Button(buttonAsset);
}
