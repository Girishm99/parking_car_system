package com.example.parking_car_management;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdminActivity extends AppCompatActivity implements View.OnClickListener {

    private Button adminlogin;

    private ProgressDialog progressDialog;

    private TextView imnotadmin;

    private EditText adminusername;
    private EditText adminpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        adminlogin=findViewById(R.id.btn_adminsignin);
        adminusername=findViewById(R.id.et_adminusername);
        adminpassword=findViewById(R.id.et_adminpassword);

        progressDialog=new ProgressDialog(this);

        imnotadmin=findViewById(R.id.tv_notadmin);

        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (adminusername.getText().toString().equals("admin") &&
                        adminpassword.getText().toString().equals("admin")){
                    startActivity(new Intent(AdminActivity.this,AdminHome.class));
                    finish();
                }
            }
        });
        imnotadmin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        if (view==imnotadmin){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
