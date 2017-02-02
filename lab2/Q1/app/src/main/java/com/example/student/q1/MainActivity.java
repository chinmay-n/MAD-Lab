package com.example.student.q1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String value="";
        TextView t = (TextView) findViewById(R.id.textView3);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("Num1");
            t.setText(value);
            //The key argument here must match that used in the other activity
        }

        Button button = (Button) findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.super.finish();
            }
        });
    }


}
