package com.example.mukki.place;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
TextView get_place;
int PLACE_PICKER_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get_place=(TextView)findViewById(R.id.textView);
        get_place.setOnClickListener(this);
        
    }


    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        if(requestCode==PLACE_PICKER_REQUEST)
        {
            if(resultCode==RESULT_OK)
            {
                Place place=PlacePicker.getPlace(data,this);
                String name=String.format("Place: %s",place.getName());
                get_place.setText(name);

            }
        }
    }


    @Override
    public void onClick(View view) {

        PlacePicker.IntentBuilder builder= new PlacePicker.IntentBuilder();
        Intent intent;

        try {
            intent=builder.build(this);
            startActivityForResult(intent,PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }

    }

    }

