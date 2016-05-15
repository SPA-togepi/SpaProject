package togepi.spaapp.AccelaratorSample;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.*;

/**
 * Created by youmemusic on 2016/05/15.
 */
public class StepSensorAdapter implements SensorEventListener {
    private Sensor delectorSensor;
    private Sensor stepCntSensor;
    SensorManager sm;
    private int stepcount = 0;
    private int stepcount2 = 0;

    public StepSensorAdapter(SensorManager sm) {
        Log.d("SetpSA","Constructor");
        this.sm = sm;

        //センサマネージャから TYPE_STEP_DETECTOR についての情報を取得する
        delectorSensor = sm.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

        //センサマネージャから TYPE_STEP_COUNTER についての情報を取得する
        stepCntSensor = sm.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        float[] values = event.values;
        long timestamp = event.timestamp;

        //TYPE_STEP_COUNTER
        if(sensor.getType() == Sensor.TYPE_STEP_COUNTER){
            // 今までの歩数
            Log.d("type_step_counter", String.valueOf(values[0]));
            stepcount2++;
        }
        if(sensor.getType() == Sensor.TYPE_STEP_DETECTOR){
            // ステップを検知した場合にアクセス
            Log.d("type_detector_counter", String.valueOf(values[0]));
            stepcount++;

        }
    }

    public int GetStep1(){
        Log.d("GetStep1",String.valueOf(stepcount));
        return stepcount;
    }

    public int GetStep2(){
        return stepcount2;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
