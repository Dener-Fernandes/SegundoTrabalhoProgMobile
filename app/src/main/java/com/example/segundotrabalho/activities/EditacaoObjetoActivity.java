package com.example.segundotrabalho.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.segundotrabalho.R;
import com.example.segundotrabalho.database.AppDatabase;
import com.example.segundotrabalho.model.Objeto;
import com.example.segundotrabalho.model.Tipo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EditacaoObjetoActivity extends AppCompatActivity {

    AppDatabase db;
    private Spinner spinner;
    private EditText editTextNomeFuncionario; // Adicione outros campos conforme necessário
    int numPatrim, tipoIdFk;
    String nomeFuncionario;

    private TextView errorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editacao_objeto);

        db = AppDatabase.getAppDatabase(getApplicationContext());

        // Inicialize os componentes da interface do usuário

        editTextNomeFuncionario = findViewById(R.id.editTextNomeFuncionario); // Adicione outros campos conforme necessário

        numPatrim = getIntent().getIntExtra("numPatrim", -1);
        tipoIdFk = getIntent().getIntExtra("tipoIdFk", -1);
        nomeFuncionario = getIntent().getStringExtra("nomeFuncionario");

        editTextNomeFuncionario.setText(nomeFuncionario);

        errorText = findViewById(R.id.textViewErrorEditacaoObjeto);

        spinner = findViewById(R.id.spinnerTipo);
        populeSpinner();
    }

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

    public void atualizarObjeto(View v) {
        String novoNomeFuncionario;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Define o formato da data desejado
        String dataRegistro = dateFormat.format(new Date()); // Obtém a data atual e formata como String

        novoNomeFuncionario = editTextNomeFuncionario.getText().toString();

        if (novoNomeFuncionario.isEmpty()) {
            errorText.setVisibility(View.VISIBLE);
        } else {
            Objeto objeto = new Objeto(tipoIdFk, dataRegistro, novoNomeFuncionario);
            objeto.setNumPatrim(numPatrim);
            db.objetoDao().updateObjeto(objeto);

            setResult(EditarObjetoActivity.RESULT_SUCESSO_EDITACAO_OBJETO);
            finish();
        }
    }

    public void voltarButton(View v) {
        this.finish();
    }
}
