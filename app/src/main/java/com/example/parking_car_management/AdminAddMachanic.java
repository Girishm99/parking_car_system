package com.example.parking_car_management;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminAddMachanic extends AppCompatActivity {

    DataHelper mydb;
    private EditText macName, macMobNo, macAddress, macPincode;
    private Button save, reset;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_machanic);

        mydb = new DataHelper(this);

        macName = findViewById(R.id.et_macName);
        macMobNo = findViewById(R.id.et_mobilenumber);
        macAddress = findViewById(R.id.et_address);
        macPincode = findViewById(R.id.et_pincode);
        save = findViewById(R.id.btn_save);
        reset = findViewById(R.id.btn_reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                macName.setText("");
                macMobNo.setText("");
                macAddress.setText("");
                macPincode.setText("");
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });


    }

    public void add() {
        boolean isinserted = mydb.insertmacdetails(macName.getText().toString(), macMobNo.getText().toString(), macPincode.getText().toString(), macAddress.getText().toString());
        if (isinserted) {
            Toast.makeText(AdminAddMachanic.this, "successfully Saved", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), AdminViewMacDetails.class);
            startActivity(intent);

        } else {
            Toast.makeText(AdminAddMachanic.this, "Failed to Save The data", Toast.LENGTH_SHORT).show();
        }
    }
}