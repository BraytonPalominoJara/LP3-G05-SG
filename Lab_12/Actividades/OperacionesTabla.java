package Actividades;

import java.sql.*;

public class OperacionesTabla {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LP3", "root", "admin");
            
    /*        // a. Insertar registros
            PreparedStatement insertStmt = con.prepareStatement("INSERT INTO persona (dni, nombre, direccion) VALUES (?, ?, ?)");
            insertStmt.setString(1, "99999999");
            insertStmt.setString(2, "Enrique");
            insertStmt.setString(3, "Mollendo");
            insertStmt.executeUpdate();
      */      
            // b. Recuperar registros
            Statement selectStmt = con.createStatement();
            ResultSet resultSet = selectStmt.executeQuery("SELECT * FROM persona");
            while (resultSet.next()) {
                System.out.println("dni: " + resultSet.getString("dni") + ", Nombre: " + resultSet.getString("nombre") + ", direccion: " + resultSet.getString("direccion"));
            }


            // c. Actualizar registros
            PreparedStatement updateStmt = con.prepareStatement("UPDATE persona SET nombre = ? WHERE DNI = ?");
            updateStmt.setString(1, "88888888");
            updateStmt.setString(2, "Enrique");
            updateStmt.executeUpdate();
            
/*
            // d. Borrar registros
            PreparedStatement deleteStmt = con.prepareStatement("DELETE FROM persona WHERE dni = ?");
           deleteStmt.setString(1, "valor 1");
            deleteStmt.executeUpdate();
            
           */ 

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

