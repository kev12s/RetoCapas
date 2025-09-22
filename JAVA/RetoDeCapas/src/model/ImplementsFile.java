/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2dami
 */
public class ImplementsFile implements UserDAO {

    File fichUser = new File("user.dat");

    @Override
    public User checkUser(User user) {
        boolean finArchivo= false;
        ObjectInputStream ois = null;
        if(!fichUser.exists()){
            addDataUser(fichUser);
        }

        try {	
	 ois = new ObjectInputStream(new FileInputStream(fichUser));
        while (!finArchivo) {
            try {
                User aux = (User) ois.readObject();
                System.out.println(aux.toString());
                if (aux.getNombre().equals(user.getNombre())  && aux.getContraseña().equals(user.getContraseña())) {
                    user.setDni(aux.getDni());
                    user.setEdad(aux.getEdad());
                    user.setEmail(aux.getEmail());
                    user.setNombre(aux.getNombre());
                }
            } catch (EOFException e) {
                finArchivo = true;
            }
        }
        ois.close();

    }
    catch(Exception e){
                            System.out.println("Fatal error");
                        }
return user;
}

public static void addDataUser(File fichUser) {
                User lucas= new User("lucasgonzalez", "Lucas!2025", "11224455K", 34, "lucas.g@correo.com");
                User marta = new User ("martamorales", "MartaM_2025", "66779900L", 27, "marta.morales@empresa.com");
                User jorge =new User ("jorgehernandez", "Jorge*2025", "44556677M", 31, "jorge.h@universidad.edu");
                User patricia= new User("patriciasantos", "Patri2025!", "22331144N", 23, "patricia.s@estudiante.edu");
                User adrian =new User ("adriangutierrez", "Adrian_25$", "88990011O", 39, "adrian.gutierrez@trabajo.com");
                User sandra= new User ("sandraruiz", "SandraR!2025", "55668822P", 29, "sandra.ruiz@personal.com");
                User fernando = new User ("fernandodiaz", "FerNando*25", "33442299Q", 42, "fernando.diaz@empresa.com");
                User cristina = new User ("cristinacastro", "CrisC@stro25", "77880033R", 21, "cristina.c@universidad.edu");
                User alejandro = new User ("alejandromendez", "AleM2025!", "99001122S", 36, "alejandro.mendez@correo.com");
                User veronica = new User ("veronicaparedes", "Vero_2025*", "12349988T", 25, "veronica.p@trabajo.com");
		try {
			ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(fichUser));
                        
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
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


    
    
    
    
}
