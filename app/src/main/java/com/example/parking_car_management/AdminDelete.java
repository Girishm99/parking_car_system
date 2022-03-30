package com.example.parking_car_management;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminDelete extends AppCompatActivity implements View.OnClickListener {

    DataHelper mydb;
    private Button delete,reset,cancel,canreset;
    private EditText et_id,et_feed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete);

        delete=(Button)findViewById(R.id.btn_admindelete);
        reset=(Button)findViewById(R.id.btn_adminreset);
        et_id=(EditText)findViewById(R.id.et_admindel);
        cancel=findViewById(R.id.btn_adminfeedcan);
        et_feed=findViewById(R.id.et_adminfeed);
        canreset=findViewById(R.id.btn_adminresetcan);

        canreset.setOnClickListener(this);
        reset.setOnClickListener(this);
        mydb = new DataHelper(this);
        deletedata();
        deletedatafeed();
    }

    @Override
    public void onClick(View view) {
        if (view==reset){
            et_id.setText("");
        }

        if (view==canreset){
            et_feed.setText("");
        }

    }

    public void deletedata(){
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer delete= mydb.deletedata(et_id.getText().toString());
                if (delete > 0)
                    Toast.makeText(AdminDelete.this,"Booking cancelled ",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminDelete.this,"Failed to cancel Booking",Toast.LENGTH_SHORT).show();
            }

        });
    }

    public void deletedatafeed(){
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer delete= mydb.deletedataadmin(et_feed.getText().toString());
                if (delete > 0)
                    Toast.makeText(AdminDelete.this,"Successfully Removed Feedback ",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminDelete.this,"Failed to Remove Feedback",Toast.LENGTH_SHORT).show();
            }

        });
    }
}
