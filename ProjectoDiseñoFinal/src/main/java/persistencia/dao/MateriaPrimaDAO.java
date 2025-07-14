// persistencia/dao/MateriaPrimaDAO.java
package persistencia.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Logica.MateriaPrima;
import persistencia.DatabaseConnection;

public class MateriaPrimaDAO {

    public void addMateriaPrima(MateriaPrima mp) {
        String sqlMateriaPrima = "INSERT INTO materia_prima (nombre_mp, descripcion_mp) VALUES (?, ?)";
        String sqlInventario = "INSERT INTO inventario_general_materia_prima (id_materia_prima, cantidad_disponible, unidad_inventario) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmtMp = conn.prepareStatement(sqlMateriaPrima, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement pstmtInv = conn.prepareStatement(sqlInventario)) {

            conn.setAutoCommit(false); // Start transaction

            // Insert into materia_prima
            pstmtMp.setString(1, mp.getTipo());
            pstmtMp.setString(2, "Materia Prima " + mp.getTipo()); // Simple description
            pstmtMp.executeUpdate();

            try (ResultSet generatedKeys = pstmtMp.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    mp.setIdMateriaPrima(generatedKeys.getInt(1)); // Set the generated ID
                } else {
                    throw new SQLException("Creating materia_prima failed, no ID obtained.");
                }
            }

            // Insert into inventario_general_materia_prima
            pstmtInv.setInt(1, mp.getIdMateriaPrima());
            pstmtInv.setDouble(2, mp.getCantidad());
            pstmtInv.setString(3, "unidades"); // Assuming a default unit
            pstmtInv.executeUpdate();

            conn.commit(); // Commit transaction
            System.out.println("Materia prima " + mp.getTipo() + " y su inventario registrados con éxito.");

        } catch (SQLException e) {
            System.err.println("Error al registrar materia prima: " + e.getMessage());
            // Rollback is implicitly handled by try-with-resources if auto-commit is off and an exception occurs
        }
    }

    public List<MateriaPrima> getAllMateriasPrimas() {
        List<MateriaPrima> materiasPrimas = new ArrayList<>();
        String sql = "SELECT mp.id_materia_prima, mp.nombre_mp, COALESCE(inv.cantidad_disponible, 0) AS cantidad_disponible, mpp.precio_por_unidad_compra " +
                     "FROM materia_prima mp " +
                     "LEFT JOIN inventario_general_materia_prima inv ON mp.id_materia_prima = inv.id_materia_prima " +
                     "LEFT JOIN materia_prima_proveedor mpp ON mp.id_materia_prima = mpp.id_materia_prima " +
                     "GROUP BY mp.id_materia_prima, mp.nombre_mp, inv.cantidad_disponible, mpp.precio_por_unidad_compra"; // Group by to avoid duplicates if multiple suppliers

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String tipo = rs.getString("nombre_mp");
                int cantidad = rs.getInt("cantidad_disponible");
                double precioUnitario = rs.getDouble("precio_por_unidad_compra"); // Taking one price, could be more complex
                materiasPrimas.add(new MateriaPrima(tipo, cantidad, precioUnitario));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener materias primas: " + e.getMessage());
        }
        return materiasPrimas;
    }

    public MateriaPrima getMateriaPrimaById(int idMateriaPrima) {
        String sql = "SELECT mp.id_materia_prima, mp.nombre_mp, COALESCE(inv.cantidad_disponible, 0) AS cantidad_disponible, mpp.precio_por_unidad_compra " +
                     "FROM materia_prima mp " +
                     "LEFT JOIN inventario_general_materia_prima inv ON mp.id_materia_prima = inv.id_materia_prima " +
                     "LEFT JOIN materia_prima_proveedor mpp ON mp.id_materia_prima = mpp.id_materia_prima " +
                     "WHERE mp.id_materia_prima = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idMateriaPrima);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String tipo = rs.getString("nombre_mp");
                    int cantidad = rs.getInt("cantidad_disponible");
                    double precioUnitario = rs.getDouble("precio_por_unidad_compra");
                    return new MateriaPrima(tipo, cantidad, precioUnitario);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener materia prima por ID: " + e.getMessage());
        }
        return null;
    }

    public void updateMateriaPrimaQuantity(int idMateriaPrima, int newQuantity) {
        String sql = "UPDATE inventario_general_materia_prima SET cantidad_disponible = ?, ultima_actualizacion = CURRENT_TIMESTAMP WHERE id_materia_prima = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newQuantity);
            pstmt.setInt(2, idMateriaPrima);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cantidad de materia prima actualizada con éxito.");
            } else {
                System.out.println("No se encontró la materia prima con ID " + idMateriaPrima + " en el inventario para actualizar.");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar cantidad de materia prima: " + e.getMessage());
        }
    }
}