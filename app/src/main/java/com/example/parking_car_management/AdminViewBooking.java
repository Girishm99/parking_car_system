package com.example.parking_car_management;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class AdminViewBooking extends AppCompatActivity {

    DataHelper mydb;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_booking);

        result=(TextView) findViewById(R.id.tv_adminview);

        mydb = new DataHelper(this);

        result.setMovementMethod(new ScrollingMovementMethod());


        Cursor res = mydb.getAlldata();

        StringBuffer buffer =new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Id :"+res.getString(0)+"\n");
            buffer.append("Name :"+res.getString(1)+"\n");
            buffer.append("Email: :"+res.getString(2)+"\n");
            buffer.append("Car Number:"+res.getString(3)+"\n");
        }
        result.setText(buffer);


    }
}
