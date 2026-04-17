package org.example.dao.impl;

import org.example.config.DatabaseConfig;
import org.example.dao.ProductoDAO;
import org.example.model.Entrada;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {
    @Override
    public void guardar(Entrada entrada) {
        String sql = "INSERT INTO usuarios (nombre, precio) VALUES (?, ?)";

        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, entrada.getNombre());
            ps.setInt(2, entrada.getPrecio());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al insertar persona: " + ex.getMessage());
        }
    }

    @Override
    public List<Entrada> cargar() {
        List<Entrada> personas = new ArrayList<>();
        String sql = "SELECT * FROM personas";

        try (Connection con = DatabaseConfig.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Entrada p = new Entrada(
                        rs.getString("nombre"),
                        rs.getInt("precio"),
                        rs.getString("local"),
                        rs.getInt("id")
                );
                personas.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar personas: " + e.getMessage());
        }

        return personas;
    }
}
