package com.example.parking_car_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminDeleteMacdetails extends AppCompatActivity implements View.OnClickListener {

    DataHelper mydb;
    private Button delete, reset;
    private EditText et_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete_macdetails);

        delete = findViewById(R.id.btn_deleteDATA);
        reset = findViewById(R.id.btn_reset);
        et_id = findViewById(R.id.et_del);

        reset.setOnClickListener(this);
        mydb = new DataHelper(this);
        deletedata();

    }

    @Override
    public void onClick(View view) {

        if (view == reset) {
            et_id.setText("");
        }

    }

    public void deletedata() {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer delete = mydb.deleteMacData(et_id.getText().toString());
                if (delete > 0) {
                    Toast.makeText(AdminDeleteMacdetails.this, "Machanic Details successfully Deleted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), AdminViewMacDetails.class);
                    startActivity(intent);
                }

                else{
                    Toast.makeText(AdminDeleteMacdetails.this, "Failed to Delete Machanic Details", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), AdminViewMacDetails.class);
                    startActivity(intent);
                }

            }

        });
    }


}
