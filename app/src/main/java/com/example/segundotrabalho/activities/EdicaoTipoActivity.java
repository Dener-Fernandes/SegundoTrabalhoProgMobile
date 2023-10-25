package com.example.segundotrabalho.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.segundotrabalho.R;
import com.example.segundotrabalho.database.AppDatabase;
import com.example.segundotrabalho.model.Tipo;

public class EdicaoTipoActivity extends AppCompatActivity {

    AppDatabase db;

    EditText tipoEdicaoText, descricaoEdicaoText;

    int tipoId;

    String tipo, descricaoTipo;

    private TextView errorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao_tipo);

        db = AppDatabase.getAppDatabase(getApplicationContext());

        tipoEdicaoText = findViewById(R.id.tipoEdicaoText);
        descricaoEdicaoText = findViewById(R.id.descricaoEdicaoText);

        tipoId = getIntent().getIntExtra("tipoId", -1);
        tipo = getIntent().getStringExtra("tipo");
        descricaoTipo = getIntent().getStringExtra("descricao");

        errorText = findViewById(R.id.textViewErrorEdicaoTipo);

        tipoEdicaoText.setText(tipo);
        descricaoEdicaoText.setText(descricaoTipo);
    }

    public void atualizarTipo(View v) {
        String novoTipo, novaDescricao;

        novoTipo = tipoEdicaoText.getText().toString();
        novaDescricao = descricaoEdicaoText.getText().toString();

        if (novoTipo.isEmpty() || novaDescricao.isEmpty()) {
            errorText.setVisibility(View.VISIBLE);
        } else {
            Tipo tipo = new Tipo(novoTipo, novaDescricao);
            tipo.tipoId = tipoId;
            db.tipoDao().updateTipo(tipo);

            setResult(EditarTipoActivity.RESULT_SUCESSO_EDICAO_TIPO);
            finish();
        }
    }

    public void voltarButton(View v) {
        this.finish();
    }
}