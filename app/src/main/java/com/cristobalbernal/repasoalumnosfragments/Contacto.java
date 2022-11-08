package com.cristobalbernal.repasoalumnosfragments;

import java.io.Serializable;

public class Contacto implements Serializable {
    private final  int id;
    private final String nombre;
    private final String primerApellido;
    private final String segundoApellido;
    private final String direccion;
    private final String empresa;
    private final String fecha_nacimiento;
    private final String phone1;
    private final String phone2;
    private final String email;

    public Contacto(int id, String nombre, String primerApellido, String segundoApellido, String direccion, String empresa, String fecha_nacimiento, String phone1, String phone2, String email) {
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.direccion = direccion;
        this.empresa = empresa;
        this.fecha_nacimiento = fecha_nacimiento;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getEmail() {
        return email;
    }
}
