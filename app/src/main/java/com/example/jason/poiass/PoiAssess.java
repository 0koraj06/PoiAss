package com.example.jason.poiass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.config.Configuration;


public class PoiAssess extends Activity implements OnClickListener {

    MapView mv;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This line sets the user agent, a requirement to download OSM maps
       Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));



        mv = (MapView)findViewById(R.id.map1);

        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(14);
        mv.getController().setCenter(new GeoPoint(51.05,-0.72));


    }



    public void onClick(View view) {
        EditText et1 = (EditText) findViewById(R.id.latitudelocation);
        double latitude = Double.parseDouble(et1.getText().toString());

        EditText et2 = (EditText) findViewById(R.id.longitudelocation);
        double longitude = Double.parseDouble(et2.getText().toString());

        mv.getController().setCenter(new GeoPoint(latitude, longitude));

    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.locationmenu, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item)
    // handles user selecting a menu item
    {
        if (item.getItemId() == R.id.setlocation) {


            Intent intent = new Intent(this, SetLocation.class);
            startActivity(intent);
            return true;
        }
        return false;
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (resultCode == RESULT_OK) {

            if (requestCode == 0) {
                Bundle extras = intent.getExtras();
                double langitudelocation = extras.getDouble("com.example.SetLatitude");
                double longitudelocation = extras.getDouble("com.example.SetLongitude");
                mv.getController().setCenter(new GeoPoint(langitudelocation, longitudelocation));
            }

        }
    }


}