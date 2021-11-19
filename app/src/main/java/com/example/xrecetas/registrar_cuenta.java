package com.example.xrecetas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class registrar_cuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cuenta);
    }
    public void registrar(View v){
        EditText etUsuario = (EditText) findViewById(R.id.idUsuario);
        String usuario = etUsuario.getText().toString();
        EditText etCorreo = (EditText) findViewById(R.id.idCorreoRegistrar);
        String correo = etCorreo.getText().toString();
        EditText etContra = (EditText) findViewById(R.id.idContraRegistrar);
        String contra = etContra.getText().toString();
        EditText etContra2 = (EditText) findViewById(R.id.idContraRegistrar2);
        String contra1 = etContra2.getText().toString();
        if (contra.equals(contra1)){
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Error en las credenciales", Toast.LENGTH_SHORT).show();
        }
    }
}