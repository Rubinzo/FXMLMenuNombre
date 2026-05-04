package org.example.dao.impl;

import org.example.config.DatabaseConfig;
import org.example.dao.ProductoDAO;
import org.example.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {
    @Override
    public void guardar(Producto producto) {
        String sql = "INSERT INTO procutos (nombre, precio, stock) VALUES (?, ?, ?)";

        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al insertar productos: " + ex.getMessage());
        }
    }

    @Override
    public List<Producto> cargar() {
        List<Producto> personas = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection con = DatabaseConfig.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Producto p = new Producto(
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getInt("id")
                );
                personas.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar productos: " + e.getMessage());
        }

        return personas;
    }
}
