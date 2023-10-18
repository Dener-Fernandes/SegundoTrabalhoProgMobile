package com.example.segundotrabalho.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.segundotrabalho.R;
import com.example.segundotrabalho.model.Tipo;
import com.example.segundotrabalho.database.AppDatabase;

public class AdicionarTipoActivity extends AppCompatActivity {
    AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tipo);
    }

    public void salvarTipo(View v) {
        String tipoValue, descricaoValue;

        int tipoId;

        EditText tipoText = (EditText)findViewById(R.id.textTipo);
        EditText descricaoText = (EditText)findViewById(R.id.textDescricao);

        tipoValue = tipoText.getText().toString();
        descricaoValue = descricaoText.getText().toString();

        Tipo tipo = new Tipo(tipoValue, descricaoValue);

        db = AppDatabase.getAppDatabase(getApplicationContext());

        long resultado = db.tipoDao().insertTipo(tipo);

        if (resultado >= 0) {
            Log.d("Inserção", "Inserção bem-sucedida. ID do objeto inserido: " + resultado);
        }
        else {
            Log.e("Inserção", "Falha na inserção");
        }

    }

    public void voltarButton(View v) {
        this.finish();
    }
}