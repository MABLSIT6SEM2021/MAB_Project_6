package com.example.app6;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


public class ParseJSON extends AppCompatActivity {

    TextView tvCity, tvLatitude, tvLongitude, tvTemperature, tvHumidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parsejson);

        tvCity = findViewById(R.id.citynameval);
        tvLatitude = findViewById(R.id.latitudeval);
        tvLongitude = findViewById(R.id.longitudeval);
        tvTemperature = findViewById(R.id.temperatureval);
        tvHumidity = findViewById(R.id.humidityval);

        try {
            JSONObject jsonObject = new JSONObject(readJson());
            JSONObject cityDetails = jsonObject.getJSONObject("citydetails");

            String city, latitude, longitude, temperature, humidity;

            city = cityDetails.getString("cityname");
            latitude = cityDetails.getString("latitude");
            longitude = cityDetails.getString("longitude");
            temperature = cityDetails.getString("temperature");
            humidity = cityDetails.getString("humidity");

            tvCity.setText(city);
            tvLatitude.setText(latitude);
            tvLongitude.setText(longitude);
            tvTemperature.setText(temperature);
            tvHumidity.setText(humidity);

        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }

    }

    private String readJson() {
        String json;
        try {
            InputStream inputStream = getAssets().open("city.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
}