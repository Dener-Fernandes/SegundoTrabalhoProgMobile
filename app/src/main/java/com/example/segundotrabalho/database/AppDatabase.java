package com.example.segundotrabalho.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.segundotrabalho.model.Objeto;
import com.example.segundotrabalho.DAO.ObjetoDao;
import com.example.segundotrabalho.model.Tipo;
import com.example.segundotrabalho.DAO.TipoDao;

@Database(entities = {Tipo.class, Objeto.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase INSTANCE;

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "Patrimonio").allowMainThreadQueries().build();
        }

        return INSTANCE;
    }

    public abstract TipoDao tipoDao();
    public abstract ObjetoDao objetoDao();

}