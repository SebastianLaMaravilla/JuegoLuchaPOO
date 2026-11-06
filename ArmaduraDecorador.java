/**
 * Decorador concreto que agrega una armadura.
 * La armadura absorbe hasta 5 puntos de cada ataque recibido.
 */
public class ArmaduraDecorador extends PersonajeDecorador {
    private static final int ABSORCION = 5;

    public ArmaduraDecorador(Personaje personaje) {
        super(personaje);
    }

    @Override
    public void recibirDano(int dano) {
        if (dano < 0) {
            throw new IllegalArgumentException("El dano no puede ser negativo.");
        }

        int danoAbsorbido = Math.min(dano, ABSORCION);
        int danoReal = dano - danoAbsorbido;

        System.out.println("La armadura de " + getNombre() + " absorbe "
                + danoAbsorbido + " puntos de dano.");
        super.recibirDano(danoReal);
    }

    @Override
    public String getTipo() {
        return personaje.getTipo() + " con armadura";
    }
}
