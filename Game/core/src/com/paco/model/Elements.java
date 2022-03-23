package com.paco.model;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
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
}
