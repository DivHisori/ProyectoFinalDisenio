/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package IGU;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InterfazOperario extends Jframe{
private JPanel panelFondo, panelFormulario;
    private JLabel lblTitulo, lblUsuario, lblContraseña, lblRol;
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;
    private JComboBox<String> comboRol;
    private JTable tablaOperarios;
    private JButton btnCrear, btnEditar, btnEliminar, btnSalir;
    private DefaultTableModel modelo;

    public InterfazOperador() {
        setTitle("Creación de Operador");
        setSize(1000, 600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); 

        
        panelFondo = new JPanel();
        panelFondo.setBackground(new Color(0, 51, 51));
        panelFondo.setLayout(null);
        panelFondo.setBounds(0, 0, 1000, 600);
        add(panelFondo);

       
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(890, 10, 90, 30);
        btnSalir.setBackground(new Color(51, 51, 51));
        btnSalir.setForeground(Color.white);
        btnSalir.setFocusPainted(false);
        btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        btnSalir.addActionListener(e -> System.exit(0));
        panelFondo.add(btnSalir);

      
        lblTitulo = new JLabel("CREAR OPERARIO");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(Color.white);
        lblTitulo.setBounds(30, 10, 300, 30);
        panelFondo.add(lblTitulo);

        
        panelFormulario = new JPanel();
        panelFormulario.setLayout(null);
        panelFormulario.setBackground(Color.white);
        panelFormulario.setBounds(50, 60, 900, 470);
        panelFondo.add(panelFormulario);

       
        lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(30, 30, 100, 25);
        panelFormulario.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(130, 30, 250, 25);
        panelFormulario.add(txtUsuario);

        lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setBounds(30, 70, 100, 25);
        panelFormulario.add(lblContraseña);

        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(130, 70, 250, 25);
        panelFormulario.add(txtContraseña);

        lblRol = new JLabel("Rol:");
        lblRol.setBounds(30, 110, 100, 25);
        panelFormulario.add(lblRol);

        comboRol = new JComboBox<>(new String[]{"Elegir...", "Diseñador", "Operario", "Cliente", "Proovedor"});
        comboRol.setBounds(130, 110, 250, 25);
        panelFormulario.add(comboRol);

      
        btnCrear = new JButton("Crear Operario");
        btnCrear.setBounds(30, 200, 150, 30);
        btnCrear.setBackground(new Color(51, 51, 51));
        btnCrear.setForeground(Color.white);
        panelFormulario.add(btnCrear);

        btnEditar = new JButton("Editar Operario");
        btnEditar.setBounds(190, 200, 150, 30);
        btnEditar.setBackground(new Color(51, 51, 51));
        btnEditar.setForeground(Color.white);
        panelFormulario.add(btnEditar);

        btnEliminar = new JButton("Eliminar Operario");
        btnEliminar.setBounds(110, 250, 160, 30);
        btnEliminar.setBackground(new Color(51, 51, 51));
        btnEliminar.setForeground(Color.white);
        panelFormulario.add(btnEliminar);

       
        modelo = new DefaultTableModel(new String[]{"Usuario", "Rol"}, 0);
        tablaOperarios = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tablaOperarios);
        scroll.setBounds(420, 30, 450, 350);
        panelFormulario.add(scroll);

       
        btnCrear.addActionListener(e -> {
            String user = txtUsuario.getText();
            String rol = comboRol.getSelectedItem().toString();
            if (!user.isEmpty() && !rol.equals("Elegir...")) {
                modelo.addRow(new Object[]{user, rol});
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Complete los campos correctamente.");
            }
        });

        btnEliminar.addActionListener(e -> {
            int fila = tablaOperarios.getSelectedRow();
            if (fila >= 0) {
                modelo.removeRow(fila);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un operario para eliminar.");
            }
        });

        btnEditar.addActionListener(e -> {
            int fila = tablaOperarios.getSelectedRow();
            if (fila >= 0) {
                modelo.setValueAt(txtUsuario.getText(), fila, 0);
                modelo.setValueAt(comboRol.getSelectedItem().toString(), fila, 1);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un operario para editar.");
            }
        });

        tablaOperarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = tablaOperarios.getSelectedRow();
                txtUsuario.setText(modelo.getValueAt(fila, 0).toString());
                comboRol.setSelectedItem(modelo.getValueAt(fila, 1).toString());
            }
        });

        setVisible(true);
    }

    private void limpiarCampos() {
        txtUsuario.setText("");
        txtContraseña.setText("");
        comboRol.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new InterfazOperador();
    }
}
}
