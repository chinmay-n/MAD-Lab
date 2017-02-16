package com.example.student.viva;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    private ArrayAdapter<String> listAdapter ;
    private String[] pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mainList = (ListView) findViewById( R.id.listm );
        final Intent i = new Intent(getApplicationContext(), Main2Activity.class);

        String [] arr = new String[] {"10","12","3","4","6","8"};



        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll( Arrays.asList(arr) );

        listAdapter = new ArrayAdapter<String>(this, R.layout.row, planetList);

        mainList.setAdapter( listAdapter );

        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Integer p = (Integer) parent.getId();
                String s = (String) parent.getItemAtPosition(position);
                //pass.
                Toast.makeText(getApplicationContext(),
                        s,
                        Toast.LENGTH_LONG).show();
            }
        });

        Button b = (Button) findViewById(R.id.button);


        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                i.putExtra("3","new");
                startActivity(i);
            }
        });
    }


}
