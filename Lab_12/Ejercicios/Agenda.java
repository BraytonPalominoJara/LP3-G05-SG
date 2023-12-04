package Ejercicios;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Agenda {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ejer";
        String user = "root";
        String password = "admin";


        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            insertarNuevoRegistro(connection);
            buscarPorApellido(connection, "Green");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private static void insertarNuevoRegistro(Connection connection) {
        try{      
            String sql = "INSERT INTO Agenda (Nombre, Apellido, Email, Telefono) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);


            preparedStatement.setString(1, "Mike");
            preparedStatement.setString(2, "Green");
            preparedStatement.setString(3, "demo1@deitel.com");
            preparedStatement.setString(4, "555-5555");


            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Nuevo registro insertado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private static void buscarPorApellido(Connection connection, String apellido) {
        String query = "SELECT * FROM Agenda WHERE Apellido LIKE '%" + apellido + "%'";
		// Resto del código para ejecutar la consulta y procesar los resultados (puedes adaptar el código de AgendaApp aquí)
    }
}
