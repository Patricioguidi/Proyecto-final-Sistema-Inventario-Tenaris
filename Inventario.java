package dao;

import conexion.Conexion;
import modelo.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaterialDAO implements Crud<Material> {

    @Override
public boolean insertar(Material material) {

    String sql = "INSERT INTO materiales (id, nombre, stock, precio) VALUES (?, ?, ?, ?)";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, material.getId());
        ps.setString(2, material.getNombre());
        ps.setInt(3, material.getStock());
        ps.setDouble(4, material.getPrecio());

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {

        System.out.println("Error al guardar en MySQL: " + e.getMessage());
        return false;
    }
}

    @Override
public ArrayList<Material> listar() {

    ArrayList<Material> lista = new ArrayList<>();

    String sql = "SELECT * FROM materiales";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            Material material = new Material(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("stock"),
                    rs.getDouble("precio")
            );

            lista.add(material);
        }

    } catch (SQLException e) {
        System.out.println("Error al listar materiales: " + e.getMessage());
    }

    return lista;
}

 
    
    @Override
public boolean actualizar(Material material) {

    String sql = "UPDATE materiales SET nombre=?, stock=?, precio=? WHERE id=?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, material.getNombre());
        ps.setInt(2, material.getStock());
        ps.setDouble(3, material.getPrecio());
        ps.setInt(4, material.getId());

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {
        System.out.println("Error al actualizar material: " + e.getMessage());
        return false;
    }
}

@Override
public boolean eliminar(int id) {

    String sql = "DELETE FROM materiales WHERE id=?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id);

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {
        System.out.println("Error al eliminar material: " + e.getMessage());
        return false;
    }
}

}