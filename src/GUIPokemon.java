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

    public GUIPokemon() {
        Agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

            }
        });
    }
}
