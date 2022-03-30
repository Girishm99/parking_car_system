package com.example.parking_car_management;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class AdminFeedback extends AppCompatActivity {

   DataHelper mydb;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_feedback);

        result=(TextView) findViewById(R.id.tv_adminfeedback);

        mydb = new DataHelper(this);

        result.setMovementMethod(new ScrollingMovementMethod());


        Cursor res = mydb.getAlldataadmin();

        StringBuffer buffer =new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("ID: "+res.getString(0)+"\n");
            buffer.append("Feedback: "+res.getString(1)+"\n");
        }
        result.setText(buffer);
    }
}
