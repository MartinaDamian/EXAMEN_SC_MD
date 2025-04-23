import java.lang.ref.PhantomReference;

public class Pokemon {
    //Declaración de variables
    private String nombre;
    private String tipo;
    private int nivelPoder;
    private String habilidad;
    private String estado;

    //Constructor con valores predeterminados
    public Pokemon(String nombre, String tipo, int nivelPoder, String habilidad, String estado) {
        this.nombre = "Pikachu";
        this.tipo = "Eléctrico";
        this.nivelPoder = 120;
        this.habilidad = "Impactrueno";
        this.estado = "Activo";
    }

    //
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivelPoder() {
        return nivelPoder;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNivelPoder(int nivelPoder) {
        this.nivelPoder = nivelPoder;
    }

    @Override
    public String toString() {

        return "Pokemon: " + nombre + "\n"+
                "Tipo: " + tipo + "\n"+
                "Nivel de poder: " + nivelPoder + "\n"+
                "Habilidad: " + habilidad + "\n"+
                "Estado: " + estado;
    }
}
