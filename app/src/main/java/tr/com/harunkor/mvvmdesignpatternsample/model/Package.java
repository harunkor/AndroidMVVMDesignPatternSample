package tr.com.harunkor.mvvmdesignpatternsample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

public class Package {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("subscriptionType")
    @Expose
    private String subscriptionType;
    @SerializedName("didUseBefore")
    @Expose
    private Boolean didUseBefore;
    @SerializedName("benefits")
    @Expose
    private Object benefits;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("tariff")
    @Expose
    private Tariff tariff;
    @SerializedName("availableUntil")
    @Expose
    private String availableUntil;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public Boolean getDidUseBefore() {
        return didUseBefore;
    }

    public void setDidUseBefore(Boolean didUseBefore) {
        this.didUseBefore = didUseBefore;
    }

    public JSONArray getBenefits() {


        Object json = null;
        JSONArray jsonArray = null;
        if(benefits!=null)
        {
        try {
            json = new JSONTokener(benefits.toString()).nextValue();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (json instanceof JSONArray) {
            jsonArray = (JSONArray) json;
        }

        }

        return jsonArray;

    }

    public void setBenefits(Object benefits) {
        this.benefits = benefits;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public String getAvailableUntil() {
        return availableUntil;
    }

    public void setAvailableUntil(String availableUntil) {
        this.availableUntil = availableUntil;
    }



}
