package com.example.grupocommit.healthcontrol.entities;

import java.util.Date;

public class Usuario {

    private String usuarioId;
    private String usuarioNome;
    private String usuarioGenero;
    private String usuarioNascimento;
    private String usuarioAltura;
    private String usuarioPeso;
    private String usuarioEmail;


    //Construtor vazio
    public Usuario(){

    }

    //Construtor Cheio
    public Usuario(String usuarioId, String usuarioNome, String usuarioGenero, String usuarioNascimento, String usuarioAltura, String usuarioPeso,String usuarioEmail) {
        this.usuarioId = usuarioId;
        this.usuarioNome = usuarioNome;
        this.usuarioGenero = usuarioGenero;
        this.usuarioNascimento = usuarioNascimento;
        this.usuarioAltura = usuarioAltura;
        this.usuarioPeso = usuarioPeso;
        this.usuarioEmail = usuarioEmail;
    }



    //Getters and Setters


    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public void setUsuarioGenero(String usuarioGenero) {
        this.usuarioGenero = usuarioGenero;
    }

    public void setUsuarioNascimento(String usuarioNascimento) {
        this.usuarioNascimento = usuarioNascimento;
    }

    public void setUsuarioAltura(String usuarioAltura) {
        this.usuarioAltura = usuarioAltura;
    }

    public void setUsuarioPeso(String usuarioPeso) {
        this.usuarioPeso = usuarioPeso;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public String getUsuarioGenero() {
        return usuarioGenero;
    }

    public String getUsuarioNascimento() {
        return usuarioNascimento;
    }

    public String getUsuarioAltura() {
        return usuarioAltura;
    }

    public String getUsuarioPeso() {
        return usuarioPeso;
    }
}
