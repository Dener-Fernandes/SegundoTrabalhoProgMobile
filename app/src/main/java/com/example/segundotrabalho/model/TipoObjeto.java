package com.example.segundotrabalho.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "tipo_objeto")
public class TipoObjeto {
    // Tipo
    @ColumnInfo(name = "tipo_id")
    public int tipoId;

    public String tipo;

    public String descricao;

    // Objeto
    @ColumnInfo(name = "num_patrim")
    public int numPatrim;

    @ColumnInfo(name = "tipo_id_fk")
    public int tipoIdFk;

    @ColumnInfo(name = "data_registro")
    public String dataRegistro;

    @ColumnInfo(name = "nome_funcionario")
    public String nomeFuncionario;

    // Tipo
    public int getTipoId() { return tipoId; }

    public void setTipoId(long resultado) { this.tipoId = (int) resultado; }

    public String getTipo() { return tipo; }
    public String getDescricao() { return descricao; }

    // Objetos
    public void setNumPatrim(long resultado) {
        this.numPatrim = (int) resultado;
    }

    public int getNumPatrim() {
        return numPatrim;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }
}
