package com.example.segundotrabalho.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.segundotrabalho.R;
import com.example.segundotrabalho.model.Objeto;

import java.util.List;

public class ObjetoAdapter extends ArrayAdapter<Objeto> {

    public ObjetoAdapter(Context context, List<Objeto> objetos) {
        super(context, 0, objetos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtenha o objeto na posição atual
        Objeto objeto = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_objeto, parent, false);
        }

        // Configure as TextViews do layout item_objeto.xml
        TextView textViewNomeTipo = convertView.findViewById(R.id.textViewNomeTipo);
        TextView textViewNumPatrimonio = convertView.findViewById(R.id.textViewNumPatrimonio);
        TextView textViewNomeFuncionario = convertView.findViewById(R.id.textViewNomeFuncionario);
        TextView textViewDataRegistro = convertView.findViewById(R.id.textViewDataRegistro);

        // Configure os valores dos campos no layout
        //textViewNomeTipo.setText(objeto.getTipo());  // Substitua pelo método correto para obter o nome do tipo
        textViewNumPatrimonio.setText("Num Patrimônio: " + objeto.getNumPatrim());
        textViewNomeFuncionario.setText("Nome Funcionário: " + objeto.getNomeFuncionario());
        textViewDataRegistro.setText("Data de Registro: " + objeto.getDataRegistro());

        // Configure os botões "Excluir" e "Editar" se necessário

        return convertView;
    }
}
