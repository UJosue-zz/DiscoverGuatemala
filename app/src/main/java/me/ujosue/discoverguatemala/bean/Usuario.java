package me.ujosue.discoverguatemala.bean;

import com.orm.SugarRecord;

/**
 * Created by HP240 on 20/05/2016.
 */
public class Usuario extends SugarRecord {
    int id_Usuario;
    String nombre;
    String nacionalidad;
    String correo;
    String nick;
    String foto;
    String token;
    String exp;
    int id_Rol;

    public Usuario() {
    }

    public Usuario(int id_Usuario, String nombre, String nacionalidad, String correo, String nick, String foto, String token, String exp, int id_Rol) {
        this.id_Usuario = id_Usuario;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.correo = correo;
        this.nick = nick;
        this.foto = foto;
        this.token = token;
        this.exp = exp;
        this.id_Rol = id_Rol;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public int getId_Rol() {
        return id_Rol;
    }

    public void setId_Rol(int id_Rol) {
        this.id_Rol = id_Rol;
    }
}
