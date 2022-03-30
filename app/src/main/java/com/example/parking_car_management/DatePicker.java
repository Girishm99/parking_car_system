package com.example.parking_car_management;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.Date;

public class DatePicker extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog=new DatePickerDialog(getActivity(),
                (DatePickerDialog.OnDateSetListener)getActivity(),year,month,day);
        calendar.add(Calendar.DATE,0);
        Date newdate=calendar.getTime();
        dialog.getDatePicker().setMinDate(newdate.getTime()-(newdate.getTime()%(24*60*60*1000)));

        return dialog;
    }
}
