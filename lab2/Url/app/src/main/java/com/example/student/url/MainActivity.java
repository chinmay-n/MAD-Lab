package com.example.student.url;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText e = (EditText) findViewById(R.id.editText);
        Button b = (Button) findViewById(R.id.button);

        final Intent i = new Intent(getApplicationContext(), Main2Activity.class);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String s=e.getText().toString();
                s="http://"+s;
                i.putExtra("Num1",s);
                startActivity(i);
            }
        });
    }
}
