package com.example.segundotrabalho.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.segundotrabalho.model.Tipo;

import java.util.List;

@Dao
public interface TipoDao {
    @Insert
    public long insertTipo(Tipo tipo);
    @Query("SELECT * FROM tipo")
    List<Tipo> getAll();
    @Update
    public void updateTipo(Tipo... tipo);
    @Delete
    public void deleteTipo(Tipo... tipo);
}
