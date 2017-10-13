package com.example.harshit.apiuse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = (TextView)findViewById(R.id.result);

        result.setText(getIntent().getStringExtra("email")+"    "+ getIntent().getStringExtra("auth_token"));

    }
}
