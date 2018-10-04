package com.example.grupocommit.healthcontrol.activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.grupocommit.healthcontrol.R;
import com.example.grupocommit.healthcontrol.UsuarioAdapter;
import com.example.grupocommit.healthcontrol.entities.Usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private DatabaseReference dbUsuarios;
    private FirebaseAuth mAuth;

    private TextView txtProfNome;
    private TextView txtProfEmail;
    private TextView txtProfNascimento;
    private TextView txtProfPeso;
    private TextView txtProfAltura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();



        txtProfNome = (TextView) findViewById(R.id.txtProfNome);
        txtProfEmail = (TextView) findViewById(R.id.txtProfEmail);
        txtProfNascimento = (TextView) findViewById(R.id.txtProfNascimento);
        txtProfPeso = (TextView) findViewById(R.id.txtProfPeso);
        txtProfAltura = (TextView) findViewById(R.id.txtProfAltura);

        DatabaseReference mRef = dbUsuarios = FirebaseDatabase.getInstance().getReference("usuarios");
        Query query = mRef.orderByChild("usuarioEmail").equalTo(mAuth.getCurrentUser().getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot usuarioSnapshot : dataSnapshot.getChildren()){
                    Usuario usuario = usuarioSnapshot.getValue(Usuario.class);

                    Usuario u = usuarioSnapshot.getValue(Usuario.class);
                    Log.d("usuarioNome : ", u.getUsuarioNome());
                    Log.d("usuarioEmail :", u.getUsuarioEmail());
                    Log.d("usuarioNascimento :", u.getUsuarioNascimento());
                    Log.d("usuarioGenero :", u.getUsuarioGenero());

                    txtProfNome.setText(u.getUsuarioNome());
                    txtProfEmail.setText(u.getUsuarioEmail());
                    txtProfNascimento.setText(u.getUsuarioNascimento());
                    txtProfPeso.setText(u.getUsuarioPeso());
                    txtProfAltura.setText(u.getUsuarioAltura());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
