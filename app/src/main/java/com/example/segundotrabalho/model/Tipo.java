package com.example.segundotrabalho.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tipo")
public class Tipo {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "tipo_id")
    public int tipoId;

    public String tipo;

    public String descricao;

    public Tipo(String tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public int getTipoId() { return tipoId; }
}
