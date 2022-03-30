package com.example.parking_car_management;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class ViewSlot extends AppCompatActivity {

    DataHelper mydb;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_slot);

        result=(TextView) findViewById(R.id.tv_viewrentdata);

        mydb = new DataHelper(this);

        result.setMovementMethod(new ScrollingMovementMethod());


        Cursor res = mydb.getAlldataslot();

        StringBuffer buffer =new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Id :"+res.getString(0)+"\n");
            buffer.append("Name :"+res.getString(1)+"\n");
            buffer.append("Address: "+res.getString(3)+"\n");
            buffer.append("Slot Id:"+res.getString(2)+"\n\n");
        }
        result.setText(buffer);
    }
}
