import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JSpinner spnIdTrack;
    private JTextField txtReceptor;
    private JButton btnRegistrar;
    private JTextArea txtListar;
    private Agencia ag = new Agencia();

    public Ventana() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int id = Integer.parseInt(spnIdTrack.getValue().toString());
               String receptor = txtReceptor.getText();
                Paquete p1 = new Paquete(id, receptor);
                if(ag.agregar(p1)){
                    txtListar.setText(ag.listar());
                }  else JOptionPane.showMessageDialog(null, "El objeto es duplicado.");
            }
        });
        
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
