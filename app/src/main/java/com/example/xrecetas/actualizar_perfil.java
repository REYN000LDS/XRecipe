package com.example.xrecetas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class actualizar_perfil extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private StorageReference mStorage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_perfil);
        mStorage = FirebaseStorage.getInstance().getReference();
    }
    public void actualizarFoto(View v){
        Intent i = new Intent(this,actualizar_perfil.class);
        startActivity(i);
    }
    public void tomarFoto(View v){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager()) !=null){
            startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitman = (Bitmap) extras.get("data");
            ImageView imFoto = (ImageView) findViewById(R.id.ivFoto);
            imFoto.setImageBitmap(Bitmap.createScaledBitmap(imageBitman,500,500,false));
            StorageReference fotoRef = mStorage.child("images/fotoPerfil.jpg");
            //Arreglo de Bytes
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            //Convertir BitMap al formato y calidad deseada
            imageBitman.compress(Bitmap.CompressFormat.JPEG,100,baos);
            byte[] data1 = baos.toByteArray();
            //Subir foto a firebase
            UploadTask uploadTask = fotoRef.putBytes(data1);
        }
    }
}