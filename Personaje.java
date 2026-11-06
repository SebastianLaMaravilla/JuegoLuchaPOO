import java.util.Random;

/**
 * Clase base de todos los luchadores.
 * Cada personaje inicia con 100 puntos de vida y causa entre 10 y 30
 * puntos de dano por ataque.
 */
public abstract class Personaje {
    private static final int VIDA_INICIAL = 100;
    private static final int DANO_MINIMO = 10;
    private static final int DANO_MAXIMO = 30;

    private final String nombre;
    private int puntosDeVida;
    private final Random random;

    protected Personaje(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del personaje no puede estar vacio.");
        }
        this.nombre = nombre.trim();
        this.puntosDeVida = VIDA_INICIAL;
        this.random = new Random();
    }

    /** Realiza un ataque con dano aleatorio entre 10 y 30, inclusive. */
    public void atacar(Personaje oponente) {
        if (oponente == null) {
            throw new IllegalArgumentException("El oponente no puede ser null.");
        }
        if (!estaVivo() || !oponente.estaVivo()) {
            return;
        }

        int dano = random.nextInt(DANO_MAXIMO - DANO_MINIMO + 1) + DANO_MINIMO;
        oponente.recibirDano(dano);

        System.out.println(getNombre() + " ataca a " + oponente.getNombre()
                + " causando " + dano + " puntos de dano.");
    }

    /** Reduce la vida sin permitir que el personaje quede con HP negativo. */
    public void recibirDano(int dano) {
        if (dano < 0) {
            throw new IllegalArgumentException("El dano no puede ser negativo.");
        }
        puntosDeVida = Math.max(0, puntosDeVida - dano);
    }

    public boolean estaVivo() {
        return puntosDeVida > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    /** Devuelve el tipo concreto del personaje. */
    public abstract String getTipo();
}
