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
        Pokemon nuevo = new Pokemon(nombre.getText(), tipo.getText(), Integer.parseInt(nivelPoder.getText()), habilidad.getText(), estado.getText()); //nuevo pokemon
    }



}
