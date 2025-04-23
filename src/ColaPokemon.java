import javax.swing.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ColaPokemon {
    LinkedList<Pokemon> pokemones = new LinkedList<>(); //cola
    private Pokemon predet;

    //constructor
    public ColaPokemon() {
        pokemones.add(predet);
    }

    //metodos solicitados
    public void encolarPokemon(JTextArea cont, JTextField nombre, JTextField tipo, JTextField nivelPoder, JTextField habilidad, JTextField estado){
        Pokemon nuevo = new Pokemon(nombre.getText(), tipo.getText(), Integer.parseInt(nivelPoder.getText()), habilidad.getText(), estado.getText()); //nuevo pokemon
        pokemones.add(nuevo); //agregando un pokemon a la pila

        //previsualizacion del ingreso de un pokemon
        StringBuilder sb = new StringBuilder();
        sb.append(cont).append(pokemones.peek().getNombre() + "\n\t(" + pokemones.peek().getEstado() + pokemones.peek().getHabilidad() + pokemones.peek().getTipo() + pokemones.peek().getNivelPoder() + ")").append("\n");
        cont.setText(cont.toString());
    }

    public void poderTipo() {
        LinkedList<Pokemon> pokemonesNuevoPoder = new LinkedList<>();
        for (Pokemon k : pokemones) {
            double ajustePoder = k.getNivelPoder();

            switch (k.getTipo()) {
                case "Fuego":
                    ajustePoder *= 1.3;
                    break;
                case "Agua":
                    ajustePoder *= 1.5;
                    break;
                case "Planta":
                    ajustePoder *= 1.2;
                    break;
                default:
                    break;
            }
            k.setNivelPoder((int)Math.round(ajustePoder));
        }
    }

    public void filtrarHabilidad(JTextField habilidad, JTextArea filtrado){
        LinkedList<Pokemon> filtrados = new LinkedList<>(); //nueva lista con filtrados por habilidad
        for(Pokemon cola : pokemones){
            if (habilidad.getText().equals(cola.getHabilidad())){
                filtrados.add(cola); //agregar solo a los pokemones que tengan esa habilidad
            }
        }

        //previsualizacion
        StringBuilder filter = new StringBuilder();
        filter.append(filtrado).append(filtrados.peek().getNombre() + "\n\t(" + filtrados.peek().getEstado() + filtrados.peek().getHabilidad() + filtrados.peek().getTipo() + filtrados.peek().getNivelPoder() + ")").append("\n");
        filtrado.setText(filter.toString());
    }

    public void evolucion(JTextArea evolucionando){
        LinkedList<Pokemon> ev = new LinkedList<>(); //cola con pokemones en evolucion
        int incremento;
        //los pokemones evolucionan si tienen un nivel de poder mayor a 140
        for (Pokemon cola : pokemones){
            if (cola.getNivelPoder() > 140){
                incremento = (int) Math.floor(cola.getNivelPoder() * 0.2);
                cola.setEstado("Evolucionando");
                cola.setNivelPoder(cola.getNivelPoder() + incremento);
                ev.add(cola);
            }

            if (cola.getHabilidad().equals("Fuego")){
                incremento = (int) Math.floor(cola.getNivelPoder() * 0.2);
                cola.setEstado("Evolucionando");
                cola.setNivelPoder(cola.getNivelPoder() + incremento);
                ev.add(cola);
            }
        }

        //previsualizacion
        StringBuilder evol = new StringBuilder();
        evol.append(evolucionando).append(ev.peek().getNombre() + "\n\t(" + ev.peek().getEstado() + ev.peek().getHabilidad() + ev.peek().getTipo() + ev.peek().getNivelPoder() + ")").append("\n");
        evolucionando.setText(evol.toString());
    }

}
