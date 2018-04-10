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

public class Sightseeing extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        /** locations */
        android.location.Location location1 = new android.location.Location(getString(R.string.BigBen));
        location1.setLatitude(51.5007292);
        location1.setLongitude(-0.1268141);
        android.location.Location location2 = new android.location.Location(getString(R.string.BrickLaneLondon));
        location2.setLatitude(51.5224618);
        location2.setLongitude(-0.073335);
        android.location.Location location3 = new android.location.Location(getString(R.string.BuckinghamPalace));
        location3.setLatitude(51.501364);
        location3.setLongitude(-0.1440787);
        android.location.Location location4 = new android.location.Location(getString(R.string.CamdentheStables));
        location4.setLatitude(51.5423591);
        location4.setLongitude(-0.1494229);
        android.location.Location location5 = new android.location.Location(getString(R.string.LondonEye));
        location5.setLatitude(51.5009095);
        location5.setLongitude(-0.121721);
        android.location.Location location6 = new android.location.Location(getString(R.string.TheShard));
        location6.setLatitude(51.5045);
        location6.setLongitude(-0.0886887);
        android.location.Location location7 = new android.location.Location(getString(R.string.SouthBank));
        location7.setLatitude(51.5021033);
        location7.setLongitude(-0.1224091);
        android.location.Location location8 = new android.location.Location(getString(R.string.TheTowerofLondon));
        location8.setLatitude(51.5072781);
        location8.setLongitude(-0.0770609);
        android.location.Location location9 = new android.location.Location(getString(R.string.TowerBridge));
        location9.setLatitude(51.5054564);
        location9.setLongitude(-0.0775452);
        android.location.Location location10 = new android.location.Location(getString(R.string.TrafalgarSquare));
        location10.setLatitude(51.50809);
        location10.setLongitude(-0.1291379);
        android.location.Location location11 = new android.location.Location(getString(R.string.WestminsterAbbey));
        location11.setLatitude(51.4993815);
        location11.setLongitude(-0.1286692);


        final ArrayList<Item> sightseeings = new ArrayList<>();

        sightseeings.add(new Item(getString(R.string.BigBen), getString(R.string.bigbendesc), getString(R.string.price0), R.drawable.bigben, location1));
        sightseeings.add(new Item (getString(R.string.BrickLaneLondon), getString(R.string.brickdesc), getString(R.string.price0), R.drawable.bricklane, location2));
        sightseeings.add(new Item(getString(R.string.BuckinghamPalace), getString(R.string.buckhimgdesc), getString(R.string.price4), R.drawable.buckinghampalace, location3));
        sightseeings.add(new Item(getString(R.string.CamdentheStables), getString(R.string.camdendesc), getString(R.string.price0), R.drawable.camden, location4));
        sightseeings.add(new Item(getString(R.string.LondonEye), getString(R.string.Londoneyedesc), getString(R.string.price1), R.drawable.londoneye, location5));
        sightseeings.add(new Item(getString(R.string.TheShard), getString(R.string.sharddesc), getString(R.string.price4), R.drawable.shard, location6));
        sightseeings.add(new Item(getString(R.string.SouthBank), getString(R.string.southbankdesc), getString(R.string.price0), R.drawable.southbank, location7));
        sightseeings.add(new Item(getString(R.string.TheTowerofLondon), getString(R.string.towerlondondesc), getString(R.string.price0), R.drawable.thetower, location8));
        sightseeings.add(new Item(getString(R.string.TowerBridge), getString(R.string.towerbridgedesc), getString(R.string.price0), R.drawable.towerbridge, location9));
        sightseeings.add(new Item (getString(R.string.TrafalgarSquare), getString(R.string.trafdesc), getString(R.string.price0), R.drawable.trafalgarsq, location10));
        sightseeings.add(new Item(getString(R.string.WestminsterAbbey), getString(R.string.westminsterdesc), getString(R.string.price4), R.drawable.westminster, location11));

        final ItemAdapter adapter = new ItemAdapter(this, sightseeings);

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        /** Onclick listener for map clicking */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = sightseeings.get(position).getLocation().getLatitude();
                double lon = sightseeings.get(position).getLocation().getLongitude();
                String keyword = sightseeings.get(position).getmTitle();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(keyword)
                        );

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });



    }
}
