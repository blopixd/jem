package com.example.mojeburgier;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface kosiarkaDAO {
    @Insert
    void wstawKosiarke(kosiarka kosiarka);
    @Delete
    void usunKosiarke(kosiarka kosiarka);
    @Update
    void zmianKosiarke(kosiarka kosiarka);

    @Query("select * from kosiarkii")
    List<kosiarka> zwrocKosiarki();

    @Query("select model from kosiarkii where najszybszy > :szyb")
    List<String> zwrcSzyb(int szyb);
}
