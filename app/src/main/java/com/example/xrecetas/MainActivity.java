package com.example.xrecetas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void login(View v){
        Intent i = new Intent(this,principal.class);
        startActivity(i);
    }
    public void registrarCuenta(View v){
        Intent i = new Intent(this,registrar_cuenta.class);
        startActivity(i);
    }
}