package persistencia.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Logica.Operario;
import Logica.Trabajador;
import persistencia.DatabaseConnection;

public class TrabajadorDAO {

    public void addOperario(Operario operario, String password) {
        String sql = "INSERT INTO usuario (usuario, clave, rol) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, operario.getNombre());
            pstmt.setString(2, password); // In a real app, hash this password!
            pstmt.setString(3, "Operario");
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    operario.setId(generatedKeys.getInt(1)); // Set the generated ID
                    System.out.println("Operario " + operario.getNombre() + " registrado con éxito con ID: " + operario.getId());
                } else {
                    throw new SQLException("Creating operario failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al registrar operario: " + e.getMessage());
        }
    }

    public List<Trabajador> getAllOperarios() {
        List<Trabajador> operarios = new ArrayList<>();
        String sql = "SELECT id, usuario FROM usuario WHERE rol = 'Operario'";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                operarios.add(new Operario(rs.getInt("id"), rs.getString("usuario")));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener operarios: " + e.getMessage());
        }
        return operarios;
    }

    public Trabajador getOperarioById(int id) {
        String sql = "SELECT id, usuario FROM usuario WHERE id = ? AND rol = 'Operario'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Operario(rs.getInt("id"), rs.getString("usuario"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener operario por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean authenticateUser(String username, String password, String role) {
        String sql = "SELECT COUNT(*) FROM usuario WHERE usuario = ? AND clave = ? AND rol = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, role);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error de autenticación: " + e.getMessage());
        }
        return false;
    }
}
