package com.example.grupocommit.healthcontrol.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.grupocommit.healthcontrol.R;
import com.example.grupocommit.healthcontrol.entities.Usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;

    EditText edtNome, edtNascimento, edtPeso, edtAltura;
    Button btnSalvar;
    Spinner spinnerGenres;

    DatabaseReference databaseUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        databaseUsuarios = FirebaseDatabase.getInstance().getReference("usuarios");

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtNascimento = (EditText) findViewById(R.id.edtNascimento);
        edtAltura = (EditText) findViewById(R.id.edtAltura);
        edtPeso = (EditText) findViewById(R.id.edtPeso);



        mAuth = FirebaseAuth.getInstance();

        btnSalvar = (Button) findViewById(R.id.btnSalvarUser);

        spinnerGenres = (Spinner) findViewById(R.id.spinnerGenres);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUsuario();
                Intent intent = new Intent(CadastroActivity.this, BaseActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addUsuario(){
        String name = edtNome.getText().toString().trim();
        String nascimento = edtNascimento.getText().toString().trim();
        String altura = edtAltura.getText().toString().trim();
        String peso = edtPeso.getText().toString().trim();
        String email = mAuth.getCurrentUser().getEmail();

        String genero = spinnerGenres.getSelectedItem().toString();

        if(!TextUtils.isEmpty(name)){
            String id = databaseUsuarios.push().getKey();

            Usuario usuario = new Usuario(id, name, genero, nascimento, peso, altura, email);

            databaseUsuarios.child(id).setValue(usuario);

            Toast.makeText(this, "Usuario adicionado.", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Você deve digitar um nome", Toast.LENGTH_LONG).show();
        }
    }
}
