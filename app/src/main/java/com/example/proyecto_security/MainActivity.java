package com.example.proyecto_security;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText email = (EditText) findViewById(R.id.txtEmail);
        EditText contraseña = (EditText) findViewById(R.id.txtContraseña);
        final Button registrar = (Button) findViewById(R.id.btRegistrar);
        Button entrar = (Button) findViewById(R.id.btEntrar);

registrar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(),Register.class);
        startActivity(intent);
    }
});
entrar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(),Home.class);
        startActivity(intent);
    }
});
    }


}
