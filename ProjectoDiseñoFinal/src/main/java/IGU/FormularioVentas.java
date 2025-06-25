
package IGU;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioVentas extends JFrame {

    private JTextField txtFecha, txtTipoPrenda, txtPrecio;
    private JButton btnGuardar, btnActualizar, btnEliminar, btnCerrar;
    private JTable tablaVentas;
    private DefaultTableModel modeloTabla;

    public FormularioVentas() {
        setTitle("Registro de Ventas");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 245));

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(null);
        panelFormulario.setBackground(new Color(0, 102, 102));
        panelFormulario.setBounds(20, 20, 300, 250);
        add(panelFormulario);

        JLabel lblFecha = new JLabel("Fecha de Venta:");
        JLabel lblTipo = new JLabel("Tipo de Prenda:");
        JLabel lblPrecio = new JLabel("Precio:");

        lblFecha.setForeground(Color.white);
        lblTipo.setForeground(Color.white);
        lblPrecio.setForeground(Color.white);

        lblFecha.setBounds(20, 20, 120, 25);
        lblTipo.setBounds(20, 70, 120, 25);
        lblPrecio.setBounds(20, 120, 120, 25);

        panelFormulario.add(lblFecha);
        panelFormulario.add(lblTipo);
        panelFormulario.add(lblPrecio);

        txtFecha = new JTextField();
        txtTipoPrenda = new JTextField();
        txtPrecio = new JTextField();

        txtFecha.setBounds(140, 20, 140, 25);
        txtTipoPrenda.setBounds(140, 70, 140, 25);
        txtPrecio.setBounds(140, 120, 140, 25);

        panelFormulario.add(txtFecha);
        panelFormulario.add(txtTipoPrenda);
        panelFormulario.add(txtPrecio);

        btnGuardar = new JButton("Guardar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnCerrar = new JButton("Cerrar");

        btnGuardar.setBounds(20, 170, 110, 30);
        btnActualizar.setBounds(160, 170, 110, 30);

        btnGuardar.setBackground(new Color(0, 128, 128));
        btnActualizar.setBackground(new Color(0, 128, 128));
        btnGuardar.setForeground(Color.WHITE);
        btnActualizar.setForeground(Color.WHITE);

        panelFormulario.add(btnGuardar);
        panelFormulario.add(btnActualizar);

        btnEliminar.setBounds(340, 290, 110, 30);
        btnCerrar.setBounds(470, 290, 110, 30);

        add(btnEliminar);
        add(btnCerrar);

        btnEliminar.setBackground(new Color(153, 0, 0));
        btnCerrar.setBackground(new Color(102, 102, 102));
        btnEliminar.setForeground(Color.WHITE);
        btnCerrar.setForeground(Color.WHITE);

        modeloTabla = new DefaultTableModel(new String[]{"Fecha", "Tipo Prenda", "Precio"}, 0);
        tablaVentas = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaVentas);
        scrollTabla.setBounds(340, 20, 320, 250);
        add(scrollTabla);

        
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fecha = txtFecha.getText();
                String tipo = txtTipoPrenda.getText();
                String precio = txtPrecio.getText();

                if (!fecha.isEmpty() && !tipo.isEmpty() && !precio.isEmpty()) {
                    modeloTabla.addRow(new Object[]{fecha, tipo, precio});
                    JOptionPane.showMessageDialog(null, "Venta registrada correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

       
        btnCerrar.addActionListener(e -> dispose());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormularioVentas ventana = new FormularioVentas();
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setVisible(true);
        });
    }
}



