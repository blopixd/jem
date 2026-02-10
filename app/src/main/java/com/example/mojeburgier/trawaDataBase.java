package com.example.mojeburgier;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {kosiarka.class},version = 1)
public abstract class trawaDataBase extends RoomDatabase {
    public abstract kosiarkaDAO zwrocKosiarkaDAO();
    private static trawaDataBase instancja;
    public static trawaDataBase zwrocBazeDanych(Context context){
        if(instancja==null){
            instancja = Room.databaseBuilder(
                    context.getApplicationContext(),
                    trawaDataBase.class,
                    "trawa_DB")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instancja;
    }
}
