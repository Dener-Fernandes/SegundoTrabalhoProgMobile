package com.example.segundotrabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AdicionarTipo extends AppCompatActivity {
    AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tipo);
    }

    public void salvarTipo(View v) {
        String tipoValue, descricaoValue;

        int tipoId;

        EditText tipoText = (EditText)findViewById(R.id.textTipoValueId);
        EditText descricaoText = (EditText)findViewById(R.id.textDescricaoValueId);

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