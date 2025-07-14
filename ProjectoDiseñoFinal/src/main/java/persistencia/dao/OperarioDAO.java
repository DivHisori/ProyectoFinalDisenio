// persistencia/dao/OperarioDAO.java
package persistencia.dao;

import Logica.Operario;
import persistencia.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperarioDAO {

    public void guardarOperario(Operario operario) {
        String sql = "INSERT INTO Trabajador (id, nombre, tipo_trabajador) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, operario.id);
            pstmt.setString(2, operario.nombre);
            pstmt.setString(3, "Operario"); // Indica el tipo de trabajador
            pstmt.executeUpdate();
            System.out.println("Operario " + operario.nombre + " guardado en la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error al guardar operario: " + e.getMessage());
        }
    }

    public Operario obtenerOperarioPorId(int id) {
        String sql = "SELECT id, nombre FROM Trabajador WHERE id = ? AND tipo_trabajador = 'Operario'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Operario(rs.getInt("id"), rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener operario: " + e.getMessage());
        }
        return null;
    }

    public List<Operario> obtenerTodosLosOperarios() {
        List<Operario> operarios = new ArrayList<>();
        String sql = "SELECT id, nombre FROM Trabajador WHERE tipo_trabajador = 'Operario'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                operarios.add(new Operario(rs.getInt("id"), rs.getString("nombre")));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener operarios: " + e.getMessage());
        }
        return operarios;
    }
}