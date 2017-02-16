package com.example.student.q1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Random r2 = new Random();
        final int i1 = r2.nextInt(20);

        String t="Not Set",v="Not Set",r="Not Set";
        Button b1 = (Button) findViewById(R.id.button2);
        Button b2 = (Button) findViewById(R.id.button3);
        TextView t1 = (TextView) findViewById(R.id.textView3);
         TextView t2 = (TextView) findViewById(R.id.textView5);
         TextView t3 = (TextView) findViewById(R.id.textView7);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             t = extras.getString("1");
             v = extras.getString("2");
             r = extras.getString("3");
        }

        t1.setText(t);
        t2.setText(v);
        t3.setText(r);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String p= Integer.toString(i1);
                String q="Alloted Parking No "+ p;
                Toast.makeText(getApplicationContext(),q,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //this will always start your activity as a new task
                startActivity(intent);
            }
        });
    }

}
