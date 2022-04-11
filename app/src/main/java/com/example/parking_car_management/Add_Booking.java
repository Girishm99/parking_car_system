package com.example.parking_car_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class Add_Booking extends AppCompatActivity implements View.OnClickListener{

    private Button area1,area2,area3,area4;
    private Button area5,area6,area7,area8;
    private Button area9,area10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__booking);

        area1=findViewById(R.id.btn_area1);
        area2=findViewById(R.id.btn_area2);
        area3=findViewById(R.id.btn_area3);
        area4=findViewById(R.id.btn_area4);
        area5=findViewById(R.id.btn_area5);
        area6=findViewById(R.id.btn_area6);
        area7=findViewById(R.id.btn_area7);
        area8=findViewById(R.id.btn_area8);

        area1.setOnClickListener(this);
        area2.setOnClickListener(this);
        area3.setOnClickListener(this);
        area4.setOnClickListener(this);
        area5.setOnClickListener(this);
        area6.setOnClickListener(this);
        area7.setOnClickListener(this);
        area8.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        if (view==area1){

            String value = "Ghatkopar-East";
            Intent intent = new Intent(this, SlotActivity.class);
            intent.putExtra("key",value);
            startActivity(intent);
        }

        if (view==area2){
            String value = "Kamote";
            Intent intent = new Intent(this, SlotActivity.class);
            intent.putExtra("key",value);
            startActivity(intent);        }

        if (view==area3){
            String value = "Sion";
            Intent intent = new Intent(this, SlotActivity.class);
            intent.putExtra("key",value);
            startActivity(intent);        }

        if (view==area4){
            String value = "Matunga";
            Intent intent = new Intent(this, SlotActivity.class);
            intent.putExtra("key",value);
            startActivity(intent);        }

        if (view==area5){
            String value = "Badlapur";
            Intent intent = new Intent(this, SlotActivity.class);
            intent.putExtra("key",value);
            startActivity(intent);        }

        if (view==area6){
            String value = "Sanpada";
            Intent intent = new Intent(this, SlotActivity.class);
            intent.putExtra("key",value);
            startActivity(intent);        }

        if (view==area7){
            String value = "Seawood";
            Intent intent = new Intent(this, SlotActivity.class);
            intent.putExtra("key",value);
            startActivity(intent);        }

        if (view==area8){
            String value = "Nerul";
            Intent intent = new Intent(this, SlotActivity.class);
            intent.putExtra("key",value);
            startActivity(intent);        }

        if (view==area9){
            String value = "Thane";
            Intent intent = new Intent(this, SlotActivity.class);
            intent.putExtra("key",value);
            startActivity(intent);        }

        if (view==area10){
            String value = "Bhandup";
            Intent intent = new Intent(this, SlotActivity.class);
            intent.putExtra("key",value);
            startActivity(intent);        }
    }
}

