package com.example.loggincontrol.customer;

import javax.persistence.*;


//Esta clase sirve para representar los valores que tendra la tabla Customer
//Incluimos los Getters y setters y los constructores

@Entity
@Table(name ="customer")
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Column(nullable = false,length = 20)
    private String password;

    @Column(nullable = false,length = 50)
    private String nombre;

    public Customer(){

    }

    //construction companies
    public Customer(String email, String password, String nombre) {
        super();
        this.email = email;
        this.password = password;
        this.nombre = nombre;
    }

    //GETTER AND SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
