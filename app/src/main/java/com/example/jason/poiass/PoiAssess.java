package com.example.jason.poiass;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.config.Configuration;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.OverlayItem;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class PoiAssess extends Activity {

    MapView mv;
        ItemizedIconOverlay<OverlayItem> items;
    ItemizedIconOverlay.OnItemGestureListener<OverlayItem> markerGestureListener;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This line sets the user agent, a requirement to download OSM maps
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));


        mv = (MapView) findViewById(R.id.map1);

        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(14);
        mv.getController().setCenter(new GeoPoint(51.5, -0.15));


        markerGestureListener = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>()
        {
            public boolean onItemLongPress(int i, OverlayItem item)
            {
                Toast.makeText(PoiAssess.this, item.getSnippet(), Toast.LENGTH_SHORT).show();
                return true;
            }

            public boolean onItemSingleTapUp(int i, OverlayItem item)
            {
                Toast.makeText(PoiAssess.this, item.getSnippet(), Toast.LENGTH_SHORT).show();
                return true;
            }
        };

        items = new ItemizedIconOverlay<OverlayItem>(this, new ArrayList<OverlayItem>(), markerGestureListener);

        OverlayItem fernhurst = new OverlayItem("Belgravia", "the village in London", new GeoPoint(51.5, -0.15));
        // NOTE is just this.getDrawable() if supporting API 21+ only
        items.addItem(fernhurst);



    mv.getOverlays().add(items);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.locationmenu, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // handles user selecting a menu item

        if (item.getItemId() == R.id.addPoi)

        {


            Intent intent = new Intent(this, AddPoi.class);
            startActivityForResult(intent, 0);
            return true;

        } else if (item.getItemId() == R.id.save) {



        return true;
        }

        return false;

    }



    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (resultCode == RESULT_OK) {

            if (requestCode == 0) {
                Bundle extras = intent.getExtras();
                String poiname = extras.getString("com.example.poiname");
                String poitype = extras.getString("com.example.poitype");
                String poidesc = extras.getString("com.example.poidesc");

                double lat = mv.getMapCenter().getLatitude();
                double lon = mv.getMapCenter().getLongitude();



                OverlayItem MarkerPoi = new OverlayItem(poiname, poitype, poidesc, new GeoPoint(lat, lon));
                items.addItem(MarkerPoi);


            }


        }

        }


    }

