package Actividades;


import java.sql.*;

public class Llamadas {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LP3", "root", "admin");
/*
            //  Insertar registros usando PreparedStatement
            PreparedStatement insertStmt = con.prepareStatement("INSERT INTO persona (dni, nombre, direccion) VALUES (?, ?, ?)");
            insertStmt.setString(1, "123245678");
            insertStmt.setString(2, "Fernando");
            insertStmt.setString(3, "Majes");
            insertStmt.executeUpdate();
*/
            //  Recuperar registros
            Statement selectStmt = con.createStatement();
            ResultSet resultSet = selectStmt.executeQuery("SELECT * FROM persona");
            while (resultSet.next()) {
                System.out.println("dni: " + resultSet.getString("dni") + ", Nombre: " + resultSet.getString("nombre") + ", direccion: " + resultSet.getString("direccion"));
           

            // Invocar un Procedimiento Almacenado usando CallableStatement
            CallableStatement callStmt = con.prepareCall("{call InsertarPersona(?, ?, ?)}");
            callStmt.setString(1, "88854122");
            callStmt.setString(2, "Palomino");
            callStmt.setString(3, "Arequipa");
            callStmt.execute();

            // Mostrar registros después de la invocación del procedimiento almacenado
            System.out.println("\nRegistros después de la invocación del procedimiento almacenado:");
            resultSet = selectStmt.executeQuery("SELECT * FROM persona");
            while (resultSet.next()) {
                System.out.println("dni: " + resultSet.getString("dni") + ", Nombre: " + resultSet.getString("nombre") + ", direccion: " + resultSet.getString("direccion"));
            }
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

