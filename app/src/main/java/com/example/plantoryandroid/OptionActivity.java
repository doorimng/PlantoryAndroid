package com.example.plantoryandroid;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.progressindicator.CircularProgressIndicator;


public class OptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_option);

        // 각 정보값 progress bar 이용하여 표시

        // 토양 습도
        int soilHumidity = 80 ;

        TextView textSoilHumidity = findViewById(R.id.percentHumid) ;
        textSoilHumidity.setText(soilHumidity +" %") ;

        CircularProgressIndicator pbarSoilHumidity = findViewById(R.id.pBarSoilHumidity) ;
        pbarSoilHumidity.setProgress(soilHumidity);

        ObjectAnimator animationSoilHumidity = ObjectAnimator.ofInt(pbarSoilHumidity, "progress", 0, soilHumidity);
        animationSoilHumidity.setDuration(1000);
        animationSoilHumidity.setInterpolator(new DecelerateInterpolator());
        animationSoilHumidity.start();

        // 남은 물 양
        int water = 60 ;

        TextView textWater = findViewById(R.id.percentWater) ;
        textWater.setText(water +" %") ;

        CircularProgressIndicator pbarWater = findViewById(R.id.pBarWater) ;
        pbarWater.setProgress(water) ;

        ObjectAnimator animationWater = ObjectAnimator.ofInt(pbarWater, "progress", 0, water);
        animationWater.setDuration(1000);
        animationWater.setInterpolator(new DecelerateInterpolator());
        animationWater.start();

        // 공기 중 온도
        int airTemperature = 27 ;

        TextView textAirTemperature = findViewById(R.id.percentAirTemperature) ;
        textAirTemperature.setText(airTemperature +" 도") ;

        ProgressBar pbarAirTemperature = findViewById(R.id.pBarAirTemperature) ;
        pbarAirTemperature.setProgress(airTemperature) ;

        ObjectAnimator animationAirTempeture = ObjectAnimator.ofInt(pbarAirTemperature, "progress", 0, airTemperature);
        animationAirTempeture.setDuration(1000);
        animationAirTempeture.setInterpolator(new DecelerateInterpolator());
        animationAirTempeture.start();

        // 공기 중 습도
        int airHumidity = 50 ;

        TextView textAirHumidity = findViewById(R.id.percentAirHumidity) ;
        textAirHumidity.setText(airHumidity +" %") ;

        ProgressBar pbarAirHumidity = findViewById(R.id.pBarAirHumidity) ;
        pbarAirHumidity.setProgress(airHumidity) ;

        ObjectAnimator animationAirHumidity = ObjectAnimator.ofInt(pbarAirHumidity, "progress", 0, airHumidity);
        animationAirHumidity.setDuration(1000);
        animationAirHumidity.setInterpolator(new DecelerateInterpolator());
        animationAirHumidity.start();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}