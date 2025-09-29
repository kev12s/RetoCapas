/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Implementación de la interfaz {@link UserDAO} que gestiona el acceso a datos
 * de usuarios mediante almacenamiento en archivos.
 * <p>
 * Esta clase se encarga de verificar usuarios a partir de un fichero 
 * {@code user.dat}. Si el fichero no existe, crea un conjunto inicial de usuarios.
 * </p>
 * 
 * @author 2dami
 */
public class ImplementsFile implements UserDAO {

    /** Archivo donde se almacenan los usuarios */
    File fichUser = new File("user.dat");

    /**
     * Verifica si un usuario existe en el archivo.
     * <p>
     * Si el archivo no existe, se inicializa con un conjunto de usuarios
     * predeterminados. Luego recorre el archivo buscando un usuario que coincida
     * con el nombre y la contraseña proporcionados. Si lo encuentra, se actualizan
     * los datos del objeto {@link User} recibido.
     * </p>
     * 
     * @param user Objeto {@link User} con el nombre y contraseña a verificar.
     * @return El mismo objeto {@link User} con los datos completos si el usuario existe.
     */
    @Override
public User checkUser(User user) {
    boolean finArchivo = false;
    ObjectInputStream ois = null;
    User foundUser = null; // Usar una variable separada
    
    if (!fichUser.exists()) {
        addDataUser(fichUser);
    }

    try {
        ois = new ObjectInputStream(new FileInputStream(fichUser));
        while (!finArchivo && foundUser == null) { // Salir cuando encontremos un usuario
            try {
                User aux = (User) ois.readObject();
                
                // Verificar si las credenciales coinciden
                if (aux.getNombre().equals(user.getNombre()) && aux.getContraseña().equals(user.getContraseña())) {
                    // Encontramos el usuario, guardamos sus datos
                    foundUser = new User(aux.getNombre(), aux.getContraseña(), aux.getDni(), aux.getEdad(), aux.getEmail());
                }
            } catch (EOFException e) {
                finArchivo = true;
            }
        }
        ois.close();
    } catch (Exception e) {
        System.out.println("Fatal error: " + e.getMessage());
        e.printStackTrace();
    }
    
    return foundUser; // Retornar el usuario encontrado o null
}

    /**
     * Inicializa el archivo de usuarios con un conjunto predeterminado de objetos {@link User}.
     * <p>
     * Crea varios usuarios de ejemplo y los almacena en {@code fichUser} utilizando
     * {@link ObjectOutputStream}.
     * </p>
     * 
     * @param fichUser Archivo donde se guardarán los usuarios.
     */
    public static void addDataUser(File fichUser) {
        User lucas = new User("lucasgonzalez", "Lucas!2025", "11224455K", 34, "lucas.g@correo.com");
        User marta = new User("martamorales", "MartaM_2025", "66779900L", 27, "marta.morales@empresa.com");
        User jorge = new User("jorgehernandez", "Jorge*2025", "44556677M", 31, "jorge.h@universidad.edu");
        User patricia = new User("patriciasantos", "Patri2025!", "22331144N", 23, "patricia.s@estudiante.edu");
        User adrian = new User("adriangutierrez", "Adrian_25$", "88990011O", 39, "adrian.gutierrez@trabajo.com");
        User sandra = new User("sandraruiz", "SandraR!2025", "55668822P", 29, "sandra.ruiz@personal.com");
        User fernando = new User("fernandodiaz", "FerNando*25", "33442299Q", 42, "fernando.diaz@empresa.com");
        User cristina = new User("cristinacastro", "CrisC@stro25", "77880033R", 21, "cristina.c@universidad.edu");
        User alejandro = new User("alejandromendez", "AleM2025!", "99001122S", 36, "alejandro.mendez@correo.com");
        User veronica = new User("veronicaparedes", "Vero_2025*", "12349988T", 25, "veronica.p@trabajo.com");

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichUser));

            oos.writeObject(lucas);
            oos.writeObject(marta);
            oos.writeObject(jorge);
            oos.writeObject(patricia);
            oos.writeObject(adrian);
            oos.writeObject(sandra);
            oos.writeObject(fernando);
            oos.writeObject(cristina);
            oos.writeObject(alejandro);
            oos.writeObject(veronica);

            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
