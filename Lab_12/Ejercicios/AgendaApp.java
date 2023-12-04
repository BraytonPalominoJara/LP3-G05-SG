package Ejercicios;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class AgendaApp extends JFrame {


    private Connection connection;
    private JTextField idField, nombreField, apellidoField, emailField, telefonoField;
    private JLabel registroLabel;
    private JTable table;
    private int registroActual = 1;
    private int totalRegistros = 0;
	private JButton buscarApellidoButton;
	private JTextComponent buscarApellidoField;


    public AgendaApp() {
        super("Agenda");


        String url = "jdbc:mysql://localhost:3306/ejer";
        String user = "root";
        String password = "admin";


        try {
            connection = DriverManager.getConnection(url, user, password);
            createTable();
            obtenerTotalRegistros();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }


        initializeUI();
    }


    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLayout(new BorderLayout());


        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        registroLabel = new JLabel("Registro: 1 de " + totalRegistros);
        panelSuperior.add(registroLabel);


        JPanel panelCentral = new JPanel(new GridLayout(6, 2, 5, 5));
        idField = new JTextField();
        idField.setEditable(false);


        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextField buscarApellidoField = new JTextField(20);
        buscarApellidoButton = new JButton("Buscar por Apellido");
        panelInferior.add(new JLabel("Apellido:"));
        panelInferior.add(buscarApellidoField);
        panelInferior.add(buscarApellidoButton);


        nombreField = new JTextField();
        apellidoField = new JTextField();
        emailField = new JTextField();
        telefonoField = new JTextField();


        JButton previoButton = new JButton("Anterior");
        JButton siguienteButton = new JButton("Siguiente");
        JButton verTodosButton = new JButton("Ver Todos");
        JButton nuevoRegistroButton = new JButton("Nuevo Registro");
        JButton editarRegistroButton = new JButton("Editar Registro");


        panelCentral.add(new JLabel("ID:"));
        panelCentral.add(idField);
        panelCentral.add(new JLabel("Nombre:"));
        panelCentral.add(nombreField);
        panelCentral.add(new JLabel("Apellido:"));
        panelCentral.add(apellidoField);
        panelCentral.add(new JLabel("Email:"));
        panelCentral.add(emailField);
        panelCentral.add(new JLabel("Teléfono:"));
        panelCentral.add(telefonoField);
        panelCentral.add(nuevoRegistroButton);
        panelCentral.add(verTodosButton);
        panelCentral.add(editarRegistroButton);
        panelCentral.add(previoButton);
        panelCentral.add(siguienteButton);


        buscarApellidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPorApellido();
            }
        });
        previoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarRegistro(--registroActual);
            }
        });


        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarRegistro(++registroActual);
            }
        });


        verTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTodosRegistros();
            }
        });


        nuevoRegistroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarNuevoRegistro();
            }
        });


        editarRegistroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarRegistro();
            }
        });


        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);


        pack();
        setLocationRelativeTo(null);
        setVisible(true);


        // Mostrar el primer registro al inicio
        mostrarRegistro(registroActual);
    }


    private void buscarPorApellido() {
        String apellidoABuscar = buscarApellidoField.getText().trim();
       
        if (!apellidoABuscar.isEmpty()) {
            try (Statement statement = connection.createStatement()) {
                String query = "SELECT * FROM Agenda WHERE Apellido LIKE '%" + apellidoABuscar + "%'";
                ResultSet resultSet = statement.executeQuery(query);
   
                DefaultTableModel tableModel = buildTableModel(resultSet);
                table.setModel(tableModel); // Actualizar la tabla con los resultados de la búsqueda
   
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un apellido para realizar la búsqueda.");
        }
    }
    private void createTable() {
        try (Statement statement = connection.createStatement()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Agenda (" +
                    "ID INT AUTO_INCREMENT," +
                    "Nombre VARCHAR(100) NOT NULL," +
                    "Apellido VARCHAR(100) NOT NULL," +
                    "Email VARCHAR(100) NOT NULL," +
                    "Telefono VARCHAR(20) NOT NULL," +
                    "PRIMARY KEY (ID)" +
                    ")";
            statement.executeUpdate(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void obtenerTotalRegistros() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS total FROM Agenda");
            if (resultSet.next()) {
                totalRegistros = resultSet.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void mostrarRegistro(int numeroRegistro) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Agenda WHERE ID = " + numeroRegistro);
            if (resultSet.next()) {
                idField.setText(resultSet.getString("ID"));
                nombreField.setText(resultSet.getString("Nombre"));
                apellidoField.setText(resultSet.getString("Apellido"));
                emailField.setText(resultSet.getString("Email"));
                telefonoField.setText(resultSet.getString("Telefono"));
                registroLabel.setText("Registro: " + numeroRegistro + " de " + totalRegistros);
            } else {
                JOptionPane.showMessageDialog(this, "Registro no encontrado.");
                registroActual = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void mostrarTodosRegistros() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Agenda");


            // Crear una tabla para mostrar los registros
            DefaultTableModel tableModel = buildTableModel(resultSet);
            table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);


            // Mostrar la tabla en una ventana separada
            JFrame frame = new JFrame("Todos los Registros");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            frame.setSize(600, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void insertarNuevoRegistro() {
        try {
            String sql = "INSERT INTO Agenda (Nombre, Apellido, Email, Telefono) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, JOptionPane.showInputDialog("Ingrese el nombre:"));
            preparedStatement.setString(2, JOptionPane.showInputDialog("Ingrese el apellido:"));
            preparedStatement.setString(3, JOptionPane.showInputDialog("Ingrese el email:"));
            preparedStatement.setString(4, JOptionPane.showInputDialog("Ingrese el teléfono:"));


            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Nuevo registro insertado.");
            }
            // Actualizar el total de registros y mostrar el último registro insertado
            obtenerTotalRegistros();
            mostrarRegistro(totalRegistros);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void editarRegistro() {
        try {
            String sql = "UPDATE Agenda SET Nombre = ?, Apellido = ?, Email = ?, Telefono = ? WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombreField.getText());
            preparedStatement.setString(2, apellidoField.getText());
            preparedStatement.setString(3, emailField.getText());
            preparedStatement.setString(4, telefonoField.getText());
            preparedStatement.setInt(5, Integer.parseInt(idField.getText()));


            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Registro actualizado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar el registro.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();


        // Nombres de las columnas
        String[] columnNames = new String[metaData.getColumnCount()];
        for (int column = 1; column <= metaData.getColumnCount(); column++) {
            columnNames[column - 1] = metaData.getColumnName(column);
        }


        // Datos de la tabla
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        while (resultSet.next()) {
            Object[] rowData = new Object[metaData.getColumnCount()];
            for (int column = 1; column <= metaData.getColumnCount(); column++) {
                rowData[column - 1] = resultSet.getObject(column);
            }
            tableModel.addRow(rowData);
        }


        return tableModel;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AgendaApp();
            }
        });
    }
}

