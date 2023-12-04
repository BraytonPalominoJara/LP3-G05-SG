package Actividades;

import java.sql.*;
import java.util.Scanner;

public class Seguridad {
    public static void main(String[] args) {
        Connection con = null;
        String usuario = "";
        Scanner scanner = new Scanner(System.in);
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LP3", "root", "admin");

            System.out.println("¿Qué tipo de usuario es?");
            usuario = scanner.nextLine();

            // Deshabilitar autocommit para comenzar una transacción
            con.setAutoCommit(false);

            // a. Recuperar registros
            Statement selectStmt = con.createStatement();
            ResultSet resultSet = selectStmt.executeQuery("SELECT * FROM persona");
            while (resultSet.next()) {
                System.out.println("DNI: " + resultSet.getString("dni") + ", Nombre: " + resultSet.getString("nombre") + ", Dirección: " + resultSet.getString("direccion"));
            }

            // b. Actualizar registros usando PreparedStatement
            if (usuario.equalsIgnoreCase("Admin")) {
                PreparedStatement updateStmt = con.prepareStatement("UPDATE persona SET direccion = ? WHERE dni = ?");
                updateStmt.setString(1, "p");
                updateStmt.setString(2, "76649753");
                updateStmt.executeUpdate();

                // Mostrar registros actualizados
                System.out.println("\nRegistros después de la actualización:");
                resultSet = selectStmt.executeQuery("SELECT * FROM persona");
                while (resultSet.next()) {
                    System.out.println("DNI: " + resultSet.getString("dni") + ", Nombre: " + resultSet.getString("nombre") + ", Dirección: " + resultSet.getString("direccion"));
                }

                con.commit();
            } else {
                System.out.println("Acceso denegado. El usuario no es un administrador.");
            }

        } catch (SQLException e) {
            // Revertir la transacción en caso de error
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // Restablecer autocommit al final
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
