package com.example.loggincontrol.admin;

//Importamos las funciones que usaremos
import com.example.loggincontrol.admin.User;
import org.springframework.data.repository.CrudRepository;

//Extendemos de CrudRepository para usar las funcionalidades
//Luego llamamos la clase de donde queremos traer nuestras variable
//en este caso las llamamos de Customer.Class
public interface UserRepository extends CrudRepository<User, Integer>{

    public User findByEmail(String email);

}
