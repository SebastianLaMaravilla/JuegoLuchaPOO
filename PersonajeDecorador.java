/**
 * Decorador base del patron Decorator.
 * Envuelve un Personaje y delega su comportamiento por defecto.
 */
public abstract class PersonajeDecorador extends Personaje {
    protected final Personaje personaje;

    protected PersonajeDecorador(Personaje personaje) {
        super(validarYObtenerNombre(personaje));
        this.personaje = personaje;
    }

    private static String validarYObtenerNombre(Personaje personaje) {
        if (personaje == null) {
            throw new IllegalArgumentException("El personaje que se va a decorar no puede ser null.");
        }
        return personaje.getNombre();
    }

    @Override
    public void atacar(Personaje oponente) {
        personaje.atacar(oponente);
    }

    @Override
    public void recibirDano(int dano) {
        personaje.recibirDano(dano);
    }

    @Override
    public boolean estaVivo() {
        return personaje.estaVivo();
    }

    @Override
    public String getNombre() {
        return personaje.getNombre();
    }

    @Override
    public int getPuntosDeVida() {
        return personaje.getPuntosDeVida();
    }

    @Override
    public String getTipo() {
        return personaje.getTipo();
    }
}
