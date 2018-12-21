package ua.com.zzz.dmytrokutko.sunrisesunsetandroid.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ua.com.zzz.dmytrokutko.sunrisesunsetandroid.model.AstronomyData;

public interface AstronomyApi {

    String PRODUCT = "forecast_astronomy";
    String APP_ID = "DemoAppId01082013GAL";
    String APP_CODE = "AJKnXv84fjrb0KIHawS0Tg";

    @GET("weather/1.0/report.json")
    Call<AstronomyData> getData(@Query("product") String product,
                                @Query("name") String name,
                                @Query("app_id") String appId,
                                @Query("app_code") String appCode);
}
