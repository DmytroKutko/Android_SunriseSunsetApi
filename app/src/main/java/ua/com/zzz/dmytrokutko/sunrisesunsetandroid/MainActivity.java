package ua.com.zzz.dmytrokutko.sunrisesunsetandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ua.com.zzz.dmytrokutko.sunrisesunsetandroid.service.AstronomyService;
import ua.com.zzz.dmytrokutko.sunrisesunsetandroid.model.Astronomy;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    TextView tvCityName, tvSunrise, tvSunset;
    EditText etCityName;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AstronomyService astronomyService = new AstronomyService();
        initComponents();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                astronomyService.getAstronomy(new AstronomyService.LoadData<Astronomy>() {
                    @Override
                    public void onData(Astronomy data) {
                        Log.d(TAG, "onData: received");
                        onDataUpdate(data);
                        etCityName.setText("");
                    }

                    @Override
                    public void onFailure() {
                        Log.d(TAG, "onFailure: no data received");
                    }
                }, etCityName.getText().toString().trim()); //Get name from EditText
            }
        });
    }

    private void onDataUpdate(Astronomy data) {
        tvCityName.setText("City name:\t" + data.getAstronomy().get(0).getCity());
        tvSunrise.setText("Sunrise:\t" + data.getAstronomy().get(0).getSunrise());
        tvSunset.setText("Sunset:\t" + data.getAstronomy().get(0).getSunset());
    }

    private void initComponents() {
        tvCityName = findViewById(R.id.tvCityName);
        tvSunrise = findViewById(R.id.tvSunrise);
        tvSunset = findViewById(R.id.tvSunset);
        etCityName = findViewById(R.id.etCityName);
        btnSubmit = findViewById(R.id.btnSubmit);
    }
}
