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

public class ImplementsBD implements UserDAO {

    // Atributos
    private Connection con;
    private PreparedStatement stmt;

    // Los siguientes atributos se utilizan para recoger los valores del fich de
    // configuraci n
    private ResourceBundle configFile;
    private String driverBD;
    private String urlBD;
    private String userBD;
    private String passwordBD;

    // querys
    final String SQLLOGING = "SELECT * FROM usuario WHERE NOMBRE_USUARIO = ? AND CONTRASEÑA = ?";

    // Para la conexi n utilizamos un fichero de configuaraci n, config que
    // guardamos en el paquete control:
    public ImplementsBD() {
        this.configFile = ResourceBundle.getBundle("configClase");
        this.driverBD = this.configFile.getString("Driver");
        this.urlBD = this.configFile.getString("Conn");
        this.userBD = this.configFile.getString("DBUser");
        this.passwordBD = this.configFile.getString("DBPass");
    }

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
				String dni = resultado.getString("DNI"); // Nombre de usuario
				int edad = resultado.getInt("EDAD"); // Contraseña
				String email = resultado.getString("EMAIL"); //Email
                                
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