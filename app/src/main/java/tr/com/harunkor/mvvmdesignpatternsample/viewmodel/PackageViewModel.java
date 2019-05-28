package tr.com.harunkor.mvvmdesignpatternsample.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tr.com.harunkor.mvvmdesignpatternsample.model.PackageResources;
import tr.com.harunkor.mvvmdesignpatternsample.utils.ApiLoginClient;
import tr.com.harunkor.mvvmdesignpatternsample.utils.ApiRetroInterface;
import tr.com.harunkor.mvvmdesignpatternsample.utils.onTaskCompleted;

public class PackageViewModel extends BaseObservable {

    private Context context;
    private ApiRetroInterface apiRetroInterface;
    private PackageResources packageResources;
    private onTaskCompleted listener;


    public  PackageViewModel(Context context,onTaskCompleted listener)
    {
        this.context=context;
        this.listener=listener;

        apiRetroInterface= ApiLoginClient.ClientLogin().create(ApiRetroInterface.class);
        Call<PackageResources> call = apiRetroInterface.PackagesAll();
        call.enqueue(new Callback<PackageResources>() {
            @Override
            public void onResponse(Call<PackageResources> call, Response<PackageResources> response) {

                packageResources=response.body();

               setList(packageResources);


                listener.onTaskCompleted();



            }

            @Override
            public void onFailure(Call<PackageResources> call, Throwable t) {

                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("TAG",""+t.getMessage());

                call.cancel();

            }
        });





    }


    @Bindable
    public PackageResources getList()
    {
        return  packageResources;


    }


   @Bindable
    public void setList(PackageResources mypackageResources)
   {
       packageResources.setPackages(mypackageResources.getPackages());


      // notifyPropertyChanged(BR.name);


   }











}
