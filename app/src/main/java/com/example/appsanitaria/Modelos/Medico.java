package com.example.appsanitaria.Modelos;

public class Medico {

    private String nombre;
    private String apellidos;
    private String numcolegiado;
    private String dni;
    private String idmedico;
    private  String pass;



    public Medico() {
    }

    public Medico(String nombre, String apellidos, String numcolegiado, String dni, String idmedico, String pass) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numcolegiado = numcolegiado;
        this.dni = dni;
        this.idmedico = idmedico;
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Medico(String nombre, String apellidos, String numcolegiado, String dni, String idmedico) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numcolegiado = numcolegiado;
        this.dni = dni;
        this.idmedico = idmedico;
    }

    public String getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(String idmedico) {
        this.idmedico = idmedico;
    }

    public Medico(String nombre, String apellidos, String numcolegiado, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numcolegiado = numcolegiado;
        this.dni = dni;
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

    public String getNumcolegiado() {
        return numcolegiado;
    }

    public void setNumcolegiado(String numcolegiado) {
        this.numcolegiado = numcolegiado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
