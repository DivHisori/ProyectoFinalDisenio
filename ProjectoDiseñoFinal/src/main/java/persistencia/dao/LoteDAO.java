package persistencia.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Logica.Lote;
import Logica.Operario;
import persistencia.DatabaseConnection;

public class LoteDAO {

    public void addLote(Lote lote) {
        String sql = "INSERT INTO lote (id_prenda, cantidad_prendas_lote, estado_lote) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, ((Prenda) lote.getPrenda()).getIdPrenda());
            pstmt.setInt(2, lote.getCantidadAProducir());
            pstmt.setString(3, "PENDIENTE"); // Initial state
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    lote.setNumeroLote(generatedKeys.getInt(1)); // Set the generated ID
                    System.out.println("Lote #" + lote.getNumeroLote() + " creado en la base de datos.");
                } else {
                    throw new SQLException("Creating lote failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al crear lote: " + e.getMessage());
        }
    }

    public List<Lote> getAllLotesPendientes() {
        List<Lote> lotes = new ArrayList<>();
        String sql = "SELECT l.id_lote, l.cantidad_prendas_lote, u.id AS operario_id, u.usuario AS operario_nombre, " +
                     "p.id_prenda, p.tipo_prenda, p.genero, p.temporada, p.estilo, p.costo_base_por_unidad, ipr.cantidad_disponible " +
                     "FROM lote l " +
                     "JOIN prenda p ON l.id_prenda = p.id_prenda " +
                     "LEFT JOIN inventario_producto_refinado ipr ON p.id_prenda = ipr.id_prenda " +
                     "LEFT JOIN usuario u ON u.rol = 'Operario' " + // This is a simplification, ideally operario ID should be in lote table
                     "WHERE l.estado_lote = 'PENDIENTE'";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int idLote = rs.getInt("id_lote");
                int cantidadPrendas = rs.getInt("cantidad_prendas_lote");

                // Operario (simplified: assuming any operario for now, or you need to store operario_id in lote table)
                int operarioId = rs.getInt("operario_id");
                String operarioNombre = rs.getString("operario_nombre");
                Operario operario = new Operario(operarioId, operarioNombre);

                // Prenda
                int idPrenda = rs.getInt("id_prenda");
                String tipoPrenda = rs.getString("tipo_prenda");
                String genero = rs.getString("genero");
                String temporada = rs.getString("temporada");
                String estilo = rs.getString("estilo");
                double costoBase = rs.getDouble("costo_base_por_unidad");
                int cantidadDisponible = rs.getInt("cantidad_disponible");
                Prenda prenda = new Prenda(idPrenda, tipoPrenda, genero, temporada, estilo, costoBase, cantidadDisponible);

                lotes.add(new Lote(idLote, operario, prenda, cantidadPrendas));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener lotes pendientes: " + e.getMessage());
        }
        return lotes;
    }

    public void updateLoteStatus(int idLote, String status) {
        String sql = "UPDATE lote SET estado_lote = ? WHERE id_lote = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, idLote);
            pstmt.executeUpdate();
            System.out.println("Estado del lote #" + idLote + " actualizado a " + status);
        } catch (SQLException e) {
            System.err.println("Error al actualizar estado del lote: " + e.getMessage());
        }
    }
}