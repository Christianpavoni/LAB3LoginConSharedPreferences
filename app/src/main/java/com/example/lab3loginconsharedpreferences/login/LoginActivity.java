package com.example.lab3loginconsharedpreferences.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.lab3loginconsharedpreferences.R;
import com.example.lab3loginconsharedpreferences.registro.RegistroActivity;

public class LoginActivity extends AppCompatActivity {

    private LoginActivityViewModel vm;
    private Button btLogin, btRegistro;
    private EditText etEmail,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inicializar();
    }
    public void inicializar(){

        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginActivityViewModel.class);

        btLogin=findViewById(R.id.btLogin);
        btRegistro=findViewById(R.id.btRegistro);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);

        vm.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
            }
        });


        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vm.login(etEmail.getText().toString(),etPassword.getText().toString());

            }
        });

        btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vm.accesoRegistro();

            }
        });




    }
}