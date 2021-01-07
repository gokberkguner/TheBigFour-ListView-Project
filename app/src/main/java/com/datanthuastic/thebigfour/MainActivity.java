package com.datanthuastic.thebigfour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static Bitmap selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        // Datas

        ArrayList<String> bandNames = new ArrayList<>();

        bandNames.add("Metallica");
        bandNames.add("Megadeth");
        bandNames.add("Slayer");
        bandNames.add("Anthrax");

        ArrayList<String> infos = new ArrayList<>();

        infos.add("Metallica is an American heavy metal band. The band was formed in 1981 in Los Angeles by vocalist/guitarist James Hetfield and drummer Lars Ulrich, and has been based in San Francisco for most of its career. The band's fast tempos, instrumentals and aggressive musicianship made them one of the founding big four bands of thrash metal, alongside Megadeth, Anthrax and Slayer. Metallica's current lineup comprises founding members and primary songwriters Hetfield and Ulrich, longtime lead guitarist Kirk Hammett, and bassist Robert Trujillo. Guitarist Dave Mustaine (who went on to form Megadeth after being fired from the band) and bassists Ron McGovney, Cliff Burton (who died in a bus accident in Sweden in 1986) and Jason Newsted are former members of the band.");
        infos.add("Megadeth is an American heavy metal band formed in 1983 by guitarist Dave Mustaine and bassist David Ellefson in Los Angeles, California. Along with Metallica, Anthrax, and Slayer, Megadeth is one of the big four of American thrash metal, responsible for its development and popularization. Their music features complex arrangements and fast rhythm sections, and lyrical themes of death, war, politics, personal relationships and religion.");
        infos.add("Slayer was an American thrash metal band from Huntington Park, California. The band was formed in 1981 by guitarists Kerry King and Jeff Hanneman, drummer Dave Lombardo, and bassist and vocalist Tom Araya. Slayer's fast and aggressive musical style made them one of the big four bands of thrash metal, alongside Metallica, Megadeth, and Anthrax. Slayer's final lineup comprised King, Araya, drummer Paul Bostaph (who replaced Lombardo in 1992 and again in 2013) and guitarist Gary Holt (who replaced Hanneman in 2011). Drummer Jon Dette was also a member of the band.");
        infos.add("Anthrax is an American heavy metal band from New York City, formed in 1981 by rhythm guitarist Scott Ian and bassist Dan Lilker. The group is considered one of the leaders of the thrash metal scene from the 1980s and is part of the big Four of the genre, along with Metallica, Megadeth and Slayer. They were also one of the first thrash metal bands (along with Overkill and Nuclear Assault) to emerge from the East Coast.");

        Bitmap metallica = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.metallica);
        Bitmap megadeth = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.megadeth);
        Bitmap slayer = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.slayer);
        Bitmap anthrax = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.anthrax);

        ArrayList<Bitmap> bandImages = new ArrayList<>();

        bandImages.add(metallica);
        bandImages.add(megadeth);
        bandImages.add(slayer);
        bandImages.add(anthrax);

        // Listview Parts

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,bandNames);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);

                intent.putExtra("bands",bandNames.get(position));
                intent.putExtra("informations",infos.get(position));

                selectedImage = bandImages.get(position);

                startActivity(intent);


            }
        });





    }
}