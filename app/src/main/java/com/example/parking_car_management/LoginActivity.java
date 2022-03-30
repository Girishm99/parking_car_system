package com.example.parking_car_management;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    RelativeLayout real1, real2;

    private Button btn_signup;
    private Button btn_login;
    private Button btn_forget;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    private EditText username;
    private EditText pd;

    private TextView imadmin;


    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            real1.setVisibility(View.VISIBLE);
            real2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_signup = (Button) findViewById(R.id.signup);
        btn_login=(Button)findViewById(R.id.signin);
        btn_forget=(Button)findViewById(R.id.forget);

        progressDialog=new ProgressDialog(this);

        firebaseAuth=FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(this,HomeActivity.class));
        }

        real1 = (RelativeLayout) findViewById(R.id.real1);
        real2 = (RelativeLayout) findViewById(R.id.real2);

        username=(EditText)findViewById(R.id.et_username);
        pd=(EditText)findViewById(R.id.et_password);

        imadmin=findViewById(R.id.tv_admin);

        btn_login.setOnClickListener(this);
        btn_signup.setOnClickListener(this);
        btn_forget.setOnClickListener(this);

        imadmin.setOnClickListener(this);

    }

    private void userLogin(){
        String email=username.getText().toString().trim();
        String password=pd.getText().toString().trim();
        if ((TextUtils.isEmpty(email))){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Login in process...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()){
                    checkEmailVerification();
                }
                else{
                    Toast.makeText(LoginActivity.this,"Login Failed",Toast.LENGTH_LONG).show();
                }

            }

        });
    }
    @Override
    public void onClick(View v) {
        if (v ==btn_login){
            userLogin();
        }
        if (v==btn_signup){
            finish();
            startActivity(new Intent(this,RegisterActivity.class));
        }

        if (v == btn_forget){
            finish();
            startActivity(new Intent(this,ResetActivity.class));
        }

        if (v==imadmin){
            finish();
            startActivity(new Intent(this,AdminActivity.class));
        }

    }
    private void checkEmailVerification(){
        FirebaseUser firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        Boolean emailverify=firebaseUser.isEmailVerified();

        if (emailverify){
            finish();
            startActivity(new Intent(this,HomeActivity.class));
        }
        else{
            Toast.makeText(this,"Verify your Email",Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }
}
