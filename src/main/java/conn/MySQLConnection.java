package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author crist
 */
public class MySQLConnection {

    // Configura tus credenciales y detalles de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "0402";
    private static final String SCHEMA = "municipio";

    private static Connection connection;
    private static Statement statement;

    public void connectSchema() {
        try {
            String createSchemaSQL = "CREATE SCHEMA IF NOT EXISTS " + this.SCHEMA;
            statement.executeUpdate(createSchemaSQL);

            System.out.println("Se creo correctamente el schema: " + this.SCHEMA);
        } catch (SQLException e) {
            System.err.print("Error al crear el schema: " + e.getMessage());
        }
    }

    public void useSchema() {
        try {
            String createSchemaSQL = "USE " + this.SCHEMA;
            statement.executeUpdate(createSchemaSQL);

            System.out.println("El Schema usado es: " + this.SCHEMA);
        } catch (SQLException e) {
            System.err.print("Error al usar el schema: " + e.getMessage());
        }
    }

    public void showSchemas() {
        try {
            String createSchemaSQL = "SHOW SCHEMAS";
            ResultSet resultSet = statement.executeQuery(createSchemaSQL);

            System.out.println("Los Schema encontrados, son los siguientes: ");
            while (resultSet.next()) {
                String tableName = resultSet.getString(1); // El índice 1 representa la primera columna
                System.out.println("Schema: " + tableName);
            }
        } catch (SQLException e) {
            System.err.print("Error al listar los schema's: " + e.getMessage());
        }
    }

    public void showTables() {
        try {
            String showTables = "SHOW TABLES";
            ResultSet resultSet = statement.executeQuery(showTables);

            System.out.println("Las tablas que tienen son: ");
            while (resultSet.next()) {
                String tableName = resultSet.getString(1); // El índice 1 representa la primera columna
                System.out.println("Tabla: " + tableName);
            }
        } catch (SQLException e) {
            System.err.print("Error al listar los schema's: " + e.getMessage());
        }
    }

    // Método para establecer la conexión a la base de datos
    public void openConnection() throws SQLException {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Carga el controlador JDBC
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                statement = connection.createStatement();
                System.out.println("Conexión exitosa a la base de datos MySQL.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    // Método para cerrar la conexión
    public void closeConnection() throws SQLException {
        try {
            if (statement != null && !statement.isClosed()) {
                connection.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
