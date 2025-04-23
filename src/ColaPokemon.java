import javax.swing.*;
import java.util.LinkedList;

public class ColaPokemon {
    LinkedList<Pokemon> pokemones = new LinkedList<>(); //cola

    //constructor
    public ColaPokemon() {
        Pokemon predeterminado = new Pokemon();
        pokemones.add(predeterminado);
    }

    //metodos solicitados
    public void encolarPokemon(JTextArea cont, JTextField nombre, JTextField tipo, JTextField nivelPoder, JTextField habilidad, JTextField estado){
        Pokemon nuevo = new Pokemon(nombre.getText(), tipo.getText(), Integer.parseInt(nivelPoder.getText()), habilidad.getText(), estado.getText()); //nuevo pokemon
        pokemones.add(nuevo); //agregando un pokemon a la pila

        //previsualizacion del ingreso de un pokemon
        StringBuilder sb = new StringBuilder();
        sb.append(cont).append(pokemones.peek().getNombre()).append("\n\t(").append(pokemones.peek().getEstado()).append(pokemones.peek().getHabilidad()).append(pokemones.peek().getTipo()).append(pokemones.peek().getNivelPoder()).append(")").append("\n");
        cont.setText(cont.toString());
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
        assert filtrados.peek() != null;
        filter.append(filtrado).append(filtrados.peek().getNombre()).append("\n\t(").append(filtrados.peek().getEstado()).append(filtrados.peek().getHabilidad()).append(filtrados.peek().getTipo()).append(filtrados.peek().getNivelPoder()).append(")").append("\n");
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
        assert ev.peek() != null;
        evol.append(evolucionando).append(ev.peek().getNombre()).append("\n\t(").append(ev.peek().getEstado()).append(ev.peek().getHabilidad()).append(ev.peek().getTipo()).append(ev.peek().getNivelPoder()).append(")").append("\n");
        evolucionando.setText(evol.toString());
    }

}
