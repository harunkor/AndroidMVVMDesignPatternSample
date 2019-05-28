package tr.com.harunkor.mvvmdesignpatternsample.view;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import tr.com.harunkor.mvvmdesignpatternsample.R;
import tr.com.harunkor.mvvmdesignpatternsample.adapter.MyRecyclerViewAdapter;
import tr.com.harunkor.mvvmdesignpatternsample.databinding.MainActivtyBinding;
import tr.com.harunkor.mvvmdesignpatternsample.utils.onTaskCompleted;
import tr.com.harunkor.mvvmdesignpatternsample.viewmodel.PackageViewModel;

public class MainActivity extends Activity {



    private MainActivtyBinding binding;

    PackageViewModel packageViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         binding = DataBindingUtil.setContentView(this, R.layout.main_activty);

         packageViewModel=new PackageViewModel(this, new onTaskCompleted() {
              @Override
              public void onTaskCompleted() {

                 MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(packageViewModel.getList(),getApplicationContext());

                  binding.setMyAdapter(adapter);
              }
          });














    }
}
