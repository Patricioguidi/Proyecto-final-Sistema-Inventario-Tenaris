package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/inventario_tenaris";
    private static final String USER = "root";
    private static final String PASSWORD = "******"; 

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void probarConexion() {
        try (Connection _ = getConexion()) {

            System.out.println("====================================");
            System.out.println(" CONEXIÓN EXITOSA CON MYSQL ");
            System.out.println(" Base de datos: inventario_tenaris");
            System.out.println("====================================");

        } catch (SQLException e) {

            System.out.println("Error al conectar con MySQL:");
            System.out.println(e.getMessage());

        }
    }
}

