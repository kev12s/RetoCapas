/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 * Clase que representa un usuario del sistema.
 * <p>
 * Implementa {@link Serializable} para permitir la serialización de sus objetos,
 * lo que facilita su almacenamiento en archivos o transferencia a través de la red.
 * </p>
 * <p>
 * Contiene información básica del usuario como nombre, contraseña, DNI, edad y correo electrónico.
 * </p>
 * 
 * @author 2dami
 */
public class User implements Serializable {

    /** Nombre del usuario */
    private String nombre;

    /** Contraseña del usuario */
    private String contraseña;

    /** DNI del usuario */
    private String dni;

    /** Edad del usuario */
    private int edad;

    /** Correo electrónico del usuario */
    private String email;

    /**
     * Constructor que inicializa un usuario con nombre, DNI, edad y email.
     * 
     * @param nombre Nombre del usuario
     * @param dni DNI del usuario
     * @param edad Edad del usuario
     * @param email Correo electrónico del usuario
     */
    public User(String nombre, String dni, int edad, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.email = email;
    }

    /**
     * Constructor que inicializa un usuario con todos sus atributos.
     * 
     * @param nombre Nombre del usuario
     * @param contraseña Contraseña del usuario
     * @param dni DNI del usuario
     * @param edad Edad del usuario
     * @param email Correo electrónico del usuario
     */
    public User(String nombre, String contraseña, String dni, int edad, String email) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.dni = dni;
        this.edad = edad;
        this.email = email;
    }

    /**
     * Constructor vacío que inicializa un usuario con valores por defecto.
     */
    public User() {
        this.nombre = "";
        this.contraseña = "";
        this.dni = "";
        this.edad = 0;
        this.email = "";
    }

    /**
     * Constructor que inicializa un usuario con nombre y contraseña únicamente.
     * 
     * @param nombre Nombre del usuario
     * @param contraseña Contraseña del usuario
     */
    public User(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    /** @return Nombre del usuario */
    public String getNombre() {
        return nombre;
    }

    /** @return Contraseña del usuario */
    public String getContraseña() {
        return contraseña;
    }

    /** @return DNI del usuario */
    public String getDni() {
        return dni;
    }

    /** @return Edad del usuario */
    public int getEdad() {
        return edad;
    }

    /** @return Correo electrónico del usuario */
    public String getEmail() {
        return email;
    }

    /** @param nombre Establece el nombre del usuario */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** @param contraseña Establece la contraseña del usuario */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /** @param dni Establece el DNI del usuario */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /** @param edad Establece la edad del usuario */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /** @param email Establece el correo electrónico del usuario */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve una representación en cadena de los atributos del usuario.
     * 
     * @return String con los datos del usuario
     */
    @Override
    public String toString() {
        return "User{" + "nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ", email=" + email + '}';
    }
}
