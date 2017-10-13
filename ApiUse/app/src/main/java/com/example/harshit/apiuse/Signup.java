package com.example.harshit.apiuse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Signup extends AppCompatActivity implements View.OnClickListener {


    EditText phone_no;
    Button signup;
    String email , password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        phone_no = (EditText)findViewById(R.id.phone_no);
        signup = (Button)findViewById(R.id.signup);


        email = getIntent().getStringExtra("email");
        password = getIntent().getStringExtra("password");



        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);


        RequestData requestData = new RequestData();
        requestData.setEmail(email);
        requestData.setPassword(password);
        requestData.setPhone_no(phone_no.getText().toString());

        Call<ResultData> result = api.getresultsign(requestData);

        result.enqueue(new Callback<ResultData>() {
            @Override
            public void onResponse(Call<ResultData> call, Response<ResultData> response) {

                ResultData resultData = response.body();
                if(resultData == null)
                {
                    Toast.makeText(getApplicationContext() , "Failed  text" ,Toast.LENGTH_LONG).show();
                }
               else if (resultData.isvalid())
                {
                    Intent intent = new Intent(getBaseContext(), Result.class);
                    intent.putExtra("email", resultData.getEmail());
                    intent.putExtra("auth_token", resultData.getAuth_token());
                    startActivity(intent);
                }


            }

            @Override
            public void onFailure(Call<ResultData> call, Throwable t) {
                Toast.makeText(getApplicationContext() , "Failed" ,Toast.LENGTH_LONG).show();
            }
        });

    }
}
