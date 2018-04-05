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
        android.location.Location location1 = new android.location.Location("Alhambra Hotel");
        location1.setLatitude(51.5292885);
        location1.setLongitude(-0.1247364);
        android.location.Location location2 = new android.location.Location("grangeholborn");
        location2.setLatitude(51.519271);
        location2.setLongitude(-0.1233077);
        android.location.Location location3 = new android.location.Location("grangetowerhotel");
        location3.setLatitude(51.5220028);
        location3.setLongitude(-0.0739024);
        android.location.Location location4 = new android.location.Location("moxy");
        location4.setLatitude(51.5256545);
        location4.setLongitude(0.0026285);
        android.location.Location location5 = new android.location.Location("parkplaza");
        location5.setLatitude(51.5009568);
        location5.setLongitude(-0.1254412);
        android.location.Location location6 = new android.location.Location("Reemhotel");
        location6.setLatitude(51.5133946);
        location6.setLongitude(-0.1941466);
        android.location.Location location7 = new android.location.Location("Stgiles");
        location7.setLatitude(51.517473);
        location7.setLongitude(-0.1328781);
        android.location.Location location8 = new android.location.Location("Towerhotel");
        location8.setLatitude(51.5064438);
        location8.setLongitude(-0.0759838);
        android.location.Location location9 = new android.location.Location("Travelodge");
        location9.setLatitude(51.5109887);
        location9.setLongitude(-0.0756985);
        android.location.Location location10 = new android.location.Location("Westbury hotel");
        location10.setLatitude(51.5112954);
        location10.setLongitude(-0.144799);
        android.location.Location location11 = new android.location.Location("Park Plaza Victoria Hotel");
        location11.setLatitude(51.4942477);
        location11.setLongitude(-0.1440095);



        final ArrayList<Item> hotels = new ArrayList<>();

        hotels.add(new Item("Alhambra Hotel", "A mile from the British Museum", "£66", R.drawable.alhambra, location1));
        hotels.add(new Item("Grangeholborn Hotel", "a 5-minute walk from the British Museum", "£100", R.drawable.grangeholborn, location2));
        hotels.add(new Item("Grangetowerhotel", "Brick Lane", "£60", R.drawable.grangetowerhotel, location3));
        hotels.add(new Item("MOXY Stratford Hotel", " 6-minute walk from Westfield Stratford City shopping centre", "£65", R.drawable.moxy, location4));
        hotels.add(new Item("Parkplaza Hotel", "5-minute walk from the London Eye and a mile from Big Ben", "£120", R.drawable.parkplaza, location5));
        hotels.add(new Item("Reemhotel", "a Victorian townhouse, this simple hotel in leafy Prince's Square is a 6-minute walk from Kensington Palace ", "£110", R.drawable.reemhotel, location6));
        hotels.add(new Item("St Giles Hotel", "Located a block from the Tottenham Court Road tube station and shopping on Oxford Street,", "£100", R.drawable.stgiles,location7));
        hotels.add(new Item("Towerhotel", "On the River Thames next to Tower Bridge, this sprawling modern hotel", "£95", R.drawable.towerhotel, location8));
        hotels.add(new Item("Travelodge Hotel", "the verge of the City of London and the trendy East End, this low-key budget hotel is a 5-minute walk from Tower Hill ", "£112", R.drawable.travelodge, location9));
        hotels.add(new Item("Westburyhotel", "A 2-minute walk from the renowned Harrods department store, this high-end hotel in the prestigious Mayfair district ", "£255", R.drawable.westburyhotel, location10));
        hotels.add(new Item("Park Plaza Victoria Hotel", "4-minute walk from Victoria railway/underground station, this straightforward conference hotel is within a mile of both Buckingham Palace ", "£135", R.drawable.parkplazavictoria, location11));

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