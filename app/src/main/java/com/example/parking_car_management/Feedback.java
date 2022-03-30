package com.example.parking_car_management;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    DataHelper mydb;
    private EditText userfeedback;
    private Button usersubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        mydb = new DataHelper(this);

        userfeedback=findViewById(R.id.tv_feedbackuser);
        usersubmit=findViewById(R.id.btn_usersubmit);

        usersubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });

    }

    public void add(){
        boolean isinserted =  mydb.insertfeedback(userfeedback.getText().toString());
        if (isinserted == true)
            Toast.makeText(Feedback.this,"successfully Feedback sent",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(Feedback.this,"Failed to send Feedback",Toast.LENGTH_SHORT).show();
    }
}
