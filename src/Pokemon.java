import java.lang.ref.PhantomReference;

public class Pokemon {
    //Declaración de variables
    private String nombre;
    private String tipo;
    private int nivelPoder;
    private String habilidad;
    private String estado;

    //Constructor para valores que ingrese el usuario
    public Pokemon(String nombre, String tipo, int nivelPoder, String habilidad, String estado) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivelPoder = nivelPoder;
        this.habilidad = habilidad;
        this.estado = estado;
    }
    //Constructor con valores predeterminados
    public Pokemon() {
        this.nombre = "Pikachu";
        this.tipo = "Eléctrico";
        this.nivelPoder = 120;
        this.habilidad = "Impactrueno";
        this.estado = "Activo";
    }

    //getters
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

    //setters
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNivelPoder(int nivelPoder) {
        this.nivelPoder = nivelPoder;
    }

    //toString
    @Override
    public String toString() {

        return "Pokemon: " + nombre + "\n"+
                "Tipo: " + tipo + "\n"+
                "Nivel de poder: " + nivelPoder + "\n"+
                "Habilidad: " + habilidad + "\n"+
                "Estado: " + estado;
    }
}
