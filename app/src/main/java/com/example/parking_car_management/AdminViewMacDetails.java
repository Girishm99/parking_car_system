package com.example.parking_car_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdminViewMacDetails extends AppCompatActivity {

    DataHelper mydb;
    private TextView text,breaktext;
    Button addDetails,deletemacDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_mac_details);
        text= findViewById(R.id.tv_macdetails);
        breaktext= findViewById(R.id.breakSpace);
        addDetails= findViewById(R.id.btn_addDetails);
        deletemacDetails= findViewById(R.id.btn_deleteMacDetails);


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

        addDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminViewMacDetails.this,AdminAddMachanic.class));
            }
        });

        deletemacDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminViewMacDetails.this,AdminDeleteMacdetails.class));
            }
        });

    }
}