package tr.com.harunkor.mvvmdesignpatternsample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PackageResources {




    @SerializedName("packages")
    @Expose
    private List<Package> packages = null;

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }




}
