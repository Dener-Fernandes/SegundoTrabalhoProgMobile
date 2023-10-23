package com.example.segundotrabalho.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.segundotrabalho.R;
import com.example.segundotrabalho.adapters.ObjetoAdapter;
import com.example.segundotrabalho.database.AppDatabase;
import com.example.segundotrabalho.model.Objeto;
import com.example.segundotrabalho.model.Tipo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EditarObjetoActivity extends AppCompatActivity {
    AppDatabase db;
    Spinner spinner;
    ListView list;
    ObjetoAdapter adapter;
    EditText nomeFuncionarioText;
    private TextView errorText;
    List<Objeto> objetos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_objeto);

        list = findViewById(R.id.listViewTipoObjeto);
        nomeFuncionarioText = findViewById(R.id.editTextNomeFuncionario);

        db = AppDatabase.getAppDatabase(getApplicationContext());
        spinner = findViewById(R.id.spinnerTipo);
        populeSpinner();

        errorText = findViewById(R.id.textViewErrorEditarObjeto);

        //adicionar adapter
        objetos = db.objetoDao().getAll();
        adapter = new ObjetoAdapter(this, objetos);
        list.setAdapter(adapter);

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
    public void adicionarObjeto(View v) {
        String nomeFuncionarioValue;
        int tipoId;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Define o formato da data desejado
        String dataRegistro = dateFormat.format(new Date()); // Obtém a data atual e formata como String

        nomeFuncionarioValue = nomeFuncionarioText.getText().toString();

        if (nomeFuncionarioValue.isEmpty()) {
            errorText.setVisibility(View.VISIBLE);
        } else {
            Tipo objectSelected = (Tipo) spinner.getSelectedItem();
            tipoId = objectSelected.getTipoId();
            Objeto objeto = new Objeto(tipoId, dataRegistro, nomeFuncionarioValue);

            long resultado = db.objetoDao().insertObjeto(objeto);

            if (resultado >= 0) {
                objeto.setNumPatrim(resultado);
                adapter.addObjeto(objeto);
                nomeFuncionarioText.setText("");
            }
            else {
                Log.e("Inserção", "Falha na inserção");
            }
        }
    }

    public void voltarButton(View v) {
        this.finish();
    }
}