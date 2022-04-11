package com.example.parking_car_management;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
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

import org.json.simple.JSONObject;

import java.util.Calendar;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SlotActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private static final String TAG = "SlotActivity";

    private TextView displaydate;

    DataHelper mydb;

    private static long second = 0;

    private EditText name, email, car_number, time;

    private Button btn1, reset;
    private Button btn2, btn3;
    private Button btn4, btn5, btn6;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot);

        displaydate = findViewById(R.id.datepicker);


        mydb = new DataHelper(this);

        name = (EditText) findViewById(R.id.et_name);
        email = (EditText) findViewById(R.id.et_bookingEmail);
        car_number = (EditText) findViewById(R.id.et_carnumber);
        time = (EditText) findViewById(R.id.et_timer);

        reset = (Button) findViewById(R.id.btn_reset);

        btn1 = (Button) findViewById(R.id.btn_slot1);
        btn2 = (Button) findViewById(R.id.btn_slot2);
        btn3 = (Button) findViewById(R.id.btn_slot3);
        btn4 = (Button) findViewById(R.id.btn_slot4);


        displaydate.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        reset.setOnClickListener(this);


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.datepicker:
                com.example.parking_car_management.DatePicker datePicker = new com.example.parking_car_management.DatePicker();
                datePicker.show(getSupportFragmentManager(), "Date picker");
                break;
        }

        Intent intent = getIntent();
        String placeName = intent.getStringExtra("key");

            if (view == btn1) {
                if (validateData()) {

                    add(""+placeName+",slot-1");
                    int kisan = Integer.parseInt(time.getText().toString());
                    second = kisan * 1000;
                    btn1.setBackgroundResource(R.color.colorAccent);

                    btn1.setEnabled(false);
                    btn1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btn1.setEnabled(true);
                            btn1.setBackgroundResource(R.color.colorPrimaryDark);
                        }
                    }, second);
                    reset();
                } else {
                    reset();
                }

            }


            if (view == btn2) {
                validateData();
                add(""+placeName+",slot-2");
                int kisan = Integer.parseInt(time.getText().toString());
                second = kisan * 1000;
                btn2.setBackgroundResource(R.color.colorAccent);

                btn2.setEnabled(false);
                btn2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn2.setEnabled(true);
                        btn2.setBackgroundResource(R.color.colorPrimaryDark);
                    }
                }, second);
            }

            if (view == btn3) {
                validateData();
                add(""+placeName+",slot-3");
                int kisan = Integer.parseInt(time.getText().toString());
                second = kisan * 1000;
                btn3.setBackgroundResource(R.color.colorAccent);

                btn3.setEnabled(false);
                btn3.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn3.setEnabled(true);
                        btn3.setBackgroundResource(R.color.colorPrimaryDark);
                    }
                }, second);
            }

            if (view == btn4) {
                validateData();

                add(""+placeName+",slot-4");
                int kisan = Integer.parseInt(time.getText().toString());
                second = kisan * 1000;
                btn4.setBackgroundResource(R.color.colorAccent);

                btn4.setEnabled(false);
                btn4.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn4.setEnabled(true);
                        btn4.setBackgroundResource(R.color.colorPrimaryDark);
                    }
                }, second);
            }
            if (view == reset) {
                reset();
            }
        }


    @Override
    protected void onResume() {
        super.onResume();
    }

    public void add(String address) {
        boolean isinserted = mydb.insertdata(
                name.getText().toString(),
                email.getText().toString(),
                address,
                car_number.getText().toString());
        if (isinserted == true)
            Toast.makeText(SlotActivity.this, "successfully Booked", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(SlotActivity.this, "Failed to Book", Toast.LENGTH_SHORT).show();
    }

    public void reset() {
        email.setText("");
        name.setText("");
        car_number.setText("");
        time.setText("");
        displaydate.setText("Select a date");
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        int currenMonth = month + 1;
        displaydate.setText(day + "/" + currenMonth + "/" + year);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean validateData() {

        String slotEmail = email.getText().toString().trim();

        String regex = "^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
                + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$";

        Matcher emailregex = Pattern.compile(regex).matcher(slotEmail);

        if ((TextUtils.isEmpty(slotEmail)) || (emailregex.matches()) || Objects.isNull(email)) {
            Toast.makeText(this, "Please enter valid Email ID", Toast.LENGTH_LONG).show();
            return false;
        }


        String slotname = name.getText().toString().trim();
        if ((TextUtils.isEmpty(slotname)) || Objects.isNull(slotname)) {
            Toast.makeText(this, "Please enter Name", Toast.LENGTH_LONG).show();
            return false;
        }


        String slotcarno = car_number.getText().toString().trim();
        slotcarno = slotcarno.toUpperCase();
        Matcher m = Pattern.compile("[A-Z]{2}+[0-9]{2}+[a-z]{2}+[0,9]{0}+[0-9]{4}").matcher(slotcarno);
        if ((TextUtils.isEmpty(slotcarno)) || (m.matches()) ) {
            Toast.makeText(this, "Please enter Valid car Number", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;

    }
}
