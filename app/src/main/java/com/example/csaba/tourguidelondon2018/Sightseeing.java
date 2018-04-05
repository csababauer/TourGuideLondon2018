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
        android.location.Location location1 = new android.location.Location("Big Ben");
        location1.setLatitude(51.5007292);
        location1.setLongitude(-0.1268141);
        android.location.Location location2 = new android.location.Location("Brick Lane, London");
        location2.setLatitude(51.5224618);
        location2.setLongitude(-0.073335);
        android.location.Location location3 = new android.location.Location("Buckingham Palace");
        location3.setLatitude(51.501364);
        location3.setLongitude(-0.1440787);
        android.location.Location location4 = new android.location.Location("Camden Market and the Stables");
        location4.setLatitude(51.5423591);
        location4.setLongitude(-0.1494229);
        android.location.Location location5 = new android.location.Location("London Eye");
        location5.setLatitude(51.5009095);
        location5.setLongitude(-0.121721);
        android.location.Location location6 = new android.location.Location("The Shard");
        location6.setLatitude(51.5045);
        location6.setLongitude(-0.0886887);
        android.location.Location location7 = new android.location.Location("South Bank");
        location7.setLatitude(51.5021033);
        location7.setLongitude(-0.1224091);
        android.location.Location location8 = new android.location.Location("The Tower of London");
        location8.setLatitude(51.5072781);
        location8.setLongitude(-0.0770609);
        android.location.Location location9 = new android.location.Location("The Tower Bridge");
        location9.setLatitude(51.5054564);
        location9.setLongitude(-0.0775452);
        android.location.Location location10 = new android.location.Location("Trafalgar Square");
        location10.setLatitude(51.50809);
        location10.setLongitude(-0.1291379);
        android.location.Location location11 = new android.location.Location("Westminster Abbey");
        location11.setLatitude(51.4993815);
        location11.setLongitude(-0.1286692);






        final ArrayList<Item> sightseeings = new ArrayList<>();

        sightseeings.add(new Item("Big Ben", "16-storey Gothic clocktower and national symbol at the Eastern end of the Houses of Parliament.", "£0", R.drawable.bigben, location1));
        sightseeings.add(new Item("Brick Lane, London", "street art", "£0", R.drawable.bricklane, location2));
        sightseeings.add(new Item("Buckingham Palace", "Visitors can tour the palace's opulent private and state rooms or watch the changing of the guard.", "£20", R.drawable.buckinghampalace, location3));
        sightseeings.add(new Item("Camden Market and the Stables", "market", "£0", R.drawable.camden, location4));
        sightseeings.add(new Item("London Eye", "The London Eye is a giant Ferris wheel on the South Bank of the River Thames in London.", "£33", R.drawable.londoneye, location5));
        sightseeings.add(new Item("The Shard", "87-floor glass skyscraper with a jagged peak, with restaurants, offices, hotel and viewing platform.", "£24.95", R.drawable.shard, location6));
        sightseeings.add(new Item("South Bank", "Right beside the River Thames", "£0", R.drawable.southbank, location7));
        sightseeings.add(new Item("The Tower of London", " Her Majesty's Royal Palace and Fortress of the Tower of London", "£29", R.drawable.thetower, location8));
        sightseeings.add(new Item("Tower Bridge", "Panoramic views from high level walkways and behind-the-scenes access to original lifting machinery.", "£20", R.drawable.towerbridge, location9));
        sightseeings.add(new Item("Trafalgar Square", "Nelson's Column rises above this iconic square's LED-lit fountains, artworks and lion statues.", "0", R.drawable.trafalgarsq, location10));
        sightseeings.add(new Item("Westminster Abbey", "Protestant abbey hosting daily services and every English and British coronation since 1066.", "£19", R.drawable.westminster, location11));

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
