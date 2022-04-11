package com.example.parking_car_management;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import static android.widget.Toast.LENGTH_SHORT;

public class ResetActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText passwordEmail;

    private Button resetPassword;

    private TextView back;


    /*private DatabaseReference myRef;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);





        passwordEmail=(EditText)findViewById(R.id.et_mail);
        resetPassword=(Button)findViewById(R.id.resetPassword);


        resetPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==resetPassword){
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.sendPasswordResetEmail(passwordEmail.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(ResetActivity.this,"Mail Successfully sent to ur Email", LENGTH_SHORT).show();
                                startActivity(new Intent(ResetActivity.this,LoginActivity.class));
                                finish();
                            }
                        }
                    });
        }
    }
}
