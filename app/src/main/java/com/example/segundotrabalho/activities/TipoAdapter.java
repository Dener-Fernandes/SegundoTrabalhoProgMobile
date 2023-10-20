package com.example.segundotrabalho.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.example.segundotrabalho.DAO.TipoDao;
import com.example.segundotrabalho.R;
import com.example.segundotrabalho.database.AppDatabase;
import com.example.segundotrabalho.model.Tipo;

import java.util.List;

public class TipoAdapter extends BaseAdapter {

    private List<Tipo> tipoList;
    private Context context;
    private TipoDao tipoDao;

    public TipoAdapter(Context context, List<Tipo> tipoList) {
        this.context = context;
        this.tipoList = tipoList;
        this.tipoDao = AppDatabase.getAppDatabase(context).tipoDao();
    }

    public void addTipo(Tipo tipo) {
        long tipoId = tipoDao.insertTipo(tipo);
        if (tipoId > 0) {
            tipo.setTipoId((int) tipoId); // Atualiza o ID do objeto Tipo com o valor gerado
            tipoList.add(tipo);
            notifyDataSetChanged(); // Notifica o adaptador sobre a adição
        }
    }

    @Override
    public int getCount() {
        return tipoList.size();
    }

    @Override
    public Object getItem(int position) {
        return tipoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_tipo, parent, false);
        }

        TextView textViewNomeTipo = convertView.findViewById(R.id.textViewNomeTipo);
        TextView textViewDescricao = convertView.findViewById(R.id.textViewDescricao); // Novo TextView para descrição
        Button buttonEditar = convertView.findViewById(R.id.buttonEditar);
        Button buttonExcluir = convertView.findViewById(R.id.buttonExcluir);

        Tipo tipo = tipoList.get(position);

        textViewNomeTipo.setText(tipo.getTipo());
        textViewDescricao.setText("\n\n" + tipo.getDescricao());// Exibe a descrição

        // Configurar os cliques dos botões de edição e exclusão
        buttonEditar.setOnClickListener(view -> {
            // Implemente a lógica de edição aqui usando o objeto tipo
        });

        buttonExcluir.setOnClickListener(view -> {
            tipoDao.deleteObjeto(tipo);
            tipoList.remove(position);
            notifyDataSetChanged(); // Notifica o adaptador sobre a remoção
        });

        return convertView;
    }

}
