package controller;

import org.lwjgl.opengl.*;
import view.Environment;
import view.graphics.Graphics;
import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;

/**
 *  <strong>Motor del Juego</strong>.
 *  
 *  <br><br>Es el principal rey y señor del Paco Bros, sin el, nada funcionaría :).
 *  
 *  @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Motor extends Graphics{
	
	/**
	 * <strong>Main</strong>.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Environment graficos = new Environment(); // cargamos el entorno grafico inicial
		
		/*
		 * Cargamos la libreria de OpenGL
		 * 
		 * Este paso es esencial para la correcta ejecución del juego
		 */
		GL.createCapabilities();
	
		charge(); // Cargamos los graficos del juego.
		
		//Ejecutamos el renderizado de los graficos.
		graficos.Frame(action.NEW);
		
		// Liberamos el retorno de la ventana y destruimos la instancia de la misma
		glfwFreeCallbacks(window);
		glfwDestroyWindow(window);
	
		// Terminamos la ejecución del controlador de gráficos y liberamos el retorno de los errores.  
		glfwTerminate();
		glfwSetErrorCallback(null).free();
	}
}