package Ejercicios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;


public class MySQLApp extends JFrame {
    private JTextField sqlTextField;
    private JButton executeButton;
    private JTable resultTable;


    private Connection connection;
    private Statement statement;


    public MySQLApp() {
        super("MySQL App");


        sqlTextField = new JTextField();
        executeButton = new JButton("Ejecutar");
        resultTable = new JTable();


        setLayout(new BorderLayout());
        add(sqlTextField, BorderLayout.NORTH);
        add(executeButton, BorderLayout.CENTER);
        add(new JScrollPane(resultTable), BorderLayout.SOUTH);


     
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "admin");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }


        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = sqlTextField.getText();
                executeSQL(sql);
            }
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void executeSQL(String sql) {
        try {
            if (sql.trim().toLowerCase().startsWith("select")) {
                ResultSet resultSet = statement.executeQuery(sql);
                resultTable.setModel(buildTableModel(resultSet));
            } else {
                int rowsAffected = statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Filas afectadas: " + rowsAffected);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al ejecutar la consulta: " + e.getMessage());
        }
    }


    private static DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();


        int columnCount = metaData.getColumnCount();
        Vector<String> columnNames = new Vector<>();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }


        Vector<Vector<Object>> data = new Vector<>();
        while (resultSet.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(resultSet.getObject(columnIndex));
            }
            data.add(vector);
        }


        return new DefaultTableModel(data, columnNames);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MySQLApp());
    }
}
