package com.example.parking_car_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdminHome extends AppCompatActivity implements View.OnClickListener {


    private Button adminview,admindelete,adminfeedback,adminhomemacdetails;
    private Button signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        adminview=findViewById(R.id.btn_adminhomeview);
        admindelete=findViewById(R.id.btn_adminhomedelete);
        adminfeedback=findViewById(R.id.btn_adminhomefeedback);
        adminhomemacdetails=findViewById(R.id.btn_adminhomemacdetails);
        signout=findViewById(R.id.btn_adminhomesignout);

        adminview.setOnClickListener(this);
        admindelete.setOnClickListener(this);
        adminfeedback.setOnClickListener(this);
        adminhomemacdetails.setOnClickListener(this);
        signout.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        if (view==adminview){
            startActivity(new Intent(this,AdminViewBooking.class));
        }
        if (view==admindelete){
            startActivity(new Intent(this,AdminDelete.class));
        }
        if (view==adminfeedback){
            startActivity(new Intent(this,AdminFeedback.class));
        }
        if (view==adminhomemacdetails){
            startActivity(new Intent(this,AdminViewMacDetails.class));
        }
        if (view==signout){
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
    }
}
