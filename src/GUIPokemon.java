import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIPokemon {

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

        Agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pok.encolarPokemon(ColaArea, nombretxt,txtTipo, txtPoder, txtHabilidad, txtEstado);
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 }
        });
        ajusteDePoderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pok.poderTipo();
                JOptionPane.showMessageDialog(null, "Poder ajustado para los pokemones de Fuego, Agua y Planta!");
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
    }
}
