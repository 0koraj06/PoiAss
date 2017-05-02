package com.example.jason.poiass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import org.osmdroid.views.MapView;


public class AddPoi extends Activity implements View.OnClickListener {
@Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.poiadd);





        Button b = (Button) findViewById(R.id.buttonpoi);
        b.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {




        EditText et1 = (EditText) findViewById(R.id.poiname);
        String poiname = et1.getText().toString();
        EditText et2 = (EditText) findViewById(R.id.poitype);
        String poitype = et2.getText().toString();
        EditText et3 = (EditText) findViewById(R.id.poidesc);
        String poidesc = et3.getText().toString();



        Bundle bundle = new Bundle();
        bundle.putString("com.example.poiname", poiname);
        bundle.putString("com.example.poitype", poitype);
        bundle.putString("com.example.poidesc", poidesc);

        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();



    }
}



