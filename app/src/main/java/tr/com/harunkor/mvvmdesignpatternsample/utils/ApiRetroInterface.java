package tr.com.harunkor.mvvmdesignpatternsample.utils;

import retrofit2.Call;
import retrofit2.http.GET;
import tr.com.harunkor.mvvmdesignpatternsample.model.PackageResources;

public interface ApiRetroInterface {


    @GET("/packageList.json")
    Call<PackageResources> PackagesAll();


}
