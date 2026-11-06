/**
 * Creador abstracto del patron Factory Method.
 * Las subclases deciden que tipo concreto de Personaje construir.
 */
public abstract class PersonajeFactory {
    public abstract Personaje crearPersonaje(String nombre);
}
