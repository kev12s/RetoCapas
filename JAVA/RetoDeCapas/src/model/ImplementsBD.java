/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Implementación de la interfaz {@link UserDAO} que gestiona el acceso a datos
 * de usuarios mediante una base de datos.
 * <p>
 * Esta clase se encarga de abrir la conexión a la base de datos utilizando 
 * parámetros definidos en un fichero de configuración y de verificar la 
 * existencia de un usuario en la base de datos.
 * </p>
 * 
 * @author kevin
 */
public class ImplementsBD implements UserDAO {

    // Atributos
    private Connection con;
    private PreparedStatement stmt;

    // Los siguientes atributos se utilizan para recoger los valores del fichero de
    // configuración
    private ResourceBundle configFile;
    private String driverBD;
    private String urlBD;
    private String userBD;
    private String passwordBD;

    // Querys
    final String SQLLOGING = "SELECT * FROM usuario WHERE NOMBRE_USUARIO = ? AND CONTRASEÑA = ?";

    /**
     * Constructor de {@link ImplementsBD}.
     * <p>
     * Inicializa los parámetros de conexión a la base de datos leyendo los 
     * valores del fichero de configuración {@code configClase.properties}.
     * </p>
     */
    public ImplementsBD() {
        this.configFile = ResourceBundle.getBundle("configClase");
        this.driverBD = this.configFile.getString("Driver");
        this.urlBD = this.configFile.getString("Conn");
        this.userBD = this.configFile.getString("DBUser");
        this.passwordBD = this.configFile.getString("DBPass");
    }

    /**
     * Abre la conexión a la base de datos utilizando los parámetros configurados.
     * <p>
     * En caso de error, imprime un mensaje en consola y la traza de la excepción.
     * </p>
     */
    private void openConnection() {
        try {
            con = DriverManager.getConnection(urlBD, this.userBD, this.passwordBD);
        } catch (SQLException e) {
            System.out.println("Error al intentar abrir la BD");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifica si un usuario existe en la base de datos.
     * <p>
     * Recibe un objeto {@link User} con el nombre y la contraseña, y si el usuario 
     * existe en la base de datos devuelve un nuevo objeto {@link User} con todos 
     * los datos obtenidos de la tabla. Si no existe, devuelve {@code null}.
     * </p>
     * 
     * @param user Objeto {@link User} con el nombre y contraseña a verificar.
     * @return Un objeto {@link User} con los datos completos si el usuario existe,
     *         o {@code null} si no se encuentra.
     */
    public User checkUser(User user) {
        User foundUser = null; // Inicializamos como null
        this.openConnection(); // Abrimos la conexión a la base de datos

        try {
            // Preparamos la consulta SQL
            stmt = con.prepareStatement(SQLLOGING);
            stmt.setString(1, user.getNombre()); // Establecemos el nombre de usuario
            stmt.setString(2, user.getContraseña()); // Establecemos la contraseña
            ResultSet resultado = stmt.executeQuery(); // Ejecutamos la consulta

            // Si hay un resultado, el usuario existe
            if (resultado.next()) {
                // Obtenemos los datos del usuario de la base de datos	
                String dni = resultado.getString("DNI"); 
                int edad = resultado.getInt("EDAD"); 
                String email = resultado.getString("EMAIL"); 

                // Creamos un nuevo objeto USER con los datos obtenidos
                foundUser = new User(user.getNombre(), dni, edad, email);
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al verificar credenciales: " + e.getMessage());
        }
        return foundUser;
    }

}
