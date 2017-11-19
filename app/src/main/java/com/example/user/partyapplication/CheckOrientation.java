package com.example.user.partyapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by User on 19-11-2017.
 */

public class CheckOrientation implements SensorEventListener{

    //Should this context even be here? needed?
    protected Context context;
    private SensorManager mySensorManager;
    private Sensor myGravitySensor;
    float x, y, z;

    public CheckOrientation(Context context) {
        this.context = context.getApplicationContext();
        mySensorManager = (SensorManager)context.getSystemService(Context.SENSOR_SERVICE);
        myGravitySensor = mySensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        //registerListener();
        mySensorManager.registerListener(
                this,
                myGravitySensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_game);
        mySensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        myGravitySensor = mySensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
    }
    */

    public boolean isUp(){

        if (y>9){
            return true;
        }
        else return false;
    }

    public boolean isLeft(){
        //String xString = Float.toString(x);
        //Log.d("bammelam",xString);
        if (x>8) return true;
        else return false;
    }

    public boolean isRight(){

        if (x<-8) return true;
        else return false;
    }

    public boolean isFaceUp(){

        if (z>9) return true;
        else return false;
    }

    public boolean isFaceDown(){

        if (z<-7) return true;
        else return false;
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor source = event.sensor;
        //float z = event.values[2];
        /*
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];
        */

        if(source.getType() == Sensor.TYPE_GRAVITY) {
            x = event.values[0];
            y = event.values[1];
            z = event.values[2];
            //text.setText(z);
            //Log.d("halp", Float.toString(z));


        }
        Log.d("bammelam",Float.toString(x));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //method stub
    }

    public void registerListener(){
        mySensorManager.registerListener(
                this,
                myGravitySensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    /*
    @Override
    protected void onPause() {
        super.onPause();
        mySensorManager.unregisterListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mySensorManager.registerListener(
                this,
                myGravitySensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    */
}
