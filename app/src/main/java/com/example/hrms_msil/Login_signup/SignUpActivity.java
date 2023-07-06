package com.example.hrms_msil.Login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    private EditText usernameEditText;
    private EditText contactEditText;

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
        usernameEditText=findViewById(R.id.username);
        contactEditText=findViewById(R.id.contact);


        mpinEditText = findViewById(R.id.mpin);
        confirmMpinEditText = findViewById(R.id.confirmmpin);
        signupButton = findViewById(R.id.signupButton);
        UserDatabase userDatabase = UserDatabase.getDB(getApplicationContext());
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData = clipboard.getPrimaryClip();

        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String email = charSequence.toString();

                if (!email.isEmpty() && !EmailValidator.isValidEmail(email)) {
                    emailEditText.setError("Invalid email format");
                }
            }
            @Override
            public void afterTextChanged(Editable charSequence) {
                if (userDatabase.userDao().getByEmail(emailEditText.getText().toString()).size() != 0) {
                    emailEditText.setError("Email already exists");
                } else if (clipData != null && clipData.getItemCount() > 0) {
                    CharSequence copiedText = clipData.getItemAt(0).getText();
                    if (copiedText != null && emailEditText.getText().toString().equals(copiedText.toString())) {
                        Toast.makeText(SignUpActivity.this, "pasting email is not allowed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        mpinEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    String mpin = charSequence.toString();
                    if (!mpin.isEmpty() && mpin.length() != 6) {
                        mpinEditText.setError("MPIN must be a 6-digit number");

                    }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        confirmMpinEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String confirmMpin=charSequence.toString();
                String mpin = mpinEditText.getText().toString();
             if(!confirmMpin.isEmpty() && !confirmMpin.equals(mpin))
                 confirmMpinEditText.setError("MPIN and Confirm MPIN do not match");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String contact = contactEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String mpin = mpinEditText.getText().toString();

                String confirmMpin = confirmMpinEditText.getText().toString();
                if (email.isEmpty()) {
                    emailEditText.setError("Email field cannot be empty");
                    return;


                } else if (mpin.isEmpty()) {
                    mpinEditText.setError("MPIN field cannot be empty");
                    return;
                } else if (confirmMpin.isEmpty()) {
                    confirmMpinEditText.setError("CONFIRM MPIN  cannot be empty and must be matches with mPin");
                    return;
                }
                if (mpin.length() != 6) {
                    Toast.makeText(SignUpActivity.this, "MPIN must be a 6-digit number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(EmailValidator.isValidmPin(mpin)) {




                    if (mpin.equals(confirmMpin)) {


                      if (EmailValidator.isValidEmail(email)) {
//                          signupButton.setEnabled(EmailValidator.isValidEmail(email));
                          List<User> user = userDatabase.userDao().getByEmail(email);
                          if(user.size()>0){
                              Toast.makeText(SignUpActivity.this, "Email already exists", Toast.LENGTH_SHORT).show();
                          }
                          else {

                              displaySignupSuccess(email);

                              userDatabase.userDao().insertUser(new User(username,email,contact, mpin));

                              Log.d("message", String.valueOf(userDatabase.userDao().getAllUser().get(userDatabase.userDao().getAllUser().size() - 1).getUid()));

                              Intent intent1 = new Intent(SignUpActivity.this, LoginActivity.class);
                              intent1.putExtra("list", String.valueOf(userDatabase.userDao().getAllUser().size()));
                              startActivity(intent1);
                          }
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