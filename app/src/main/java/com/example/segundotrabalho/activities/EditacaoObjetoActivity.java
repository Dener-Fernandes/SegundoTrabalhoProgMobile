package com.example.segundotrabalho.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.segundotrabalho.R;
import com.example.segundotrabalho.database.AppDatabase;
import com.example.segundotrabalho.model.Tipo;

import java.util.List;

public class EditacaoObjetoActivity extends AppCompatActivity {

    AppDatabase db;
    private Spinner spinner;
    private EditText editTextNomeFuncionario; // Adicione outros campos conforme necessário
    private Button buttonSalvar, buttonCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editacao_objeto);

        db = AppDatabase.getAppDatabase(getApplicationContext());

        // Inicialize os componentes da interface do usuário

        editTextNomeFuncionario = findViewById(R.id.editTextNomeFuncionario); // Adicione outros campos conforme necessário
        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonCancelar = findViewById(R.id.buttonCancelar);
        spinner = findViewById(R.id.spinnerTipo);
        populeSpinner();

        // Configurar os cliques dos botões
        /*
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarEdicao(); // Implemente essa função para salvar as edições
            }
        });

        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelarEdicao(); // Implemente essa função para cancelar a edição
            }
        });

         */
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


    // Implemente as funções salvarEdicao() e cancelarEdicao() conforme necessário
}
