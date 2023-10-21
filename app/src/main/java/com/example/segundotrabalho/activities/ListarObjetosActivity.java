package com.example.segundotrabalho.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.segundotrabalho.R;
import com.example.segundotrabalho.database.AppDatabase;
import com.example.segundotrabalho.model.Tipo;

import java.util.List;

public class ListarObjetosActivity extends AppCompatActivity {

    private Spinner spinnerTipos;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_objetos);

        spinnerTipos = findViewById(R.id.spinnerTipos);
        db = AppDatabase.getAppDatabase(getApplicationContext());

        populateSpinner();
    }

    private void populateSpinner() {
        List<Tipo> tipos = db.tipoDao().getAll(); // Obtém a lista de tipos do banco de dados

        if (!tipos.isEmpty()) {
            ArrayAdapter<Tipo> adapter = new ArrayAdapter<>(this, R.layout.spinner_tipos, tipos);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerTipos.setAdapter(adapter);
        } else {
            // Se não houver tipos disponíveis, você pode mostrar uma mensagem ao usuário ou tomar a ação apropriada.
        }
    }

    public void voltarButton(View v) {
        this.finish();
    }
}
