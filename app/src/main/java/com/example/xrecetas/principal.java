package com.example.xrecetas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        NavigationView nav = (NavigationView) findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.linkActualizarPerfil){
                    Toast.makeText(getApplicationContext(), "Vas a actualizar a ", Toast.LENGTH_SHORT).show();
                }else if (id==R.id.op1){
                    Toast.makeText(getApplicationContext(), "Vas al historial de recetas", Toast.LENGTH_SHORT).show();
                }else if (id==R.id.op2){
                    Toast.makeText(getApplicationContext(), "Vas a los centros médicos más cercanos", Toast.LENGTH_SHORT).show();
                }else if (id==R.id.op3){
                    Toast.makeText(getApplicationContext(), "Vas a las farmacias cercanas", Toast.LENGTH_SHORT).show();
                }else if (id==R.id.op4){
                    Toast.makeText(getApplicationContext(), "Vas a los cercanos", Toast.LENGTH_SHORT).show();
                }else if (id==R.id.op5){
                    Toast.makeText(getApplicationContext(), "Vas a los términos y condiciones", Toast.LENGTH_SHORT).show();
                }else if (id==R.id.op6){
                    Toast.makeText(getApplicationContext(), "Cerraste Sesión", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        DrawerLayout dl = (DrawerLayout) findViewById(R.id.drawerlayout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                dl,
                R.string.abrir_drawer,
                R.string.cerrar_drawer
        );
        dl.addDrawerListener(toggle);
        toggle.syncState();
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dl.isDrawerOpen(GravityCompat.START)){
                    dl.closeDrawer(GravityCompat.START);
                }
                else{
                    dl.openDrawer((int) Gravity.START);
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.linkActualizarPerfil){
            Intent i = new Intent(this,actualizar_perfil.class);
            startActivity(i);
        }else if (id==R.id.op1){
            Intent i = new Intent(this,historial_recetas.class);
            startActivity(i);
        } else if (id==R.id.op2){
            Intent i = new Intent(this,centros_medicos_cercanos.class);
            startActivity(i);
        }else if (id==R.id.op3){
            Intent i = new Intent(this,farmacias_cercanas.class);
            startActivity(i);
        }else if (id==R.id.op4){
            Intent i = new Intent(this,cercanos.class);
            startActivity(i);
        }else if (id==R.id.op5){
            Intent i = new Intent(this,terminos_condiciones.class);
            startActivity(i);
        }else if (id==R.id.op6){
            Intent i = new Intent(this,principal.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

}