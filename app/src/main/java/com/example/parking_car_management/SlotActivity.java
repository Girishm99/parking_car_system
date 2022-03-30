package com.example.parking_car_management;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import java.util.Calendar;

public class SlotActivity extends AppCompatActivity implements View.OnClickListener,DatePickerDialog.OnDateSetListener{

    private static final String TAG="SlotActivity";

    private TextView displaydate;

    DataHelper mydb;

    private static long second= 0;

    private EditText name,email,car_number,time;

    private Button btn1,reset;
    private Button btn2,btn3;
    private Button btn4,btn5,btn6;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot);

       displaydate=findViewById(R.id.datepicker);


        mydb = new DataHelper(this);

        name=(EditText)findViewById(R.id.et_name);
        email=(EditText)findViewById(R.id.et_bookingEmail);
        car_number=(EditText)findViewById(R.id.et_carnumber);
        time=(EditText)findViewById(R.id.et_timer);

        reset=(Button)findViewById(R.id.btn_reset);

        btn1=(Button)findViewById(R.id.btn_slot1);
        btn2=(Button)findViewById(R.id.btn_slot2);
        btn3=(Button)findViewById(R.id.btn_slot3);
        btn4=(Button)findViewById(R.id.btn_slot4);
        btn5=(Button)findViewById(R.id.btn_slot5);
        btn6=(Button)findViewById(R.id.btn_slot6);

        displaydate.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        reset.setOnClickListener(this);

        awesomeValidation=new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.et_name, RegexTemplate.NOT_EMPTY,R.string.invalid_name);

        awesomeValidation.addValidation(this,R.id.et_bookingEmail,RegexTemplate.NOT_EMPTY,R.string.invalid_email1);

        awesomeValidation.addValidation(this,R.id.et_bookingEmail, Patterns.EMAIL_ADDRESS,R.string.invalid_email);

        awesomeValidation.addValidation(this,R.id.et_carnumber,RegexTemplate.NOT_EMPTY,R.string.invalid_carnumber);

        awesomeValidation.addValidation(this,R.id.et_timer,RegexTemplate.NOT_EMPTY,R.string.invalid_timer);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.datepicker:
                com.example.parking_car_management.DatePicker datePicker=new com.example.parking_car_management.DatePicker();
                datePicker.show(getSupportFragmentManager(),"Date picker");
                break;
        }

        if (view==btn1){
            add();
            int kisan=Integer.parseInt(time.getText().toString());
            second=kisan*1000;
            btn1.setBackgroundResource(R.color.colorAccent);

            btn1.setEnabled(false);
            btn1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn1.setEnabled(true);
                    btn1.setBackgroundResource(R.color.colorPrimaryDark);
                }
            },second);
        }


        if (view==btn2){

            add();
            int kisan=Integer.parseInt(time.getText().toString());
            second=kisan*1000;
            btn2.setBackgroundResource(R.color.colorAccent);

            btn2.setEnabled(false);
            btn2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn2.setEnabled(true);
                    btn2.setBackgroundResource(R.color.colorPrimaryDark);
                }
            },second);
        }

        if (view==btn3){

            add();
            int kisan=Integer.parseInt(time.getText().toString());
            second=kisan*1000;
            btn3.setBackgroundResource(R.color.colorAccent);

            btn3.setEnabled(false);
            btn3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn3.setEnabled(true);
                    btn3.setBackgroundResource(R.color.colorPrimaryDark);
                }
            },second);
        }

        if (view==btn4){

            add();
            int kisan=Integer.parseInt(time.getText().toString());
            second=kisan*1000;
            btn4.setBackgroundResource(R.color.colorAccent);

            btn4.setEnabled(false);
            btn4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn4.setEnabled(true);
                    btn4.setBackgroundResource(R.color.colorPrimaryDark);
                }
            },second);
        }

        if (view==btn5){

            add();
            int kisan=Integer.parseInt(time.getText().toString());
            second=kisan*1000;
            btn5.setBackgroundResource(R.color.colorAccent);

            btn5.setEnabled(false);
            btn5.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn5.setEnabled(true);
                    btn5.setBackgroundResource(R.color.colorPrimaryDark);
                }
            },second);
        }

        if (view==btn6){

            add();
            int kisan=Integer.parseInt(time.getText().toString());
            second=kisan*1000;
            btn6.setBackgroundResource(R.color.colorAccent);

            btn6.setEnabled(false);
            btn6.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn6.setEnabled(true);
                    btn6.setBackgroundResource(R.color.colorPrimaryDark);
                }
            },second);
        }

        if (view==reset){
            reset();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    public void add(){
        boolean isinserted =  mydb.insertdata(
                name.getText().toString(),
                email.getText().toString(),
                car_number.getText().toString());
        if (isinserted == true)
            Toast.makeText(SlotActivity.this,"successfully Booked",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(SlotActivity.this,"Failed to Book",Toast.LENGTH_SHORT).show();
    }

    public void reset(){
        email.setText("");
        name.setText("");
        car_number.setText("");
        time.setText("");
        displaydate.setText("Select a date");
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.DAY_OF_MONTH,day);
        int currenMonth =month+1;
        displaydate.setText(day+"/"+currenMonth+"/"+year);
    }
}
