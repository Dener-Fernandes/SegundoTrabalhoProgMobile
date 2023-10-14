package com.example.segundotrabalho.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.segundotrabalho.R;

public class ListarObjetosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_objetos);
    }

    public void voltarButton(View v) {
        this.finish();
    }
}