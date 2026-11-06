/** Personaje especializado en el combate cuerpo a cuerpo. */
public class Guerrero extends Personaje {
    public Guerrero(String nombre) {
        super(nombre);
    }

    @Override
    public String getTipo() {
        return "Guerrero";
    }
}
