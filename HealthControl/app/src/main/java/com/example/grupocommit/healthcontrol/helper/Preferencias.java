package com.example.grupocommit.healthcontrol.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencias {

    private Context context;
    private SharedPreferences preferences;
    private String NOME_ARQUIVO = "healthcontrol.preferencias";
    private int MODE =0;
    private SharedPreferences.Editor editor;

    private final String CHAVE_ID = "identificarUsuarioLogado";
    private final String CHAVE_NOME = "nomeUsuarioLogado";

    public Preferencias(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, MODE);

        editor = preferences.edit();
    }

    public void salvarUsuarioPreferencias(String identificadorUsuario, String nomeUsuario){
        editor.putString(CHAVE_ID, identificadorUsuario);
        editor.putString(CHAVE_NOME, nomeUsuario);
        editor.commit();
    }

    public String getIdentificador(){
        return  preferences.getString(CHAVE_ID, null);
    }

    public String getNome(){
        return preferences.getString(CHAVE_NOME, null);
    }
}
