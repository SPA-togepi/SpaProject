package togepi.spaapp.AccelaratorSample;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import togepi.spaapp.R;

public class SensorActivity extends AppCompatActivity implements Runnable{

    TextView tv;
    Handler h;

    SensorAdapter sa;
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        LinearLayout ll = new LinearLayout(this);
        setContentView(ll);

        tv = new TextView(this);
        ll.addView(tv);

        h = new Handler();
        h.postDelayed(this, 500);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sa.stopSensor(sm);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        h.removeCallbacks(this);
    }

    @Override
    public void onResume(){
        super.onResume();
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors =
                sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
        sa = new SensorAdapter(sm);
    }


    @Override
    public void run() {

        tv.setText("X-axis : " + sa.getx() + "\n"
                + "Y-axis : " + sa.gety() + "\n"
                + "Z-axis : " + sa.getz() + "\n");
        h.postDelayed(this, 500);
    }
}
