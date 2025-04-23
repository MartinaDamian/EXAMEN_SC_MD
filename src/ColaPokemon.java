import javax.swing.*;
import java.util.LinkedList;

public class ColaPokemon {
    LinkedList<Pokemon> pokemones = new LinkedList<>(); //cola
    Pokemon predet = new Pokemon();

    //constructor
    public ColaPokemon() {

    }

    //metodos solicitados
    public void encolarPokemon(JTextArea cont, JTextField nombre, JTextField tipo, JTextField nivelPoder, JTextField habilidad, JTextField estado){
        Pokemon nuevo = new Pokemon(nombre.getText(), tipo.getText(), Integer.parseInt(nivelPoder.getText()), habilidad.getText(), estado.getText()); //nuevo pokemon
        pokemones.add(nuevo); //agregando un pokemon a la pila

        //previsualizacion del ingreso de un pokemon
        StringBuilder sb = new StringBuilder();
        sb.append(cont.getText()).append(nombre.getText()).append("\n(").append(estado.getText()).append(habilidad.getText()).append(tipo.getText()).append(nivelPoder.getText()).append(")").append("\n");
        cont.setText(sb.toString());
    }

    public void poderTipo() {
        StringBuilder sb = new StringBuilder();

        for (Pokemon k : pokemones) {
            int poderOriginal = k.getNivelPoder();
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
            int poderFinal = (int) Math.round(ajustePoder);
            k.setNivelPoder(poderFinal);

            sb.append(k.getNombre()).append(" (").append(k.getTipo()).append(") -> ").append(poderOriginal).append(" ➡ ").append(poderFinal).append("\n");

        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Ajuste de Poder", JOptionPane.INFORMATION_MESSAGE);

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
        filter.append(filtrado.getText()).append(filtrados.peek().getNombre()).append("\n\t(").append(filtrados.peek().getEstado()).append(filtrados.peek().getHabilidad()).append(filtrados.peek().getTipo()).append(filtrados.peek().getNivelPoder()).append(")").append("\n");
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
            }else if (cola.getHabilidad().equals("Fuego")){
                incremento = (int) Math.floor(cola.getNivelPoder() * 0.2);
                cola.setEstado("Evolucionando");
                cola.setNivelPoder(cola.getNivelPoder() + incremento);
                ev.add(cola);
            }
        }

        //previsualizacion
        for (Pokemon print : ev){
            StringBuilder evol = new StringBuilder();
            evol.append(evolucionando.getText()).append(ev.peek().getNombre()).append("\n\t(").append(ev.peek().getEstado()).append(ev.peek().getHabilidad()).append(ev.peek().getTipo()).append(ev.peek().getNivelPoder()).append(")").append("\n");
            evolucionando.setText(evol.toString());
        }
    }

}
