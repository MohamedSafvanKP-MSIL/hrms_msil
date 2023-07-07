package com.example.hrms_msil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView textView1,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView1=findViewById(R.id.textView2);
        textView2=findViewById(R.id.textView4);
        String email=getIntent().getStringExtra("email");
        String contact=getIntent().getStringExtra("contact No");
        textView1.setText(email);
        textView2.setText(contact);


    }
}