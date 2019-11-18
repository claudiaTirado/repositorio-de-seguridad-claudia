package com.example.proyecto_security;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAnalytics mFirebaseAnalytics;
    private EditText email2;
    private EditText contraseña2;
    private EditText confirmacionCon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        email2 =(EditText) findViewById(R.id.txtEmail2);
        contraseña2 = (EditText) findViewById(R.id.txtContraseña2);
        confirmacionCon = (EditText) findViewById(R.id.txtConfirmarCon);

        Button login =(Button) findViewById(R.id.btLogin);
        Button registrar2 = (Button) findViewById(R.id.btRegistrar2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        registrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
               // Toast.makeText(getApplicationContext(),"boton",Toast.LENGTH_LONG).show();
               Intent intent = new Intent(getApplicationContext(),MainActivity.class);
               startActivity(intent);
            }
        });
    }

    private void registrarUsuario(){
        String correo = email2.getText().toString().trim();
        String contraseña = contraseña2.getText().toString().trim();
        String confirmar = confirmacionCon.getText().toString().trim();

        if(TextUtils.isEmpty(correo)){
            Toast.makeText(this,"campo email vacio ",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(contraseña)){
            Toast.makeText(this,"campo ontraseña vacio ",Toast.LENGTH_LONG).show();
            return;
        }



        FirebaseUser currentUser = mAuth.getCurrentUser();

       // if (currentUser != null) {
            mAuth.createUserWithEmailAndPassword(correo, contraseña)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(Register.this, "registro completo: " + email2.getText(), Toast.LENGTH_LONG).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                            } else {

                                Toast.makeText(Register.this, "No se pudo registrar ", Toast.LENGTH_LONG).show();
                            }

                        }
                    });
       // }


    }
}
