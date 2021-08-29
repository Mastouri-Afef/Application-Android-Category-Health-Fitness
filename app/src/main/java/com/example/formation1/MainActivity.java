package com.example.formation1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText taille = null;
    private EditText poids = null;
    private Button btn,btnn =  null;
    private TextView result,result2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taille = (EditText) findViewById(R.id.taille);
        poids = (EditText) findViewById(R.id.poids);
        btn = (Button) findViewById(R.id.btn);
        result = (TextView) findViewById(R.id.result);
        btnn = (Button) findViewById(R.id.btnn);
        result2 = (TextView) findViewById(R.id.result2);
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double t = Double.parseDouble(taille.getText().toString());
                double p = Double.parseDouble(poids.getText().toString());
                double r = p / (t * t);
                String res = "";
                if (r >= 40) {
                    res = "obésité massive";
                } else if (r <= 40 && r > 35) {
                    res = "obésité sévére";
                } else if (r < 35 && r >= 30){
                    res = "obésité modérée";
                }else if (r < 30 && r >= 25){
                    res = "surpoids";
                }else if (r < 25 && r >= 18.5){
                    res = "corpulance normale";
                }else if (r < 18.5 && r >= 16.5){
                    res = "maigreur";
                }else {
                    res = "famine";
                }
                result.setText(res);
            }
        });
        btnn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               openActivity2();
            }
        });

    }

    private void openActivity2() {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}