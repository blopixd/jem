package com.example.mojeburgier;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    trawaDataBase trawaDB;
    ListView listView;
    ArrayAdapter<kosiarka> kosList;
    List<kosiarka> kosiList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        trawaDB = trawaDataBase.zwrocBazeDanych(MainActivity.this);
        trawaDB.zwrocKosiarkaDAO().wstawKosiarke(new kosiarka("potroncony","g",12,12));
        trawaDB.zwrocKosiarkaDAO().wstawKosiarke(new kosiarka("dobry","7",12,12));
        listView = findViewById(R.id.lista);
        kosiList = trawaDB.zwrocKosiarkaDAO().zwrocKosiarki();
        kosList = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                kosiList);
        listView.setAdapter(kosList);
    }
}