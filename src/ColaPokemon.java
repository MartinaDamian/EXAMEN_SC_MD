import javax.swing.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ColaPokemon {
    LinkedList<Pokemon> pokemones = new LinkedList<>();
    private Pokemon predet;

    //constructor
    public ColaPokemon() {
        pokemones.add(predet);
    }

    //metodos solicitados
    public void encolarPokemon(JTextArea cont, JTextField nombre, JTextField tipo, JTextField nivelPoder, JFormattedTextField habilidad, JTextField estado){
        Pokemon nuevo = new Pokemon(nombre.getText(), tipo.getText(), Integer.parseInt(nivelPoder.getText()),  habilidad.getText(), estado.getText()); //nuevo pokemon
    }

    public void poderTipo(JTextField nombre, JTextField tipo, JTextField nivelPoder, JFormattedTextField habilidad, JTextField estado){
        LinkedList<Pokemon> pokemonesNuevoPoder = new LinkedList<>();
        for (Pokemon k : pokemones){
            double ajustePoder = k.getNivelPoder();
            switch (k.getTipo()){
                case "Fuego":
                    ajustePoder*=1.3;
                    break;
                case "Agua":
                    ajustePoder*=1.5;
                    break;
                case "Planta":
                    ajustePoder*=1.2;
                    break;
            }
            k.set
        }

    }

    public void actualizarCola(JTextField nombre, JTextField tipo, JFormattedTextField habilidad, JTextField estado){

    }


}
