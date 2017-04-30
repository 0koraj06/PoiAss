package com.example.jason.poiass; /**
 * Created by Jason on 30/04/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

import com.example.jason.poiass.R;

import org.osmdroid.views.MapView;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.config.Configuration;

public class SetLocation extends Activity implements OnClickListener {

    MapView mv;


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mv = (MapView) findViewById(R.id.map1);

        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(14);
        mv.getController().setCenter(new GeoPoint(51.3, -0.098));

        Button buttonlocation = (Button) findViewById(R.id.buttonlocation);
        buttonlocation.setOnClickListener(this);

    }

    public void onClick(View view) {





        EditText et1 = (EditText) findViewById(R.id.latitudelocation);
        double latitudelocation = Double.parseDouble(et1.getText().toString());
        EditText et2 = (EditText) findViewById(R.id.longitudelocation);
        double longitudelocation = Double.parseDouble(et2.getText().toString());
        mv.getController().setCenter(new GeoPoint(latitudelocation, longitudelocation));



    }
}
