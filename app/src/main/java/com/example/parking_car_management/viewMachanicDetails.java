package com.example.parking_car_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class viewMachanicDetails extends AppCompatActivity {

    DataHelper mydb;
    private TextView text;
    Button find;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_machanic_details);
        text= findViewById(R.id.tv_macdetails);
        find= findViewById(R.id.btn_find);


        mydb = new DataHelper(this);

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Search for restaurants nearby
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=garage");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
//            startActivity(new Intent(this, ViewSlot.class));
            }
        });
        text.setMovementMethod(new ScrollingMovementMethod());
        Cursor res = mydb.getAllMacDetails();

        StringBuffer buffer =new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Machanic Id : "+res.getString(0)+"\n");
            buffer.append("Name : "+res.getString(1)+"\n");
            buffer.append("Mobile No. : "+res.getString(4)+"\n");
            buffer.append("Pincode :"+res.getString(2)+"\n");
            buffer.append("Address :"+res.getString(3)+"\n\n\n");
        }
        text.setText(buffer);


    }
}