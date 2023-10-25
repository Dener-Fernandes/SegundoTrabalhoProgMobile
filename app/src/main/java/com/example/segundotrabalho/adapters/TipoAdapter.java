package com.example.segundotrabalho.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.example.segundotrabalho.DAO.TipoDao;
import com.example.segundotrabalho.R;
import com.example.segundotrabalho.activities.EdicaoTipoActivity;
import com.example.segundotrabalho.activities.EditarObjetoActivity;
import com.example.segundotrabalho.activities.EditarTipoActivity;
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
        tipo.setTipoId((int) tipo.getTipoId()); // Atualiza o ID do objeto Tipo com o valor gerado
        tipoList.add(tipo);
        notifyDataSetChanged(); // Notifica o adaptador sobre a adição
    }

    public void atualizarDados(List<Tipo> tipoList) {
        this.tipoList = tipoList;
        notifyDataSetChanged();
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

        TextView textViewNomeTipo = convertView.findViewById(R.id.textNomeTipoObjeto);
        TextView textViewDescricao = convertView.findViewById(R.id.textDescricaoTipoObjeto); // Novo TextView para descrição
        Button buttonEditar = convertView.findViewById(R.id.buttonEditarObjeto);
        Button buttonExcluir = convertView.findViewById(R.id.buttonExcluirObjeto);

        Tipo tipo = tipoList.get(position);

        textViewNomeTipo.setText(tipo.getTipo());
        textViewDescricao.setText("\n\n" + tipo.getDescricao());// Exibe a descrição

        // Configurar os cliques dos botões de edição e exclusão
        buttonEditar.setOnClickListener(view -> {
            Intent it_tela_edicao_tipo = new Intent(context, EdicaoTipoActivity.class);

            it_tela_edicao_tipo.putExtra("tipoId", tipo.getTipoId());
            it_tela_edicao_tipo.putExtra("tipo", tipo.getTipo());
            it_tela_edicao_tipo.putExtra("descricao", tipo.getDescricao());

            ((Activity) context).startActivityForResult(it_tela_edicao_tipo, EditarTipoActivity.REQUEST_CODE_EDICAO_TIPO);
        });

        buttonExcluir.setOnClickListener(view -> {
            tipoDao.deleteTipo(tipo);
            tipoList.remove(position);
            notifyDataSetChanged(); // Notifica o adaptador sobre a remoção
        });

        return convertView;
    }

}