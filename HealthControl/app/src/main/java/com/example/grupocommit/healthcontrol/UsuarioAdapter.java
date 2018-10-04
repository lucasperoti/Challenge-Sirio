package com.example.grupocommit.healthcontrol;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.grupocommit.healthcontrol.entities.Usuario;

import java.util.List;

public class UsuarioAdapter extends ArrayAdapter<Usuario>{

    private Activity context;
    private List<Usuario> usuarioList;

    public UsuarioAdapter(Activity context, List<Usuario> usuarioList){
        super(context, R.layout.activity_profile, usuarioList);
        this.context = context;
        this.usuarioList = usuarioList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();

        View item = inflater.inflate(R.layout.activity_profile, null, true);
        TextView txtViewName = (TextView) item.findViewById(R.id.txtProfNome);
        TextView txtViewEmail = (TextView) item.findViewById(R.id.txtProfEmail);
        TextView txtViewNascimento = (TextView) item.findViewById(R.id.txtProfNascimento);
        TextView txtViewPeso  = (TextView) item.findViewById(R.id.txtProfPeso);
        TextView txtViewAltura = (TextView) item.findViewById(R.id.txtProfAltura);

        Usuario usuario = usuarioList.get(position);

        txtViewName.setText(usuario.getUsuarioNome());
        txtViewEmail.setText(usuario.getUsuarioEmail());
        txtViewNascimento.setText(usuario.getUsuarioNascimento());

        return item;
    }
}
