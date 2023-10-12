package com.example.segundotrabalho;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TipoDao {
    @Insert
    public long insertTipo(Tipo tipo);
    @Query("SELECT * FROM tipo")
    List<Tipo> getAll();
    @Update
    public void updateObjeto(Tipo... tipo);
    @Delete
    public void deleteObjeto(Tipo... tipo);
}
