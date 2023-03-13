package com.example.korochentsevapp2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap<String, Integer> instruments = new HashMap<String, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instruments.put("Guitar", 200);
        instruments.put("Saxophone", 250);
        instruments.put("Drums", 180);
        instruments.put("Piano", 300);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, instruments.keySet().toArray());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                int asd = instruments.get(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void decreaseCounter(View view) {
        TextView counter = findViewById(R.id.textView5);
        int curr = Integer.parseInt(counter.getText().toString());
        counter.setText(--curr);
    }

    public void increaseCounter(View view) {
        TextView counter = findViewById(R.id.textView5);
        int curr = Integer.parseInt(counter.getText().toString());
        counter.setText(++curr);
    }
}