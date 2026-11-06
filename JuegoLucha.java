/** Controla los turnos, el estado del combate y la determinacion del ganador. */
public class JuegoLucha {
    private final Personaje jugador1;
    private final Personaje jugador2;

    public JuegoLucha(Personaje jugador1, Personaje jugador2) {
        if (jugador1 == null || jugador2 == null) {
            throw new IllegalArgumentException("Los dos jugadores deben existir.");
        }
        if (jugador1 == jugador2) {
            throw new IllegalArgumentException("Un personaje no puede luchar contra si mismo.");
        }
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void iniciarPelea() {
        System.out.println("\n========================================");
        System.out.println("       COMIENZA EL JUEGO DE LUCHA");
        System.out.println("========================================");
        mostrarPersonaje(jugador1);
        mostrarPersonaje(jugador2);

        int numeroTurno = 1;
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            System.out.println("\n---------- RONDA " + numeroTurno + " ----------");
            turno(jugador1, jugador2);

            // Si el primer jugador derrota al segundo, no se ejecuta otro ataque.
            if (jugador2.estaVivo()) {
                turno(jugador2, jugador1);
            }
            numeroTurno++;
        }

        Personaje ganador = jugador1.estaVivo() ? jugador1 : jugador2;
        Personaje perdedor = jugador1.estaVivo() ? jugador2 : jugador1;

        System.out.println("\n========================================");
        System.out.println("GANADOR: " + ganador.getNombre() + " (" + ganador.getTipo() + ")");
        System.out.println("VIDA RESTANTE: " + ganador.getPuntosDeVida() + " HP");
        System.out.println(perdedor.getNombre() + " ha sido derrotado.");
        System.out.println("========================================");
    }

    private void turno(Personaje atacante, Personaje defensor) {
        System.out.println("\nTurno de " + atacante.getNombre() + " (" + atacante.getTipo() + ")");
        System.out.println("HP de " + atacante.getNombre() + ": " + atacante.getPuntosDeVida());
        System.out.println("HP de " + defensor.getNombre() + ": " + defensor.getPuntosDeVida());

        atacante.atacar(defensor);

        System.out.println("Resultado: " + defensor.getNombre() + " tiene "
                + defensor.getPuntosDeVida() + " HP.");
    }

    private void mostrarPersonaje(Personaje personaje) {
        System.out.println(personaje.getNombre() + " - " + personaje.getTipo()
                + " - " + personaje.getPuntosDeVida() + " HP");
    }
}
