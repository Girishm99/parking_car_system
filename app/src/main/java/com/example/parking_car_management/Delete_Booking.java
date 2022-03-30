package com.example.parking_car_management;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete_Booking extends AppCompatActivity implements View.OnClickListener {

    DataHelper mydb;
    private Button delete,reset;
    private EditText et_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete__booking);

        delete=(Button)findViewById(R.id.btn_deleteDATA);
        reset=(Button)findViewById(R.id.btn_deletereset);
        et_id=(EditText)findViewById(R.id.et_del);

        reset.setOnClickListener(this);
        mydb = new DataHelper(this);
        deletedata();

    }

    @Override
    public void onClick(View view) {

        if (view==reset){
            et_id.setText("");
        }

    }

    public void deletedata(){
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer delete= mydb.deletedata(et_id.getText().toString());
                if (delete > 0)
                    Toast.makeText(Delete_Booking.this,"Booking cancelled ",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Delete_Booking.this,"Failed to cancel Booking",Toast.LENGTH_SHORT).show();
            }

        });
    }


}
