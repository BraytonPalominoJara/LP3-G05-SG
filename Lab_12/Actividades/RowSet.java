package Actividades;

import java.sql.*;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSet {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LP3", "root", "admin");

            // a. Insertar registros
            PreparedStatement insertStmt = con.prepareStatement("INSERT INTO persona (dni, nombre, direccion) VALUES (?, ?, ?)");
            insertStmt.setString(1, "984651231");
            insertStmt.setString(2, "Marilu");
            insertStmt.setString(3, "Matarani");
            insertStmt.executeUpdate();

            // b. Recuperar registros utilizando JdbcRowSet
            JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
            jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/LP3");
            jdbcRowSet.setUsername("root");
            jdbcRowSet.setPassword("admin");
            jdbcRowSet.setCommand("SELECT * FROM persona");
            jdbcRowSet.execute();

            while (jdbcRowSet.next()) {
                System.out.println("dni: " + jdbcRowSet.getString("dni") + ", Nombre: " + jdbcRowSet.getString("nombre") + ", direccion: " + jdbcRowSet.getString("direccion"));
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

