package com.hybrid.tech.sensorssv1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity  {      //implements SensorEventListener {
    private SensorManager sensorManager;
    private TextView count;
    boolean activityRunning;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = (TextView) findViewById(R.id.acceleration);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
/*
        PackageManager pm = getPackageManager();
        if (pm.hasSystemFeature(PackageManager.FEATURE_SENSOR_BAROMETER)) {
        Toast.makeText(this,"Available",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"NOT Available",Toast.LENGTH_SHORT).show();
        }
*/
/*
        if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null){

            Toast.makeText(this,"You have the sensor",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"NOPE no magneto meter",Toast.LENGTH_SHORT).show();

      }

      */
        String theList="";
        List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (int i = 0; i< deviceSensors.size(); i++) {

                theList=deviceSensors.get(i).getName()+"\n"+theList;

        }
        count.setText(theList);
    }

    /*
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onResume() {
        super.onResume();
        activityRunning = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER );
        if (countSensor != null) {
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_NORMAL, 0);
        } else {
            Toast.makeText(this, "Count sensor not available!", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        activityRunning = false;
        // if you unregister the last listener, the hardware will stop detecting step events
//        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (activityRunning) {
            count.setText(String.valueOf(event.values[0]));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    */
}