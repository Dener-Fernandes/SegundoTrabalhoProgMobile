package com.example.segundotrabalho.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.segundotrabalho.R;
import com.example.segundotrabalho.database.AppDatabase;
import com.example.segundotrabalho.model.Tipo;

import java.util.List;

public class EditarObjetoActivity extends AppCompatActivity {

    AppDatabase db;
    Spinner spinner;
   // ListView list;
   // ObjetoAdapter adapter;
   // EditText tipoText, descricaoText;
   // private TextView errorText;
   // List<Objeto> objetos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_objeto);

        db = AppDatabase.getAppDatabase(getApplicationContext());
        spinner = findViewById(R.id.spinnerTipo);
        populeSpinner();

        /*
        //adicionar adapter
        objetos = db.objetoDao().getAll();
        adapter = new ObjetoAdapter(this, objetos);
        list.setAdapter(adapter);
        */

    }
    // Função para popular o Spinner com os tipos disponíveis
    private void populeSpinner() {
        // Obtém a lista de tipos do banco de dados
        List<Tipo> tipos = db.tipoDao().getAll(); // Substitua isso pela maneira correta de obter os tipos

        if (!tipos.isEmpty()) {
            // Crie um ArrayAdapter para o Spinner usando os tipos obtidos do banco de dados
            ArrayAdapter<Tipo> adapter = new ArrayAdapter<>(this, R.layout.spinner_tipos, tipos);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // Defina o adaptador para o Spinner
            spinner.setAdapter(adapter);
        } else {
            // Se não houver tipos disponíveis, você pode mostrar uma mensagem ao usuário ou tomar a ação apropriada.
        }
    }



    //Fazer para salvar objeto, posteriormente adicionarei o adapter aí
    public void salvarTipo(View v) {
        String tipoValue, descricaoValue;

        //int tipoId;

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