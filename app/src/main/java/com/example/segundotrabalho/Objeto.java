package com.example.segundotrabalho;

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

}


