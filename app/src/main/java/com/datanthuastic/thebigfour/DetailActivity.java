package com.datanthuastic.thebigfour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static com.datanthuastic.thebigfour.MainActivity.selectedImage;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.imageView);
        TextView bandNameText = findViewById(R.id.bandNameText);
        TextView infoText = findViewById(R.id.infoText);

        Intent intent = getIntent();

        String bandName = intent.getStringExtra("bands");
        bandNameText.setText(bandName);

        String info = intent.getStringExtra("informations");
        infoText.setText(info);

        imageView.setImageBitmap(selectedImage);



    }
}