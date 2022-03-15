/**
 * 
 */
package controller.controls;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowShouldClose;

/**
 * @author Mario Gabriel N��ez Alc�zar de Velasco
 */
public interface Keyboard {
	static void capture(long win) {
		/*
		 * Configura la captura del teclado
		 * Se llamar� cada vez que se presione, repita o suelte una tecla.
		 */
		glfwSetKeyCallback(win, (window, key, scancode, action, mods) -> {
			/******************************************************
			 * Aqu� configuraremos los controles del Juego.********
			 ******************************************************/
			// Si pulsamos la tecla ESC (Escape), se cerrar� la ventana.
			if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE ) glfwSetWindowShouldClose(window, true);
		});
	}
}
