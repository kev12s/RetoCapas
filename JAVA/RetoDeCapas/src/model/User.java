/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 2dami
 */
public class User {
    private String nombre;
    private String contraseña;
    private String dni;
    private int edad;
    private String email;
    
    public User(String nombre, String dni, int edad, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.email = email;
    }
     public User() {
        this.nombre = "";
        this.contraseña = "";
        this.dni = "";
        this.edad = 0;
        this.email = "";
    }
     
    public User(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }
    public String getNombre() {
        return nombre;
    }
    public String getContraseña() {
        return contraseña;
    }

    public String getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "nombre=" + nombre + ", contrase\u00f1a=" + contraseña + ", dni=" + dni + ", edad=" + edad + ", email=" + email + '}';
    }
     
    
}
