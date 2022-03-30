package com.example.parking_car_management;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    @Override
    public void onClick(View view) {

        if (view==rent){
            add();
        }

        if (view==rentreset){

            rentname.setText("");
            rentaddress.setText("");
            rentslotid.setText("");

        }
    }

    public void add(){
        boolean isinserted =  mydb.insertslot(
                rentname.getText().toString(),
                rentaddress.getText().toString(),
                rentslotid.getText().toString());
        if (isinserted == true)
            Toast.makeText(RentSlot.this,"successfully Booked",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(RentSlot.this,"Failed to Book",Toast.LENGTH_SHORT).show();
    }

}
