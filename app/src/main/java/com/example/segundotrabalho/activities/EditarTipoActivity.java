package com.example.segundotrabalho.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.segundotrabalho.R;

public class EditarTipoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_tipo);
    }
    public void voltarButton(View v) {
        this.finish();
    }
}