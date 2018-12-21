package ua.com.zzz.dmytrokutko.sunrisesunsetandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AstronomyData {

    @SerializedName("astronomy")
    @Expose
    private Astronomy astronomy;
    @SerializedName("feedCreation")
    @Expose
    private String feedCreation;
    @SerializedName("metric")
    @Expose
    private Boolean metric;

    public Astronomy getAstronomy() {
        return astronomy;
    }

    public void setAstronomy(Astronomy astronomy) {
        this.astronomy = astronomy;
    }

    public String getFeedCreation() {
        return feedCreation;
    }

    public void setFeedCreation(String feedCreation) {
        this.feedCreation = feedCreation;
    }

    public Boolean getMetric() {
        return metric;
    }

    public void setMetric(Boolean metric) {
        this.metric = metric;
    }

    @Override
    public String toString() {
        return "AstronomyData{" +
//                "astronomy=" + astronomy +
                ", feedCreation='" + feedCreation + '\'' +
                ", metric=" + metric +
                '}';
    }
}
