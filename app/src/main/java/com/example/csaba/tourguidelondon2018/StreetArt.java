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

public class StreetArt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        /** locations */
        android.location.Location location1 = new android.location.Location(getString(R.string.BellLane));
        location1.setLatitude(51.5173037);
        location1.setLongitude(-0.0779103);
        android.location.Location location2 = new android.location.Location(getString(R.string.FashionStreet));
        location2.setLatitude(51.5184783);
        location2.setLongitude(-0.0744767);
        android.location.Location location3 = new android.location.Location(getString(R.string.GreatEasternStLondon));
        location3.setLatitude(51.5247198);
        location3.setLongitude(-0.0831063);
        android.location.Location location4 = new android.location.Location(getString(R.string.HeneageStreetLondon));
        location4.setLatitude(51.5189656);
        location4.setLongitude(-0.0724671);
        android.location.Location location5 = new android.location.Location(getString(R.string.PrinceletStreetLondon));
        location5.setLatitude(51.5197814);
        location5.setLongitude(-0.0733793);
        android.location.Location location6 = new android.location.Location(getString(R.string.RivingtonStreetLondon));
        location6.setLatitude(51.5261178);
        location6.setLongitude(-0.0828406);
        android.location.Location location7 = new android.location.Location(getString(R.string.ShoreditchHighStreet));
        location7.setLatitude(51.5243576);
        location7.setLongitude(-0.0794343);
        android.location.Location location8 = new android.location.Location(getString(R.string.ToynbeeStreet));
        location8.setLatitude(51.517547);
        location8.setLongitude(-0.07654);
        android.location.Location location9 = new android.location.Location(getString(R.string.AngelComedyClub));
        location9.setLatitude(51.5357857);
        location9.setLongitude(-0.103721);
        android.location.Location location10 = new android.location.Location(getString(R.string.PrinceletStreetLondon));
        location10.setLatitude(51.5197814);
        location10.setLongitude(-0.0733793);
        android.location.Location location11 = new android.location.Location(getString(R.string.PrinceletStreetLondon));
        location11.setLatitude(51.5197814);
        location11.setLongitude(-0.0733793);



        final ArrayList<Item> streetArt = new ArrayList<>();

        streetArt.add(new Item(getString(R.string.BellLane), getString(R.string.belllanear), " ", R.drawable.belllane, location1));
        streetArt.add(new Item(getString(R.string.FashionStreet), getString(R.string.belllanear), " ", R.drawable.fashionstreet, location2));
        streetArt.add(new Item(getString(R.string.GreatEasternStLondon), getString(R.string.greateasterndesc), " ", R.drawable.greateasternstreet, location3));
        streetArt.add(new Item(getString(R.string.HeneageStreetLondon), getString(R.string.heneagedesc), " ", R.drawable.heneagestreet, location4));
        streetArt.add(new Item(getString(R.string.PrinceletStreetLondon), getString(R.string.stik), " ", R.drawable.princeletstreet, location5));
        streetArt.add(new Item(getString(R.string.RivingtonStreetLondon), getString(R.string.banksy), " ", R.drawable.rivingtonstreet, location6));
        streetArt.add(new Item(getString(R.string.ShoreditchHighStreet), getString(R.string.gregos), " ", R.drawable.shoreditchhighstreet, location7));
        streetArt.add(new Item(getString(R.string.AngelComedyClub), getString(R.string.zabou), " ", R.drawable.zabou, location8));
        streetArt.add(new Item(getString(R.string.PrinceletStreetLondon), getString(R.string.stik), " ", R.drawable.princeletstreet, location9));
        streetArt.add(new Item(getString(R.string.PrinceletStreetLondon), getString(R.string.stik), " ", R.drawable.princeletstreet, location9));
        streetArt.add(new Item(getString(R.string.PrinceletStreetLondon), getString(R.string.stik), " ", R.drawable.princeletstreet, location9));

        final ItemAdapter adapter = new ItemAdapter(this, streetArt);

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        /** Onclick listener for map clicking */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = streetArt.get(position).getLocation().getLatitude();
                double lon = streetArt.get(position).getLocation().getLongitude();
                String keyword = streetArt.get(position).getmTitle();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(keyword)
                );

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });

    }
}
