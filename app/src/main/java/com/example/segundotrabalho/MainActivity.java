package com.example.segundotrabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonAdcionarTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirTelaAdicionarTIpo(View v) {
        Intent it_tela_adicionar_tipo = new Intent(this, AdicionarTipo.class);
        startActivity(it_tela_adicionar_tipo);
    }
}