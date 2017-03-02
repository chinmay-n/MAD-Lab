package com.example.student.viva;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Integer> a = new ArrayList<Integer>();
       final  ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, a);
        final EditText e = (EditText) findViewById(R.id.editText);
        Button add = (Button) findViewById(R.id.button);
        Button reset = (Button) findViewById(R.id.button2);
        Button clear = (Button) findViewById(R.id.button4);
        Button done = (Button) findViewById(R.id.button3);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String n = e.getText().toString();
                Integer num = Integer.valueOf(n);

                a.add(num);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                e.setText("");
            }
        });

        done.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Collections.sort(a);
                spinner.setAdapter(adapter);
            }
        });

        done.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                a.clear();
                spinner.setAdapter(adapter);
            }
        });
    }
}
