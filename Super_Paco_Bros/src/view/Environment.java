package view;

import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_SCALE_TO_MONITOR;
import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwGetWindowSize;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;
import java.nio.IntBuffer;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryStack;

import controller.controls.Keyboard;

/**
 * <strong>Carga y control de Graficos</strong>.
 * 
 * @author Mario Gabriel N��ez Alc�zar de Velasco
 */
public class Environment implements Pictures, Keyboard {
	/**
	 * <strong>Ventana</strong>.
	 * 
	 * <br><br>Representa la ventana que est� siendo ejecutada.
	 */
	public static long window;
	
	/**
	 * Constructor de graficos
	 */
	public Environment() {
		/*
		 * Establecemos el modo de retorno en los errores.
		 * De esta manera predefinimos el modo de impresi�n de los errores.
		 */
		GLFWErrorCallback.createPrint(System.err).set();

		// Inicializamos el controlador de graficos. muchas funciones del API solo funcionar�n tras ejecutar esta funci�n.
		if ( !glfwInit() ) throw new IllegalStateException("Imposible iniciar el controlador de graficos.");
		
		// Establecemos los parametros b�sicos del controlador de graficos
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // La ventana permanecer� visible tras su creaci�n.
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // La ventana podr� ser redimensionada.
		glfwWindowHint(GLFW_SCALE_TO_MONITOR, GLFW_TRUE); // hacemos la ventana escalable al monitor

		// Creamos la ventana
		window = glfwCreateWindow(1920, 1080, "Super Paco Bros", glfwGetPrimaryMonitor(), NULL);
		
		/*
		 * si la ventana no ha podido ser creada, 'window' ser� null, en ese caso lanzamos un error.
		 */
		if ( window == NULL ) throw new RuntimeException("Imposible realizar la carga de los gr�ficos");

		Keyboard.capture(window); // Establecemos los controles del juego

		// Obtiene la lista de Frames en tiempo real y crea uno nuevo
		try ( MemoryStack stack = stackPush() ) {
			IntBuffer pWidth = stack.mallocInt(1);
			IntBuffer pHeight = stack.mallocInt(1);

			// Obtiene el tama�o de la pantalla
			glfwGetWindowSize(window, pWidth, pHeight);

			// Obtiene la resolucion de la pantalla principal
			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

			// Centra la vista de los graficos en la ventana
			glfwSetWindowPos(
				window,
				(vidmode.width() - pWidth.get(0)) / 2,
				(vidmode.height() - pHeight.get(0)) / 2
			);
		} // los Frames se mostrar�n aut�maticamente segun ser�n creados

		// Establece la ventana actual
		glfwMakeContextCurrent(window);
		
		// Activamos v-sync
		glfwSwapInterval(1);

		// hace la ventana visible.
		glfwShowWindow(window);
	}
	
	@Override
	public void Frame(action accion) {
		switch (accion) {
		case NEW:
			/*
			 * Ejecutamos el bucle de renderizado de graficos hasta que el usuario decida cerrar el juego
			 */ 
			while ( !glfwWindowShouldClose(window) ) {// Mientras que el usuario no intente cerrar la ventana 
				glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // limpiamos el Buffer de Frames

				glfwSwapBuffers(window); // intercambia el Buffer de colores

				// Sondea los eventos de la venatana.
				glfwPollEvents();
			}
			
			break;
		}
	}
}
