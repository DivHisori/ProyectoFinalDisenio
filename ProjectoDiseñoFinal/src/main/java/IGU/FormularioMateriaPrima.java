/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IGU;
 import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioMateriaPrima extends JFrame {

    private JTextField txtFecha, txtNombre, txtTipo, txtCosto, txtCantidad, txtProveedor;
    private JTable tablaMateriaPrima;
    private DefaultTableModel modeloTabla;

    public FormularioMateriaPrima() {
        setTitle("Registro de Materia Prima");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(null);

        
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(null);
        panelFormulario.setBackground(new Color(0, 128, 128));
        panelFormulario.setBounds(20, 20, 360, 400);
        add(panelFormulario);

        JLabel lblTitulo = new JLabel("Registro de Materia Prima");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setBounds(80, 10, 250, 25);
        panelFormulario.add(lblTitulo);

       
        JLabel lblFecha = new JLabel("Fecha de ingreso:");
        JLabel lblNombre = new JLabel("Nombre de la Materia Prima:");
        JLabel lblTipo = new JLabel("Tipo de material:");
        JLabel lblCosto = new JLabel("Costo por unidad:");
        JLabel lblCantidad = new JLabel("Cantidad:");
        JLabel lblProveedor = new JLabel("Proveedor:");

        txtFecha = new JTextField();
        txtNombre = new JTextField();
        txtTipo = new JTextField();
        txtCosto = new JTextField();
        txtCantidad = new JTextField();
        txtProveedor = new JTextField();

        lblFecha.setBounds(20, 50, 150, 25); txtFecha.setBounds(180, 50, 160, 25);
        lblNombre.setBounds(20, 90, 200, 25); txtNombre.setBounds(180, 90, 160, 25);
        lblTipo.setBounds(20, 130, 150, 25); txtTipo.setBounds(180, 130, 160, 25);
        lblCosto.setBounds(20, 170, 150, 25); txtCosto.setBounds(180, 170, 160, 25);
        lblCantidad.setBounds(20, 210, 150, 25); txtCantidad.setBounds(180, 210, 160, 25);
        lblProveedor.setBounds(20, 250, 150, 25); txtProveedor.setBounds(180, 250, 160, 25);

        panelFormulario.add(lblFecha); panelFormulario.add(txtFecha);
        panelFormulario.add(lblNombre); panelFormulario.add(txtNombre);
        panelFormulario.add(lblTipo); panelFormulario.add(txtTipo);
        panelFormulario.add(lblCosto); panelFormulario.add(txtCosto);
        panelFormulario.add(lblCantidad); panelFormulario.add(txtCantidad);
        panelFormulario.add(lblProveedor); panelFormulario.add(txtProveedor);

        
        JButton btnGuardar = new JButton("Guardar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnCerrar = new JButton("Cerrar");

        btnGuardar.setBounds(20, 320, 90, 30);
        btnActualizar.setBounds(130, 320, 100, 30);
        btnCerrar.setBounds(250, 320, 80, 30);

        panelFormulario.add(btnGuardar);
        panelFormulario.add(btnActualizar);
        panelFormulario.add(btnCerrar);

        
        modeloTabla = new DefaultTableModel(new String[]{
                "Fecha", "Nombre", "Tipo", "Costo", "Cantidad", "Proveedor"
        }, 0);
        tablaMateriaPrima = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaMateriaPrima);
        scrollTabla.setBounds(400, 20, 370, 400);
        add(scrollTabla);

        
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fecha = txtFecha.getText();
                String nombre = txtNombre.getText();
                String tipo = txtTipo.getText();
                String costo = txtCosto.getText();
                String cantidad = txtCantidad.getText();
                String proveedor = txtProveedor.getText();

                if (!fecha.isEmpty() && !nombre.isEmpty() && !tipo.isEmpty() &&
                        !costo.isEmpty() && !cantidad.isEmpty() && !proveedor.isEmpty()) {
                    modeloTabla.addRow(new Object[]{fecha, nombre, tipo, costo, cantidad, proveedor});
                    JOptionPane.showMessageDialog(null, "Materia prima registrada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "Completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        btnCerrar.addActionListener(e -> dispose());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormularioMateriaPrima ventana = new FormularioMateriaPrima();
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setVisible(true);
        });
    }
}

    

