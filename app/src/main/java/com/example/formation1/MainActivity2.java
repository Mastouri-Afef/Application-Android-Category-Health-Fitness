package com.example.formation1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    private EditText info_vol_edit;
    private RecyclerView info_vol;
    private Button add_info_vol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        info_vol_edit = findViewById(R.id.info_vol);
        info_vol = findViewById(R.id.info_vol_list);
        add_info_vol = findViewById(R.id.add_info_vol_btn);
    }
}