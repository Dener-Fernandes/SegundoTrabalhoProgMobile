package com.example.segundotrabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.segundotrabalho.activities.AdicionarTipoActivity;
import com.example.segundotrabalho.activities.EditarObjetoActivity;
import com.example.segundotrabalho.activities.EditarTipoActivity;
import com.example.segundotrabalho.activities.ListarObjetosActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonAdcionarTipo;
    Button buttonEditarTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirTelaAdicionarTIpo(View v) {
        Intent it_tela_adicionar_tipo = new Intent(this, AdicionarTipoActivity.class);
        startActivity(it_tela_adicionar_tipo);
    }

    public void abrirTelaEditarTipo(View v) {
        Intent it_tela_editar_tipo = new Intent(this, EditarTipoActivity.class);
        startActivity(it_tela_editar_tipo);
    }

    public void abrirTelaEditarObjeto(View v) {
        Intent it_tela_editar_objeto = new Intent(this, EditarObjetoActivity.class);
        startActivity(it_tela_editar_objeto);
    }

    public void abrirTelaListarObjetos(View v) {
        Intent it_tela_listar_objetos = new Intent(this, ListarObjetosActivity.class);
        startActivity(it_tela_listar_objetos);
    }

    public void sairApp(View v) {
        this.finish();
    }
}