package com.example.segundotrabalho.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "objeto")
public class Objeto {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "num_patrim")
    public int numPatrim;

    @ColumnInfo(name = "tipo_id")
    public int tipoId;

    @ColumnInfo(name = "data_registro")
    public String dataRegistro;

    @ColumnInfo(name = "nome_funcionario")
    public String nomeFuncionario;

    public Objeto(int tipoId, String dataRegistro, String nomeFuncionario) {
        this.tipoId = tipoId;
        this.dataRegistro = dataRegistro;
        this.nomeFuncionario = nomeFuncionario;
    }

    // Implementar lógica para trazer o tipo do objeto
    //public int getTipo() {
    //    return {};
    //}

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


