package com.example.segundotrabalho.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.segundotrabalho.model.Tipo;
import com.example.segundotrabalho.model.TipoObjeto;

import java.util.List;

@Dao
public interface TipoDao {
    @Insert
    public long insertTipo(Tipo tipo);
    @Query("SELECT * FROM tipo")
    public List<Tipo> getAll();
    @Update
    public void updateTipo(Tipo... tipo);
    @Delete
    public void deleteTipo(Tipo... tipo);
    @Query("SELECT * FROM tipo INNER JOIN objeto ON tipo.tipo_id = objeto.tipo_id_fk")
    public List<TipoObjeto> getTiposAndObjetos();

    @Query("SELECT * FROM tipo INNER JOIN objeto ON tipo.tipo_id = objeto.tipo_id_fk WHERE tipo.tipo = :tipoTipo")
    public List<TipoObjeto> getByFilter(String tipoTipo);
}
