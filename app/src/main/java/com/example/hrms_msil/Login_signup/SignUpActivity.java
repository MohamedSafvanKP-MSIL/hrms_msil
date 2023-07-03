package com.example.hrms_msil.Login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hrms_msil.R;
import com.example.hrms_msil.User;
import com.example.hrms_msil.UserDatabase;

import java.util.List;

public class SignUpActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText mpinEditText;
    private EditText confirmMpinEditText;
    private Button signupButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

            emailEditText = findViewById(R.id.email);

        mpinEditText = findViewById(R.id.mpin);
        confirmMpinEditText = findViewById(R.id.confirmmpin);
        signupButton = findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailEditText.getText().toString();
                if(email.isEmpty()){
                    emailEditText.setError("Field cant be empty");
                }
                String mpin = mpinEditText.getText().toString();
                if(EmailValidator.isValidmPin(mpin)) {


                    String confirmMpin = confirmMpinEditText.getText().toString();

                    if (mpin.equals(confirmMpin)) {


                        if (EmailValidator.isValidEmail(email)) {

                            displaySignupSuccess(email);
                            UserDatabase userDatabase = UserDatabase.getDB(getApplicationContext());
                            userDatabase.userDao().insertUser(new User(email, mpin));

                            Log.d("message", String.valueOf(userDatabase.userDao().getAllUser().get(userDatabase.userDao().getAllUser().size() - 1).getUid()));

                            Intent intent1 = new Intent(SignUpActivity.this, LoginActivity.class);
                            intent1.putExtra("list", String.valueOf(userDatabase.userDao().getAllUser().size()));
                            startActivity(intent1);

                        } else {
                            displayError("MPIN and confirm MPIN do not match");
                        }

                    }
                }
            }
        });
    }




    private void displaySignupSuccess(String email) {

        String message = "Signup successful for email: " + email;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void displayError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();

    }
}