package com.example.parking_car_management;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                if(validateData()){
                    add();

                }
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean validateData() {

        String macname = macName.getText().toString().trim();
        String mobno = macMobNo.getText().toString().trim();
        String address = macAddress.getText().toString().trim();
        String pincode = macPincode.getText().toString().trim();

        if ((TextUtils.isEmpty(macname)) ||Objects.isNull(macname)) {
            Toast.makeText(this, "Please enter name", Toast.LENGTH_LONG).show();
            return false;
        }


        if ((TextUtils.isEmpty(mobno)) || Objects.isNull(mobno)) {
            Toast.makeText(this, "Please enter Mobile no", Toast.LENGTH_LONG).show();
            return false;
        }

        if ((TextUtils.isEmpty(address)) || Objects.isNull(address)) {
            Toast.makeText(this, "Please enter Address", Toast.LENGTH_LONG).show();
            return false;
        }

        if ((TextUtils.isEmpty(pincode)) || Objects.isNull(pincode)) {
            Toast.makeText(this, "Please enter pincode", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;

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