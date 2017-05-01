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

public class SetLocation extends Activity implements View.OnClickListener {

    MapView mv;


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);





        Button b = (Button) findViewById(R.id.buttonlocation);
        b.setOnClickListener(this);

    }

    public void onClick(View view) {





        EditText et1 = (EditText) findViewById(R.id.latitudelocation);
        double latitudelocation = Double.parseDouble(et1.getText().toString());
        EditText et2 = (EditText) findViewById(R.id.longitudelocation);
        double longitudelocation = Double.parseDouble(et2.getText().toString());



        Bundle bundle = new Bundle();
        bundle.putDouble("com.example.latitudelocation", latitudelocation);
        bundle.putDouble("com.example.longitudelocation", longitudelocation);

        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();


    }
}
