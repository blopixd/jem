package com.example.mojeburgier;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

    EditText model2;
    EditText marka2;
    EditText obrotowy2;
    EditText szybkosc2;
    Button buton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        trawaDB = trawaDataBase.zwrocBazeDanych(MainActivity.this);
        trawaDB.zwrocKosiarkaDAO().wstawKosiarke(new kosiarka("potroncony","g",12,12));
        trawaDB.zwrocKosiarkaDAO().wstawKosiarke(new kosiarka("dobry","7",12,12));
        listView = findViewById(R.id.lista);
        marka2 = findViewById(R.id.editTextText2);
        model2 = findViewById(R.id.editTextText3);
        obrotowy2 = findViewById(R.id.editTextNumber);
        szybkosc2 = findViewById(R.id.editTextNumber2);
        buton = findViewById(R.id.button);
        kosiList = trawaDB.zwrocKosiarkaDAO().zwrocKosiarki();
        kosList = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                kosiList);
        listView.setAdapter(kosList);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        trawaDB.zwrocKosiarkaDAO().usunKosiarke(kosiList.get(i));
                        kosiList.remove(i);
                        kosList.notifyDataSetChanged();
                    }
                }
        );
        buton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        trawaDB.zwrocKosiarkaDAO().wstawKosiarke(new kosiarka(marka2.getText().toString(),model2.getText().toString(),Integer.parseInt(obrotowy2.getText().toString()), Integer.parseInt(szybkosc2.getText().toString())));
                        kosList.notifyDataSetChanged();
                        kosiList.add(new kosiarka(marka2.getText().toString(),model2.getText().toString(),Integer.parseInt(obrotowy2.getText().toString()), Integer.parseInt(szybkosc2.getText().toString())));
                    }
                }
        );
    }
}