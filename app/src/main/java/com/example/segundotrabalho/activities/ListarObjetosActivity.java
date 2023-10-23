package com.example.segundotrabalho.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.segundotrabalho.R;
import com.example.segundotrabalho.adapters.ListarObjetosAdapter;
import com.example.segundotrabalho.adapters.TipoAdapter;
import com.example.segundotrabalho.database.AppDatabase;
import com.example.segundotrabalho.model.Tipo;
import com.example.segundotrabalho.model.TipoObjeto;

import java.util.List;

public class ListarObjetosActivity extends AppCompatActivity {

    private Spinner spinnerTipos;
    ListView list;
    ListarObjetosAdapter adapter;
    private AppDatabase db;

    List<TipoObjeto> tipoObjetoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_objetos);

        list = findViewById(R.id.listViewTipoObjeto);

        spinnerTipos = findViewById(R.id.spinnerTipos);
        db = AppDatabase.getAppDatabase(getApplicationContext());

        tipoObjetoList = db.tipoDao().getTiposAndObjetos();
        adapter = new ListarObjetosAdapter(this, tipoObjetoList);
        list.setAdapter(adapter);
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
