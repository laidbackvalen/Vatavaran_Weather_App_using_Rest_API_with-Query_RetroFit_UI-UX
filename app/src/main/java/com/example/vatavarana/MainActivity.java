package com.example.vatavarana;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.vatavarana.databinding.ActivityMainBinding;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    WeatherModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        fetchWeatherData("pune");
        binding.searchViewMain.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query != null) {
                    fetchWeatherData(query);
                }
                return true;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                return true;
            }
        });

    }
    private void fetchWeatherData(String cityname) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Retrofit_API networkcall = retrofit.create(Retrofit_API.class);
        Call<WeatherModel> response = networkcall.getWeatherData(cityname, Constants.API_KEY, "metric");
        response.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                if (response.isSuccessful()) {
                    model = response.body();
                    if (model != null) {
                        binding.cityMain.setText(model.getName());
                        binding.dateMain.setText(datetoday());
                        binding.temperatureReadingMain.setText(String.valueOf(model.getMain().getTemp()));
//                        binding.minTempMain.setText(String.valueOf(model.getMain().getTempMin()));
//                        binding.maxTempMain.setText(String.valueOf(model.getMain().getTempMax()));
                        binding.tempReading.setText(model.getMain().getHumidity() + " %");
                        binding.dayTxt.setText(dayToday().toUpperCase());
                        binding.windSpeedReading.setText(String.valueOf(model.getWind().getSpeed()));
                        binding.todaysConditionbelowDay.setText(String.valueOf(model.getWeather().get(0).getDescription()));
                        binding.conditionType.setText(String.valueOf(model.getWeather().get(0).getMain()));
                        binding.sunRiseReading.setText(String.valueOf(timetoday(model.getSys().getSunrise())));
                        binding.sunSetReading.setText(String.valueOf(timetoday(model.getSys().getSunset())));
//                        binding.seaReading.setText(String.valueOf(model.getMain().getSeaLevel()));

                        changeBackgroundAsWeatherCondition(String.valueOf(model.getWeather().get(0).getMain()));
                    } else {
                        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "No records found : " + cityname, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<WeatherModel> call, Throwable throwable) {
            }
        });
    }
    private void changeBackgroundAsWeatherCondition(String condition) {
        if (condition.matches("Clouds")) {
            binding.main.setBackground(getDrawable(R.drawable.raining_gradient));
            binding.lottieAnimationView2.setAnimation(R.raw.cloudslottie);
            binding.lottieAnimationView2.playAnimation();
        } else if (condition.matches("Clear")) {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            if(hour>18){
            binding.main.setBackground(getDrawable(R.drawable.rect_main_bg_bottom_purple_gradient));
                binding.lottieAnimationView2.setAnimation(R.raw.night_moon_lottie);
                binding.lottieAnimationView2.playAnimation();
            }else {
                binding.main.setBackground(getDrawable(R.drawable.main_bg_sun_gradient));
                binding.lottieAnimationView2.setAnimation(R.raw.sun_other);
                binding.lottieAnimationView2.playAnimation();
            }
        } else if (condition.matches("Rain")) {
            binding.main.setBackground(getDrawable(R.drawable.raining_gradient));
            binding.lottieAnimationView2.setAnimation(R.raw.raininglottie);
            binding.lottieAnimationView2.playAnimation();
        } else if (condition.matches("Snow")) {
            binding.main.setBackground(getDrawable(R.drawable.snow_fall_gradient_mian_bg));
            binding.lottieAnimationView2.setAnimation(R.raw.snowfalllottie);
            binding.lottieAnimationView2.playAnimation();
        }
    }
    String datetoday() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        return dateFormat.format(new Date());
    }
    String timetoday(long timestamp) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return timeFormat.format(new Date(timestamp*1000));
    }
    String dayToday() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
        return dateFormat.format(new Date());
    }
}