package com.example.segundotrabalho.model;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "objeto",
        foreignKeys = {
                @ForeignKey(entity = Tipo.class,
                        parentColumns = "tipo_id",
                        childColumns = "tipo_id_fk",
                        onDelete = CASCADE)
        })
public class Objeto {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "num_patrim")
    public int numPatrim;

    @ColumnInfo(name = "tipo_id_fk")
    public int tipoIdFk;

    @ColumnInfo(name = "data_registro")
    public String dataRegistro;

    @ColumnInfo(name = "nome_funcionario")
    public String nomeFuncionario;

    public Objeto(int tipoIdFk, String dataRegistro, String nomeFuncionario) {
        this.tipoIdFk = tipoIdFk;
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

    public int getTipoIdFk() { return tipoIdFk; }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }


}


