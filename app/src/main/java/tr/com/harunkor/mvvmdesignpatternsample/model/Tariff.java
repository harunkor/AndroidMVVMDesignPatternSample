package tr.com.harunkor.mvvmdesignpatternsample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tariff {


    @SerializedName("data")
    @Expose
    private String data;
    @SerializedName("talk")
    @Expose
    private String talk;
    @SerializedName("sms")
    @Expose
    private String sms;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

}
