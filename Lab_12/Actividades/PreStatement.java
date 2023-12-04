package Actividades;

import java.sql.*;

public class PreStatement {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LP3", "root", "admin");

            // a. Insertar registros
            PreparedStatement insertStmt = con.prepareStatement("INSERT INTO persona (dni, nombre, direccion) VALUES (?, ?, ?)");
            insertStmt.setString(1, "9541621321");
            insertStmt.setString(2, "Pablo");
            insertStmt.setString(3, "Arequipa");
            insertStmt.executeUpdate();

            // b. Recuperar registros
            Statement selectStmt = con.createStatement();
            ResultSet resultSet = selectStmt.executeQuery("SELECT * FROM persona");
            while (resultSet.next()) {
                System.out.println("dni: " + resultSet.getString("dni") + ", Nombre: " + resultSet.getString("nombre") + ", direccion: " + resultSet.getString("direccion"));
            }

            // c. Actualizar registros
            PreparedStatement updateStmt = con.prepareStatement("UPDATE persona SET direccion = ? WHERE dni = ?");
            updateStmt.setString(1, "Arequipa");
            updateStmt.setString(2, "76649753");
            updateStmt.executeUpdate();

            // Mostrar registros actualizados
            System.out.println("\nRegistros después de la actualización:");
            resultSet = selectStmt.executeQuery("SELECT * FROM persona");
            while (resultSet.next()) {
                System.out.println("dni: " + resultSet.getString("dni") + ", Nombre: " + resultSet.getString("nombre") + ", direccion: " + resultSet.getString("direccion"));
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
