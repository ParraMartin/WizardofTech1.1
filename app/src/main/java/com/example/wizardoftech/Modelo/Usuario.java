package com.example.wizardoftech.Modelo;

public class Usuario {

    private Integer id;
    private String nombre;

    private String correo;
    private Integer password;





    public Usuario() {

    }

    public Usuario( String nombre, String correo, Integer password) {

        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getId() {
        return password;
    }

    public void setId(Integer password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
