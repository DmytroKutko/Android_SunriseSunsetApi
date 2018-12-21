package ua.com.zzz.dmytrokutko.sunrisesunsetandroid.service;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.com.zzz.dmytrokutko.sunrisesunsetandroid.api.AstronomyApi;
import ua.com.zzz.dmytrokutko.sunrisesunsetandroid.model.Astronomy;
import ua.com.zzz.dmytrokutko.sunrisesunsetandroid.model.AstronomyData;

public class AstronomyService {

    private static final String TAG = "AstronomyService";

    private AstronomyApi api;

    public AstronomyService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://weather.cit.api.here.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(AstronomyApi.class);
    }

    public interface LoadData<T> {
        void onData(T data);

        void onFailure();
    }

    public void getAstronomy(final LoadData<Astronomy> callback, final String name) {

        String product = "forecast_astronomy";
        String app_id = "DemoAppId01082013GAL";
        String app_code = "AJKnXv84fjrb0KIHawS0Tg";

        api.getData(product, name, app_id, app_code).enqueue(new Callback<AstronomyData>() {
            @Override
            public void onResponse(Call<AstronomyData> call, Response<AstronomyData> response) {
                if (response.body() == null) {
                    Log.d(TAG, "onResponse: fail");
                    callback.onFailure();
                    return;
                }
                callback.onData(response.body().getAstronomy());
            }

            @Override
            public void onFailure(Call<AstronomyData> call, Throwable t) {
                callback.onFailure();
            }
        });
    }
}
