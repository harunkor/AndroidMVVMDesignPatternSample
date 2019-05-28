package tr.com.harunkor.mvvmdesignpatternsample.utils;

import android.os.StrictMode;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiLoginClient {

    private  static Retrofit retrofit = null;

    public static Retrofit ClientLogin()
    {
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        HttpLoggingInterceptor httpLoggingInterceptor  = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        //http://www.harunkor.com/packageList.json

        retrofit=new Retrofit.Builder()
                .baseUrl("http://www.harunkor.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return  retrofit;




    }




}
