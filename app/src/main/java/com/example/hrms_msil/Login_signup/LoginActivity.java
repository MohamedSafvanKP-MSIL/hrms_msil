package com.example.hrms_msil.Login_signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hrms_msil.Fragments.MainActivity;
import com.example.hrms_msil.R;
import com.example.hrms_msil.User;
import com.example.hrms_msil.UserDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LoginActivity extends AppCompatActivity {
    EditText employeeIdEditText;
    EditText mpinEditText;
    Button loginButton;
    TextView signupTextView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        employeeIdEditText = findViewById(R.id.employeeIdEditText);
        employeeIdEditText.setText(getIntent().getStringExtra("list"));

        mpinEditText = findViewById(R.id.mpin);
        loginButton = findViewById(R.id.loginButton);
        signupTextView = findViewById(R.id.signupTextView);

        String mPin=mpinEditText.getText().toString();


        mpinEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
              if(mPin.length()!=6){
                  mpinEditText.setError("Mpin must be a six digit number");

              }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String employeeId=employeeIdEditText.getText().toString();
                if(employeeId.isEmpty()) {
                    employeeIdEditText.setError("Employee ID cant be empty");
                    return;

                }

                UserDatabase userDatabase=UserDatabase.getDB(getApplicationContext());
                List<User> loggingList = userDatabase.userDao().getAllUser();
                List<User> filterdList = loggingList.stream().filter(user -> user.getUid()==
                        Integer.parseInt(String.valueOf(employeeIdEditText.getText()))).collect(Collectors.toList());

                  if(filterdList.get(0).mPin.equals(String.valueOf(mpinEditText.getText()))){
                    Intent intent2=new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent2);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });
     signupTextView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent3=new Intent(LoginActivity.this,SignUpActivity.class);
             startActivity(intent3);
         }
     });
    }
}