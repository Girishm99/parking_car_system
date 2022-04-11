package com.example.parking_car_management;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class RentSlot extends AppCompatActivity implements View.OnClickListener {

    private EditText rentname,rentaddress,rentslotid;
    private Button rent,rentreset;
    DataHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_slot);

        rentname=findViewById(R.id.et_rentname);
        rentaddress=findViewById(R.id.et_rentaddress);
        rentslotid=findViewById(R.id.et_rentslotid);

        rent=findViewById(R.id.btn_rent);
        rentreset=findViewById(R.id.btn_rentreset);

        mydb = new DataHelper(this);

        rentreset.setOnClickListener(this);
        rent.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {

        if (view==rent){
            if(validate()){
                add();
            }
        }

        if (view==rentreset){

            rentname.setText("");
            rentaddress.setText("");
            rentslotid.setText("");

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean validate(){
        String rentName = rentname.getText().toString().trim();
        if ((TextUtils.isEmpty(rentName)) || Objects.isNull(rentName)) {
            Toast.makeText(this, "Please Enter Name", Toast.LENGTH_LONG).show();
            return false;
        }

        String rentAddress = rentaddress.getText().toString().trim();
        if ((TextUtils.isEmpty(rentAddress)) || Objects.isNull(rentAddress)) {
            Toast.makeText(this, "Please Enter Address", Toast.LENGTH_LONG).show();
            return false;
        }

        String rentid = rentslotid.getText().toString().trim();
        if ((TextUtils.isEmpty(rentid)) || Objects.isNull(rentid)) {
            Toast.makeText(this, "Please Enter Slot ID", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    public void add(){
        boolean isinserted =  mydb.insertslot(
                rentname.getText().toString(),
                rentaddress.getText().toString(),
                rentslotid.getText().toString());
        if (isinserted == true)
            Toast.makeText(RentSlot.this,"successfully Rented",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(RentSlot.this,"Failed to Book",Toast.LENGTH_SHORT).show();
    }

}
