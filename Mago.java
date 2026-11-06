/** Personaje especializado en el uso de magia. */
public class Mago extends Personaje {
    public Mago(String nombre) {
        super(nombre);
    }

    @Override
    public String getTipo() {
        return "Mago";
    }
}
