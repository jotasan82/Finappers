package com.hibernate.introduction.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.introduction.modelo.Usuario;
import com.hibernate.introduction.servicios.UsuarioServicio;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

    private UsuarioServicio servicio;

    public UsuarioControlador() {
        this.servicio = new UsuarioServicio();
    }

    @GetMapping
    @CrossOrigin("*")
    public List<Usuario> getList(){
        List<Usuario> usuarios = new ArrayList<>();
        try {
            usuarios = servicio.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @GetMapping("/{correo}")
    @CrossOrigin("*")
    public Usuario readById(@PathVariable(name = "correo") String correo){
        Usuario usuario = new Usuario();
        try {
            usuario = servicio.readById(correo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @GetMapping("/fullname")
    @CrossOrigin("*")
    public List<Usuario> getByLastname(@RequestParam String nombre, @RequestParam String apellido){
        List<Usuario> usuarios = new ArrayList<>();
        try {
            usuarios = servicio.getByLastname(nombre, apellido);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @PostMapping
    @CrossOrigin("*")
    public String create(@RequestBody Usuario usuario){
        return servicio.create(usuario);
    }

    @PutMapping
    @CrossOrigin("*")
    public String update(@RequestBody Usuario usuario){
        String message = "";
        try {
            servicio.update(usuario);
            message = "Usuario actualizado con éxito";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    @DeleteMapping("/{correo}")
    @CrossOrigin("*")
    public String delete(@PathVariable(name = "correo") String correo) {
        return servicio.delete(correo);
    }
}