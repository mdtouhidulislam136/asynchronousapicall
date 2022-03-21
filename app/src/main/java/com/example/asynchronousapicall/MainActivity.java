package com.example.asynchronousapicall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSensors(View view) {
    // Start listening to acceleration sensor event (x,y, z position of the device)
        // Todo: 1. connect sensor manager
        SensorManager sensorManager = (SensorManager) getSystemService((Context.SENSOR_SERVICE));

        // Todo: 2. Register to listen to accelerometer sensor events from the HW
        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener((SensorEventListener) this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        // Todo: 3. React to sensor events by updating the text on the activity screen


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // here we get sensor events in sensorEvent
        // Read the sensor x, y and z values and show in the TextView in the screen

        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        // Update the UI
        TextView sensorTextView = (TextView)findViewById(R.id.sensorTextView);
        sensorTextView.setText("X: " + x + "Y: " + y + "Z: " + z);

       ConstraintLayout background = (ConstraintLayout) findViewById(R.id.background);
        if(z > 88 & z < 92){
            background.setBackgroundColor(Color.YELLOW);

        }

        else {
            background.setBackgroundColor(Color.RED);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}