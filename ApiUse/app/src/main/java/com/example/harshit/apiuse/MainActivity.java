package com.example.harshit.apiuse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText email , password;
    Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        signin = (Button)findViewById(R.id.signin);


//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Api.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        Api api = retrofit.create(Api.class);
//
//
//        final Call<List<ResultData>> result = api.getresult();
//        result.enqueue(new Callback<List<ResultData>>() {
//            @Override
//            public void onResponse(Call<List<ResultData>> call, Response<List<ResultData>> response) {
//
//                List<ResultData> resultDatas = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<List<ResultData>> call, Throwable t) {
//                Toast.makeText(getApplicationContext() , "Failed" , Toast.LENGTH_LONG).show();
//            }
//        });






        signin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);


       final RequestData requestData = new RequestData();
        requestData.setEmail(email.getText().toString());
        requestData.setPassword(password.getText().toString());

       Call<ResultData> result = api.getresult(requestData);

        result.enqueue(new Callback<ResultData>() {
            @Override
            public void onResponse(Call<ResultData> call, Response<ResultData> response) {

                ResultData resultData = response.body();

                if (resultData.isvalid())
                {
                    Intent intent = new Intent(getBaseContext(), Result.class);
                    intent.putExtra("email", resultData.getEmail());
                    intent.putExtra("auth_token", resultData.getAuth_token());
                    startActivity(intent);
                }
                else if (resultData.getMessage().equals("not present"))
                {
                    Intent intent = new Intent(getBaseContext(), Signup.class);
                    intent.putExtra("email", requestData.getEmail());
                    intent.putExtra("password", requestData.getPassword());
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext() , "Wrong Password" ,Toast.LENGTH_LONG).show();
                }



            }

            @Override
            public void onFailure(Call<ResultData> call, Throwable t) {
                Toast.makeText(getApplicationContext() , "Failed" ,Toast.LENGTH_LONG).show();
            }
        });


    }
}
