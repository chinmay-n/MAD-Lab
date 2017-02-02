package com.example.student.q1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class Main2Activity extends AppCompatActivity {

    String c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText t1 = (EditText) findViewById(R.id.editText);
        final EditText t2 = (EditText) findViewById(R.id.editText2);
        final Intent i = new Intent(getApplicationContext(), MainActivity.class);



        Button add = (Button) findViewById(R.id.button2);
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String num1= t1.getText().toString();
                int a = Integer.parseInt(num1);
                String num2= t2.getText().toString();
                int b = Integer.parseInt(num2);
                int ab = a+b;
                String res = Integer.toString(ab);
                c=num1+"+"+num2+"="+res;
                i.putExtra("Num1",c);
                startActivity(i);
            }
        });

        Button sub = (Button) findViewById(R.id.button3);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1= t1.getText().toString();
                int a = Integer.parseInt(num1);
                String num2= t2.getText().toString();
                int b = Integer.parseInt(num2);
                int ab = a-b;
                String res = Integer.toString(ab);
                c=num1+"-"+num2+"="+res;
                i.putExtra("Num1",c);
                startActivity(i);
            }
        });

        Button mult = (Button) findViewById(R.id.button4);
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1= t1.getText().toString();
                int a = Integer.parseInt(num1);
                String num2= t2.getText().toString();
                int b = Integer.parseInt(num2);
                int ab = a*b;
                String res = Integer.toString(ab);
                c=num1+"*"+num2+"="+res;
                i.putExtra("Num1",c);
                startActivity(i);
            }
        });

        Button div = (Button) findViewById(R.id.button5);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1= t1.getText().toString();
                int a = Integer.parseInt(num1);
                String num2= t2.getText().toString();
                int b = Integer.parseInt(num2);
                int ab = a/b;
                String res = Integer.toString(ab);
                c=num1+"/"+num2+"="+res;
                i.putExtra("Num1",c);
                startActivity(i);
            }
        });
    }

}
