package com.example.csaba.tourguidelondon2018;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by csaba on 4/1/2018.
 */

public class Hotels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        /** locations */
        android.location.Location location1 = new android.location.Location(getString(R.string.AlhambraHotel)) ;
        location1.setLatitude(51.5292885);
        location1.setLongitude(-0.1247364);
        android.location.Location location2 = new android.location.Location(getString(R.string.grangeholborn));
        location2.setLatitude(51.519271);
        location2.setLongitude(-0.1233077);
        android.location.Location location3 = new android.location.Location(getString(R.string.grangetowerhotel));
        location3.setLatitude(51.5220028);
        location3.setLongitude(-0.0739024);
        android.location.Location location4 = new android.location.Location(getString(R.string.moxy));
        location4.setLatitude(51.5256545);
        location4.setLongitude(0.0026285);
        android.location.Location location5 = new android.location.Location(getString(R.string.parkplaza));
        location5.setLatitude(51.5009568);
        location5.setLongitude(-0.1254412);
        android.location.Location location6 = new android.location.Location(getString(R.string.Reemhotel));
        location6.setLatitude(51.5133946);
        location6.setLongitude(-0.1941466);
        android.location.Location location7 = new android.location.Location(getString(R.string.Stgiles));
        location7.setLatitude(51.517473);
        location7.setLongitude(-0.1328781);
        android.location.Location location8 = new android.location.Location(getString(R.string.Towerhotel));
        location8.setLatitude(51.5064438);
        location8.setLongitude(-0.0759838);
        android.location.Location location9 = new android.location.Location(getString(R.string.Travelodge));
        location9.setLatitude(51.5109887);
        location9.setLongitude(-0.0756985);
        android.location.Location location10 = new android.location.Location(getString(R.string.Westburyhotel));
        location10.setLatitude(51.5112954);
        location10.setLongitude(-0.144799);
        android.location.Location location11 = new android.location.Location(getString(R.string.ParkPlazaVictoriaHotel));
        location11.setLatitude(51.4942477);
        location11.setLongitude(-0.1440095);



        final ArrayList<Item> hotels = new ArrayList<>();

        hotels.add(new Item(getString(R.string.AlhambraHotel), getString(R.string.Alhambrahoteldesc), getString(R.string.price1), R.drawable.alhambra, location1));
        hotels.add(new Item(getString(R.string.grangeholborn), getString(R.string.grangeholborndesc) , getString(R.string.price2), R.drawable.grangeholborn, location2));
        hotels.add(new Item(getString(R.string.grangetowerhotel), getString(R.string.grangetowerdesc), getString(R.string.price1), R.drawable.grangetowerhotel, location3));
        hotels.add(new Item(getString(R.string.moxy), getString(R.string.moxydesc), getString(R.string.price1), R.drawable.moxy, location4));
        hotels.add(new Item(getString(R.string.parkplaza), getString(R.string.parkplazadesc), getString(R.string.price2), R.drawable.parkplaza, location5));
        hotels.add(new Item(getString(R.string.Reemhotel), getString(R.string.reemhoteldesc), getString(R.string.price1), R.drawable.reemhotel, location6));
        hotels.add(new Item(getString(R.string.Stgiles), getString(R.string.stgilesdesc), getString(R.string.price3), R.drawable.stgiles,location7));
        hotels.add(new Item(getString(R.string.Towerhotel), getString(R.string.towerhoteldesc), getString(R.string.price1), R.drawable.towerhotel, location8));
        hotels.add(new Item(getString(R.string.Travelodge), getString(R.string.travelodgedesc), getString(R.string.price2), R.drawable.travelodge, location9));
        hotels.add(new Item(getString(R.string.Westburyhotel), getString(R.string.Westburydesc), getString(R.string.price1), R.drawable.westburyhotel, location10));
        hotels.add(new Item(getString(R.string.ParkPlazaVictoriaHotel), getString(R.string.parkpalzavictoriadesc), getString(R.string.price3), R.drawable.parkplazavictoria, location11));

        final ItemAdapter adapter = new ItemAdapter(this, hotels);

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        /** Onclick listener for map clicking */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = hotels.get(position).getLocation().getLatitude();
                double lon = hotels.get(position).getLocation().getLongitude();
                String keyword = hotels.get(position).getmTitle();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(keyword)
                );

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });

    }
}