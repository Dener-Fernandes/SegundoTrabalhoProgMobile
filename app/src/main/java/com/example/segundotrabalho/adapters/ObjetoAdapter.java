package com.example.segundotrabalho.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.segundotrabalho.DAO.ObjetoDao;
import com.example.segundotrabalho.R;
import com.example.segundotrabalho.activities.EditacaoObjetoActivity;
import com.example.segundotrabalho.database.AppDatabase;
import com.example.segundotrabalho.model.Objeto;

import java.util.List;

public class ObjetoAdapter extends ArrayAdapter<Objeto> {
    private List<Objeto> objetoList;
    private Context context;
    private ObjetoDao objetoDao;

    public ObjetoAdapter(Context context, List<Objeto> objetoList) {
        super(context, 0, objetoList);
        this.context = context;
        this.objetoList = objetoList;
        this.objetoDao = AppDatabase.getAppDatabase(context).objetoDao();
    }

    public void addObjeto(Objeto objeto) {
        objeto.setNumPatrim((int) objeto.getNumPatrim()); // Atualiza o ID do objeto Tipo com o valor gerado
        objetoList.add(objeto);
        notifyDataSetChanged(); // Notifica o adaptador sobre a adição
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtenha o objeto na posição atual
        Objeto objeto = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_objeto, parent, false);
        }

        // Configure as TextViews do layout item_objeto.xml
        TextView textViewNomeTipo = convertView.findViewById(R.id.textNomeTipoObjeto);
        TextView textViewNumPatrimonio = convertView.findViewById(R.id.textNumPatrimonioTipoObjeto);
        TextView textViewNomeFuncionario = convertView.findViewById(R.id.textNomeFuncionarioTipoObjeto);
        TextView textViewDataRegistro = convertView.findViewById(R.id.textDataRegistroTipoObjeto);
        Button buttonEditarObjeto = convertView.findViewById(R.id.buttonEditarObjeto);
        Button buttonExcluirObjeto = convertView.findViewById(R.id.buttonExcluirObjeto);

        // Configure os valores dos campos no layout
        //textViewNomeTipo.setText(objeto.getTipo());  // Substitua pelo método correto para obter o nome do tipo
        textViewNumPatrimonio.setText("Num Patrimônio: " + objeto.getNumPatrim());
        textViewNomeFuncionario.setText("Nome Funcionário: " + objeto.getNomeFuncionario());
        textViewDataRegistro.setText("Data de Registro: " + objeto.getDataRegistro());

        // Configure os botões "Excluir" e "Editar" se necessário

        buttonEditarObjeto.setOnClickListener(view -> {
            Intent it_tela_editacao_objeto = new Intent(context, EditacaoObjetoActivity.class);

            it_tela_editacao_objeto.putExtra("objetoId", objeto.getNumPatrim());

            it_tela_editacao_objeto.putExtra("nomeFuncionario", objeto.getNomeFuncionario());

            context.startActivity(it_tela_editacao_objeto);
        });

        buttonExcluirObjeto.setOnClickListener(view -> {
            objetoDao.deleteObjeto(objeto);
            objetoList.remove(position);
            notifyDataSetChanged();
        });

        return convertView;
    }
}
