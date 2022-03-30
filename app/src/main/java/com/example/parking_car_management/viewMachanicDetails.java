package com.example.parking_car_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class viewMachanicDetails extends AppCompatActivity {

    DataHelper mydb;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_machanic_details);
        text= findViewById(R.id.tv_macdetails);


        mydb = new DataHelper(this);

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