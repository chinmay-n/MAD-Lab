package com.example.student.q1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent i = new Intent(getApplicationContext(), Main2Activity.class);
        final EditText e = (EditText) findViewById(R.id.editText);
        final EditText e1 = (EditText) findViewById(R.id.editText3);
        Button b = (Button) findViewById(R.id.button);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.varray, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        spinner.setAdapter(adapter);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String vno=e.getText().toString();
                String rc=e1.getText().toString();
                String type=spinner.getSelectedItem().toString();
                i.putExtra("1",vno);
                i.putExtra("2",rc);
                i.putExtra("3",type);
                startActivity(i);
            }
        });

    }
}
