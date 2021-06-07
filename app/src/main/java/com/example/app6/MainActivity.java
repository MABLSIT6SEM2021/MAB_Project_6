package com.example.app6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button xmlButton, jsonButton;
        xmlButton = findViewById(R.id.xmlBtn);
        jsonButton = findViewById(R.id.jsonBtn);

        xmlButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ParseXML.class);
            startActivity(intent);
        });
        jsonButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ParseJSON.class);
            startActivity(intent);
        });
    }
}