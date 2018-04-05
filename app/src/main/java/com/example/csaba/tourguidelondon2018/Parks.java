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

public class Parks extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        /** locations */
        android.location.Location location1 = new android.location.Location("Alexandra Park");
        location1.setLatitude(51.5947572);
        location1.setLongitude(-0.1285046);
        android.location.Location location2 = new android.location.Location("Chelsea Physic Garden");
        location2.setLatitude(51.484612);
        location2.setLongitude(-0.1656487);
        android.location.Location location3 = new android.location.Location("Greenwich Park");
        location3.setLatitude(51.473592);
        location3.setLongitude(-0.0012227);
        android.location.Location location4 = new android.location.Location("Hampstead Heath");
        location4.setLatitude(51.5773524);
        location4.setLongitude(-0.1523526);
        android.location.Location location5 = new android.location.Location("Hyde Park");
        location5.setLatitude(51.5072682);
        location5.setLongitude(-0.167919);
        android.location.Location location6 = new android.location.Location("Queen Elizabeth Olympic Park");
        location6.setLatitude(51.5432961);
        location6.setLongitude(-0.0187404);
        android.location.Location location7 = new android.location.Location("Regents Park");
        location7.setLatitude(51.5326911);
        location7.setLongitude(-0.1507498);
        android.location.Location location8 = new android.location.Location("Richmond Park");
        location8.setLatitude(51.4463869);
        location8.setLongitude(-0.2932822);
        android.location.Location location9 = new android.location.Location("Royal Botanic Gardens, Kew, Richmond");
        location9.setLatitude(51.4787438);
        location9.setLongitude(-0.2977617);
        android.location.Location location10 = new android.location.Location("St James's Park");
        location10.setLatitude(51.5024597);
        location10.setLongitude(-0.1369996);
        android.location.Location location11 = new android.location.Location("Woodberry Wetlands");
        location11.setLatitude(51.5709756);
        location11.setLongitude(-0.0907153);





        final ArrayList<Item> parks = new ArrayList<>();

        parks.add(new Item("Alexandra Park", "Big park with tree-lined jogging paths, a boating lake, kids’ playgrounds & resident fallow deer.", "£0", R.drawable.alexandrapark, location1));
        parks.add(new Item("Chelsea Physic Garden", "Chelsea, London SW3 5TS", "£0", R.drawable.chelseaphysicgarden, location2));
        parks.add(new Item("Greenwich Park", "Greenwich, London SE10 8QY", "£0", R.drawable.greenwichpark, location3));
        parks.add(new Item("Hampstead Heath", "Green oasis for recreation, with swimming ponds, woodland and city views from Parliament Hill.", "£0", R.drawable.hampsteadheath, location4));
        parks.add(new Item("Hyde Park", "Huge green space, home to Diana Memorial Fountain, with boating and swimming in the Serpentine lake.", "£0", R.drawable.hydepark, location5));
        parks.add(new Item("Queen Elizabeth Olympic Park", "Bridges, wild land and play parks weave a latticework around London's 2012 Olympic venues.", "£0", R.drawable.queen_elizabeth_olympic_park_original, location6));
        parks.add(new Item("Regents Park", "Modern, glass-clad cafe and sports administrative centre, with pitches and changing rooms.", "£0", R.drawable.regentsparkavenue, location7));
        parks.add(new Item("Richmond Park", "Expansive walled park, originally a 17th-century hunting ground and still home to hundreds of deer.", "£0", R.drawable.richmondpark, location8));
        parks.add(new Item("Royal Botanic Gardens, Kew, Richmond", "Trees and flowers from around the globe in vast gardens with huge greenhouses and Treetop Walkway.", "£10", R.drawable.royalbotanicgardenskew, location9));
        parks.add(new Item("St James's Park", "Green space with a lake with daily pelican feeding, a grass-roofed cafe and ceremonial displays.", "£0", R.drawable.stjamespark, location10));
        parks.add(new Item("Woodberry Wetlands", "Nature reserve", "£0", R.drawable.woodberrywetlands, location11));

        final ItemAdapter adapter = new ItemAdapter(this, parks);

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        /** Onclick listener for map clicking */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = parks.get(position).getLocation().getLatitude();
                double lon = parks.get(position).getLocation().getLongitude();
                String keyword = parks.get(position).getmTitle();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(keyword)
                );

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });

    }
}
