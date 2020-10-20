package com.duarbd.mvvm_retrofit_example.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static final String BASEURL="http://dummy.restapiexample.com/api/v1/";
    private static Retrofit retrofit;
    private static API_Interface api_interface;


    public static synchronized API_Interface getAPIinterface(){
        if(retrofit==null){
              retrofit=new retrofit2.Retrofit.Builder()
                      .baseUrl(BASEURL)
                      .addConverterFactory(GsonConverterFactory.create())
                      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                      .build();
              api_interface=retrofit.create(API_Interface.class);
        }
        return api_interface;
    }
}
