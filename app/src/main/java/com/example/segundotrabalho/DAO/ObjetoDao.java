package com.example.segundotrabalho.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.segundotrabalho.model.Objeto;

import java.util.List;

@Dao
public interface ObjetoDao {
    @Insert
    public void insertObjeto(Objeto objeto);
    @Query("SELECT * FROM objeto")
    List<Objeto> getAll();
    @Update
    public void updateObjeto(Objeto... objeto);
    @Delete
    public void deleteObjeto(Objeto... objeto);
}
