/** Factory Method concreto para crear guerreros. */
public class GuerreroFactory extends PersonajeFactory {
    @Override
    public Personaje crearPersonaje(String nombre) {
        return new Guerrero(nombre);
    }
}
