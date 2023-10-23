package com.example.segundotrabalho.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.segundotrabalho.DAO.TipoDao;
import com.example.segundotrabalho.R;
import com.example.segundotrabalho.database.AppDatabase;
import com.example.segundotrabalho.model.Tipo;
import com.example.segundotrabalho.model.TipoObjeto;

import java.util.List;

public class ListarObjetosAdapter  extends BaseAdapter {

    private List<TipoObjeto> tipoObjetoList;
    private Context context;
    private TipoDao tipoDao;

    public ListarObjetosAdapter(Context context, List<TipoObjeto> tipoObjetoList) {
        this.context = context;
        this.tipoObjetoList = tipoObjetoList;
        this.tipoDao = AppDatabase.getAppDatabase(context).tipoDao();
    }

    @Override
    public int getCount() { return tipoObjetoList.size(); }

    @Override
    public Object getItem(int position)  { return tipoObjetoList.get(position); }

    @Override
    public long getItemId(int position)  { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_tipo_objeto, parent, false);
        }

        TipoObjeto tipoObjeto = tipoObjetoList.get(position);

        TextView textNomeTipoObjeto = convertView.findViewById(R.id.textNomeTipoObjeto);
        TextView textDescricaoTipoObjeto = convertView.findViewById(R.id.textDescricaoTipoObjeto);
        TextView textNumPatrimonioTipoObjeto = convertView.findViewById(R.id.textNumPatrimonioTipoObjeto);
        TextView textNomeFuncionarioTipoObjeto = convertView.findViewById(R.id.textNomeFuncionarioTipoObjeto);
        TextView textDataRegistroTipoObjeto = convertView.findViewById(R.id.textDataRegistroTipoObjeto);

        textNomeTipoObjeto.setText("Tipo: " + String.valueOf(tipoObjeto.getTipo()));
        textNomeFuncionarioTipoObjeto.setText("Nome Funcionário: " + tipoObjeto.getNomeFuncionario());

        return convertView;
    }
}
