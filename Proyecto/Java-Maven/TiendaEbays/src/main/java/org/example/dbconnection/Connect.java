package org.example.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {


    private String url = "jdbc:mysql://localhost:3306";
    private String usuario = "root";
    private String contrasena = "root";


    public void conectar () throws SQLException{
        try (Connection con = DriverManager.getConnection(url, usuario, contrasena)) {
            System.out.println("Conexión exitosa a la base de datos");
            /* para ejecutar una consulta


            // Crear una declaración SQL
            Statement declaracionSQL = con.createStatement();

            // Ejecutar una consulta
            String sql = "SELECT * FROM tu_tabla";  // Reemplaza 'tu_tabla' con el nombre de tu tabla
            ResultSet rs = declaracionSQL.executeQuery(sql);

            // Mostrar los resultados
            while (rs.next()) {
                // Suponiendo que tu tabla tiene una columna llamada 'id' y otra llamada 'nombre'
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }
             */

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}