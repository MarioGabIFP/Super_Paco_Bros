/**
 * 
 */
package view;

/**
 * 	Interfaz donde almacenaremos los graficos recurrentes (Ej. Bloques, Jugadores, enemigos)
 *  @author Mario Gabriel N��ez Alc�zar de Velasco
 */
public interface Pictures {
	enum action {
		NEW
	}
	
	/**
	 * <strong>M�todo abstracto para manejar el remnderizado de los Frames</strong>
	 */
	public void Frame(action accion);
}
