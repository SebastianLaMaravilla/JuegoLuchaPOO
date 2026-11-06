import java.util.Scanner;

/** Punto de entrada: permite configurar los jugadores desde la consola. */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            mostrarBienvenida();

            Personaje jugador1 = configurarJugador(scanner, 1);
            Personaje jugador2 = configurarJugador(scanner, 2);

            JuegoLucha juego = new JuegoLucha(jugador1, jugador2);
            juego.iniciarPelea();
        }
    }

    private static void mostrarBienvenida() {
        System.out.println("========================================");
        System.out.println("          JUEGO DE LUCHA POR TURNOS");
        System.out.println("========================================");
        System.out.println("Cada personaje comienza con 100 HP.");
        System.out.println("Los ataques causan entre 10 y 30 puntos de dano.");
        System.out.println("La armadura puede absorber hasta 5 puntos por ataque.");
    }

    private static Personaje configurarJugador(Scanner scanner, int numeroJugador) {
        System.out.println("\n--- CONFIGURACION DEL JUGADOR " + numeroJugador + " ---");
        String nombre = leerNombre(scanner);
        PersonajeFactory fabrica = seleccionarFabrica(scanner);
        Personaje personaje = fabrica.crearPersonaje(nombre);

        int opcionArmadura = leerOpcion(scanner,
                "\nDesea equipar una armadura?\n1. Si\n2. No\nSeleccione: ", 1, 2);
        if (opcionArmadura == 1) {
            personaje = new ArmaduraDecorador(personaje);
            System.out.println(nombre + " ha sido equipado con una armadura.");
        }

        System.out.println("Personaje creado: " + personaje.getNombre()
                + " - " + personaje.getTipo() + " - "
                + personaje.getPuntosDeVida() + " HP.");
        return personaje;
    }

    private static String leerNombre(Scanner scanner) {
        while (true) {
            System.out.print("Ingrese el nombre del personaje: ");
            String nombre = scanner.nextLine().trim();
            if (!nombre.isEmpty()) {
                return nombre;
            }
            System.out.println("El nombre no puede estar vacio. Intente nuevamente.");
        }
    }

    private static PersonajeFactory seleccionarFabrica(Scanner scanner) {
        System.out.println("Seleccione el tipo de personaje:");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        int opcion = leerOpcion(scanner, "Seleccione una opcion: ", 1, 2);

        // Factory Method: se selecciona la fabrica concreta que crea el personaje.
        if (opcion == 1) {
            return new GuerreroFactory();
        }
        return new MagoFactory();
    }

    private static int leerOpcion(Scanner scanner, String mensaje, int minimo, int maximo) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                int opcion = Integer.parseInt(entrada);
                if (opcion >= minimo && opcion <= maximo) {
                    return opcion;
                }
            } catch (NumberFormatException ignored) {
                // Se muestra el mensaje de validacion al final del ciclo.
            }
            System.out.println("Opcion no valida. Ingrese un numero entre "
                    + minimo + " y " + maximo + ".");
        }
    }
}
