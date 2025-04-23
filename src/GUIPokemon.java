import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GUIPokemon {

    private JPanel panelGeneral;
    private JButton Agregar;
    private JButton limpiarButton;
    private JButton ajusteDePoderButton;
    private JButton filtrarButton;
    private JTextField nombretxt;
    private JTextField txtTipo;
    private JTextField txtPoder;
    private JTextField txtHabilidad;
    private JTextField txtEstado;
    private JButton evolucionarButton;
    private JTextArea ColaArea;
    private JTextArea EvolucionArea;
    private JTextArea FIltradoArea;
    private JTextField txtBusquedaFiltro;

    public GUIPokemon() {

        ColaPokemon pok = new ColaPokemon();
        Pokemon pikachu = new Pokemon();

        Agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pok.encolarPokemon(ColaArea, nombretxt, txtTipo, txtPoder, txtHabilidad, txtEstado);
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Nivel de poder -> Número entero");
                }
                nombretxt.setText("");
                txtTipo.setText("");
                txtPoder.setText("");
                txtHabilidad.setText("");
                txtEstado.setText("");
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pok.pokemones.clear();
                ColaArea.setText("");
                FIltradoArea.setText("");
                EvolucionArea.setText("");
                ColaArea.setText(pikachu.getNombre() + "\n" + pikachu.getEstado() + " | " + pikachu.getHabilidad() + " | " + pikachu.getTipo() + " | " + pikachu.getNivelPoder() + "\n");
            }
        });
        ajusteDePoderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Poder ajustado para los pokemones de Fuego, Agua y Planta!");
                pok.poderTipo(ColaArea);
            }
        });
        evolucionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pok.evolucion(EvolucionArea);
            }
        });
        filtrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pok.filtrarHabilidad(txtBusquedaFiltro, FIltradoArea);
            }
        });

        ColaArea.setText(pikachu.getNombre() + "\n" + pikachu.getEstado() + " | " + pikachu.getHabilidad() + " | " + pikachu.getTipo() + " | " + pikachu.getNivelPoder() + "\n");

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUIPokemon");
        frame.setContentPane(new GUIPokemon().panelGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
