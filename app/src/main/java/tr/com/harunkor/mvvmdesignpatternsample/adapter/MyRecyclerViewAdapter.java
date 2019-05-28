package tr.com.harunkor.mvvmdesignpatternsample.adapter;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;

import tr.com.harunkor.mvvmdesignpatternsample.R;
import tr.com.harunkor.mvvmdesignpatternsample.model.PackageResources;

public class MyRecyclerViewAdapter extends  RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>

{

     PackageResources  dataModelList;
    private Context context;

    public MyRecyclerViewAdapter(PackageResources dataModelList, Context ctx) {
        this.dataModelList = dataModelList;
        context = ctx;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.item_row, viewGroup, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(dataModelList.getPackages().get(position));



    }

    @Override
    public int getItemCount() {
        return dataModelList.getPackages().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewDataBinding itemRowBinding;

        public ViewHolder(ViewDataBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.datapackage, obj);
            itemRowBinding.executePendingBindings();
        }
    }


}


