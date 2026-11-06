/** Factory Method concreto para crear magos. */
public class MagoFactory extends PersonajeFactory {
    @Override
    public Personaje crearPersonaje(String nombre) {
        return new Mago(nombre);
    }
}
