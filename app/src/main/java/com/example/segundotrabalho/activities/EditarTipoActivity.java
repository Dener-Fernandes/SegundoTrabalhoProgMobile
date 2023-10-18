package com.example.segundotrabalho.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.segundotrabalho.R;
import com.example.segundotrabalho.database.AppDatabase;
import com.example.segundotrabalho.model.Tipo;

import java.util.ArrayList;
import java.util.List;

public class EditarTipoActivity extends AppCompatActivity {

    AppDatabase db;

    ListView list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_tipo);

        list = findViewById(R.id.listViewTipos);

        db = AppDatabase.getAppDatabase(getApplicationContext());

        List<Tipo> tipos = db.tipoDao().getAll();

        List<String> tiposDescricao = new ArrayList<>();

        for (Tipo tipo : tipos) {
           tiposDescricao.add(tipo.tipo);
        }

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, tiposDescricao);
        list.setAdapter(adapter);
    }

    //NÃO ESTÁ FUNCIONANDO AINDA
    public void adicionarTipo(View v) {
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