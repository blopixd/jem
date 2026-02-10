package com.example.mojeburgier;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "kosiarkii")
public class kosiarka {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String marka;
    private String model;
    private int obrotowy;
    @ColumnInfo(name = "najszybszy")
    private int szybkosc;

    public kosiarka(String marka, String model, int obrotowy, int szybkosc) {
        this.id = 0;
        this.marka = marka;
        this.model = model;
        this.obrotowy = obrotowy;
        this.szybkosc = szybkosc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getObrotowy() {
        return obrotowy;
    }

    public void setObrotowy(int obrotowy) {
        this.obrotowy = obrotowy;
    }

    public int getSzybkosc() {
        return szybkosc;
    }

    public void setSzybkosc(int szybkosc) {
        this.szybkosc = szybkosc;
    }

    @Override
    public String toString() {
        return //"kosiarka{" +
                //"id=" + id +
                "Marka: " + marka +
                ", Model: " + model +
                ", Obrotowy: " + obrotowy +
                ", Szybkosc: " + szybkosc;
    }
}
