package com.example.appsanitaria.Modelos;

public class Paciente {

     private String nombre;
     private String apellidos;
    private String dni;
    private String numsegsocial;
    private  String idpaciente;
    private String pass;

    public String getPass() {
        return pass;
    }

    public Paciente(String nombre, String apellidos, String dni, String numsegsocial, String idpaciente, String pass) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.numsegsocial = numsegsocial;
        this.idpaciente = idpaciente;
        this.pass = pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Paciente() {
    }

    public String getIdpaciente() {
        return idpaciente;
    }

    public Paciente(String nombre, String apellidos, String dni, String numsegsocial, String idpaciente) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.numsegsocial = numsegsocial;
        this.idpaciente = idpaciente;
    }

    public void setIdpaciente(String idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Paciente(String nombre, String apellidos, String dni, String numsegsocial) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.numsegsocial = numsegsocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumsegsocial() {
        return numsegsocial;
    }

    public void setNumsegsocial(String numsegsocial) {
        this.numsegsocial = numsegsocial;
    }
}
