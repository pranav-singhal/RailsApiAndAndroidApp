package com.example.harshit.apiuse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by harshit on 13/10/17.
 */

public interface Api {


    String BASE_URL = "http://192.168.0.102:3000/api/v1/";
//
//    @GET("someurl")
//    Call<List<ResultData>> getresult();


    @POST("signin")
    Call<ResultData> getresult(@Body RequestData requestData);

    @POST("signup")
    Call<ResultData> getresultsign(@Body RequestData requestData);


}
