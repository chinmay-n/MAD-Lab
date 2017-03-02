package com.example.student.q3;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String uri1 = "@drawable/images.jpg";
        final String uri2 = "@drawable/unnamed.png";

        final ImageButton button1 = (ImageButton) findViewById(R.id.imageButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, button1);
                popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override

                    public boolean onMenuItemClick(MenuItem item) {
                        String name = item.getTitle().toString();
                        int imageResource = 0;
                        if(name=="Image1"){
                            final ImageView i = (ImageView) findViewById(R.id.imageView);
                            i.setImageResource(R.drawable.images);
                        }
                        else if(name=="Image2"){
                            final ImageView i = (ImageView) findViewById(R.id.imageView);
                            i.setImageResource(R.drawable.unnamed);
                        }

                        Toast.makeText(MainActivity.this,"Clicked Item: " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popup.show();
            }
        });
    }
}
