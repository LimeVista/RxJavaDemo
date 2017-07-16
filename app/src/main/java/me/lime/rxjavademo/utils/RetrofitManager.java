package me.lime.rxjavademo.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private static RetrofitManager instance = null;
    private Retrofit mRetrofit;

    public static final String BASE_URL = "http://sj.apidata.cn/";

    private RetrofitManager(){
        init();
    }

    public static RetrofitManager getInst(){
        if(instance==null)
            instance = new RetrofitManager();
        return instance;
    }

    public Retrofit getRetrofit(){
        return mRetrofit;
    }

    private void init(){
        //Init OKHttp
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);
        OkHttpClient client = builder.build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
}
