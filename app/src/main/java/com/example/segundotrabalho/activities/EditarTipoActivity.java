package com.example.segundotrabalho.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.segundotrabalho.R;
import com.example.segundotrabalho.adapters.TipoAdapter;
import com.example.segundotrabalho.database.AppDatabase;
import com.example.segundotrabalho.model.Tipo;

import java.util.List;

public class EditarTipoActivity extends AppCompatActivity {

    AppDatabase db;
    ListView list;
    TipoAdapter adapter;
    EditText tipoText, descricaoText;
    private TextView errorText;
    List<Tipo> tipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_tipo);

        list = findViewById(R.id.listViewTipos);
        db = AppDatabase.getAppDatabase(getApplicationContext());

        tipoText = findViewById(R.id.textTipoValueId);
        descricaoText = findViewById(R.id.textDescricaoValueId);
        errorText = findViewById(R.id.textViewError);

        tipos = db.tipoDao().getAll();
        adapter = new TipoAdapter(this, tipos);
        list.setAdapter(adapter);

    }

    public void adicionarTipo(View v) {
        String tipoValue = tipoText.getText().toString();
        String descricaoValue = descricaoText.getText().toString();

        if (tipoValue.isEmpty() || descricaoValue.isEmpty()) {
            // Campos vazios, exiba a mensagem de erro
            errorText.setVisibility(View.VISIBLE);
        } else {

            Tipo tipo = new Tipo(tipoValue, descricaoValue);

            long resultado = db.tipoDao().insertTipo(tipo);
            Log.d("Inserção", "  " + tipo.getTipo());

            if (resultado >= 0) {
                tipo.setTipoId(resultado); // Atualiza o ID do objeto Tipo com o valor gerado
                adapter.addTipo(tipo); // Adiciona o novo tipo à lista
                tipoText.setText(""); // Limpa o campo de tipo
                descricaoText.setText(""); // Limpa o campo de descrição
                errorText.setVisibility(View.GONE);
            } else {
                Log.e("Inserção", "Falha na inserção");
            }
        }
    }

    public void voltarButton(View v) {
        finish();
    }
}