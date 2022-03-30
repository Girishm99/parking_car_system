package com.example.parking_car_management;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.EditText;
import android.widget.TextView;

public class About extends AppCompatActivity {

    private TextView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        about=findViewById(R.id.tv_about);


        about.setMovementMethod(new ScrollingMovementMethod());

        about.setText("Car parking System provides the records of the incoming and outgoing vehicles in a parking place. \n" +
                "\n" +
                "Nowadays in frequently visited places such as malls, multiplex system, hospitals, offices, market areas there is an avid problem of car parking .The user has to search for the plot round and round in the city. It helps in safe parking thereby relieving from the tension of vehicle towing\n" +
                "\n" +
                "The focus on this project is to generate Car Parking system that enables the time management. The system will consist data about the list of cars, parking slots and checks whether the slots are full or not.User can send feedback to admin.\n"+
                "\n" +
                "Admin can view all the user in the admin panel.Admin have the rights to delete user.Admin can also view feedback sent from user.And admin can also delete feedback.\n"+
                "\n" +
                "In this app we have two different phases i.e. user and admin.Were user will have rights to book slot,view booked slot,cancel booking,send feedback,rent slot,and view rented slot.Admin can view booked slot,cancel booked slot or delete feedback sent from user,and view the sent feedback.\n");

        about.getResources().getColor(R.color.white);
    }
}
