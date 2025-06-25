/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IGU;
  
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FormularioAlmacen extends JFrame {
   
    private JTextField txtFechaIngreso, txtNombre, txtCategoria,txtCantidad, txtProveedor, txtPrecio;

   
    private JButton btnRegistrar, btnActualizar, btnEliminar, btnCerrar;

    
    private JTable tablaAlmacen;
    private DefaultTableModel modeloTabla;

    public FormularioAlmacen() {
        setTitle("Gestión de Almacén");
        setSize(850, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 245)); 

        
        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(null);
        panelDatos.setBounds(20, 20, 390, 300);
        panelDatos.setBackground(new Color(0, 51, 102)); 
        add(panelDatos);

        
        String[] etiquetas = {
            "Fecha de ingreso:",  "Nombre producto:",
             "Cantidad almacenada:", 
            "Proveedor:", "Precio unitario:"
        };
        JTextField[] campos = new JTextField[etiquetas.length];

        int y = 20;
        for (int i = 0; i < etiquetas.length; i++) {
            JLabel lbl = new JLabel(etiquetas[i]);
            lbl.setForeground(Color.WHITE);
            lbl.setBounds(20, y, 150, 25);
            panelDatos.add(lbl);

            JTextField txt = new JTextField();
            txt.setBounds(180, y, 180, 25);
            panelDatos.add(txt);
            campos[i] = txt;

            y += 35;
        }

        txtFechaIngreso = campos[0];
        txtNombre = campos[1];
        txtCategoria = campos[2];
        txtCantidad = campos[3];
        txtProveedor = campos[4];
        txtPrecio = campos[5];

       
        btnRegistrar = new JButton("Registrar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnCerrar = new JButton("Cerrar");

        JButton[] botones = { btnRegistrar, btnActualizar, btnEliminar, btnCerrar };
        int xBtn = 430;
        for (JButton btn : botones) {
            btn.setBounds(xBtn, 340, 120, 30);
            btn.setBackground(new Color(0, 128, 128)); 
            btn.setForeground(Color.WHITE);
            add(btn);
            xBtn += 130;
        }

        
        modeloTabla = new DefaultTableModel(new String[]{
            "Nombre", "Categoría", "Cantidad", "Fecha", "Precio"
        }, 0);

        tablaAlmacen = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaAlmacen);
        scrollTabla.setBounds(20, 390, 800, 150);
        add(scrollTabla);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormularioAlmacen ventana = new FormularioAlmacen();
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setVisible(true);
        });
    }
}

