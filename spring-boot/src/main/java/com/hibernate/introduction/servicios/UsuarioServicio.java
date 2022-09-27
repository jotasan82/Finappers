package com.hibernate.introduction.servicios;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.introduction.modelo.Usuario;

public class UsuarioServicio {
    // ATRIBUTOS
    SessionFactory factory;

    public UsuarioServicio(){
        // Crear objeto fablicante de sesiones
        factory = new Configuration().configure("cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
    }

    public Session createSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    public List<Usuario> getList() throws Exception {
        Session session = createSession();
        List<Usuario> usuarios = session.createQuery("from usuario", Usuario.class).list();
        session.close();
        return usuarios;
    }

    public Usuario readById(String correo) throws Exception {
        Session session = createSession();
        Usuario usuario = session.find(Usuario.class, correo);
        session.close();
        return usuario;
    }

    public List<Usuario> getByLastname(String nombre, String apellido) throws Exception {
        Session session = createSession();
        List<Usuario> objUsuarios = session
                .createQuery("from usuario where nombreUsuario = :n and apellidoUsuario = :ap", Usuario.class)
                .setParameter("n", nombre).setParameter("ap", apellido).list();
        session.close();
        return objUsuarios;
    }

    public String create(Usuario usuario) {
        String message = "";
        Session session = createSession();
        try {
            session.persist(usuario);
            session.getTransaction().commit();
            message = "Usuario creado con éxito";
        } catch (Exception e) {
            message = e.getMessage();
        }
        session.close();
        return message;
    }

    public void update(Usuario usuario) throws Exception {
        Session session = createSession();
        // Realizar Actualizacion en la DB
        session.merge(usuario);
        session.getTransaction().commit();
        session.close();
    }

    public String delete(String correo) {
        Session session = createSession();
        Usuario usuario = session.find(Usuario.class, correo);
        deleteService(usuario);
        return "Usuario eliminado con éxito";
    }

    public List<String> objToString(List<Usuario> objUsuarios) {
        List<String> usuarios = new ArrayList<>();
        for (int i = 0; i < objUsuarios.size(); i++) {
            usuarios.add(objUsuarios.get(i).toString());
        }
        return usuarios;
    }

    public void deleteService(Usuario usuario) {
        Session session = createSession();
        // Eliminar
        session.remove(usuario);
        session.getTransaction().commit();
    }
}
