package togepi.spaapp;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import togepi.spaapp.user.UserFacade;

public class UserActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager manager;
    private Sensor delectorSensor;
    private Sensor stepCntSensor;

    private int stepcount;
    private int stepcount2;

    Button firstButton, secondeButton, thirdButton, campaButton;

    EditText campaEdit;

    TextView sumText;

    int sum;

    UserFacade userFacade;
    //タイマー処理用
    private Timer mTimer = null;
    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        //景品数
        int itemnum = 3;

        //景品の金額リスト
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4000);

        userFacade = new UserFacade();


        //TableLayoutのグループを取得
        ViewGroup vg = (ViewGroup) findViewById(R.id.TableLayout2);
        firstButton = (Button) findViewById(R.id.firstButton);
        secondeButton = (Button) findViewById(R.id.secondeButton);
        thirdButton = (Button) findViewById(R.id.thirdButton);
        campaEdit = (EditText) findViewById(R.id.editText2);
        campaButton = (Button) findViewById(R.id.campaButton);

        firstButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // クリック時の処理
                Intent intent_first = new Intent(getApplicationContext(), ItemListActivity.class);
                intent_first.putExtra("rank", 1);
                intent_first.putExtra("price", 3000);
                startActivity(intent_first);
            }
        });

        secondeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // クリック時の処理
                Intent intent_first = new Intent(getApplicationContext(), ItemListActivity.class);
                intent_first.putExtra("rank", 2);
                intent_first.putExtra("price", 2000);
                startActivity(intent_first);
            }
        });

        thirdButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // クリック時の処理
                Intent intent_first = new Intent(getApplicationContext(), ItemListActivity.class);
                intent_first.putExtra("rank", 3);
                intent_first.putExtra("price", 1000);
                startActivity(intent_first);
            }
        });

        campaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // クリック時の処理
                int donate = Integer.parseInt(campaEdit.getText().toString());
                userFacade.Donate(500, v.getContext());
            }
        });

        campaEdit = (EditText)findViewById(R.id.editText2);


        Log.d("onCreate","start");
        manager = (SensorManager)getSystemService(SENSOR_SERVICE);
        //センサマネージャから TYPE_STEP_DETECTOR についての情報を取得する
        delectorSensor = manager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

        //センサマネージャから TYPE_STEP_COUNTER についての情報を取得する
        stepCntSensor = manager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

    }



    @Override
    public void onResume(){
        Log.d("onResume","start");
            super.onResume();

            // リスナー設定
            manager.registerListener (this,
                    stepCntSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);

            manager.registerListener(this,
                    delectorSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);

        stepcount = 0;
        stepcount2 = 0;

    }


    @Override
    public void onSensorChanged(SensorEvent event) {

        Sensor sensor = event.sensor;
        float[] values = event.values;
        long timestamp = event.timestamp;

        //TYPE_STEP_COUNTER
//        if(sensor.getType() == Sensor.TYPE_STEP_COUNTER){
//            // 今までの歩数
//            Log.d("type_step_counter", String.valueOf(values[0]));
//            stepcount2++;
//            campaEdit.setText("STEP_COUNTER=" + stepcount2 + "歩");
//        }
        if(sensor.getType() == Sensor.TYPE_STEP_DETECTOR){
            // ステップを検知した場合にアクセス
            Log.d("type_detector_counter", String.valueOf(values[0]));
            stepcount++;
            campaEdit.setText( String.valueOf(stepcount*100) );

//            });
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onPause() {
        super.onPause();

        // リスナー解除
        manager.unregisterListener(this,stepCntSensor);
        manager.unregisterListener(this,delectorSensor);
//タイマー処理
        mTimer = new Timer(true);
        mTimer.schedule(new TimerTask(){
            @Override
            public void run() {
                mHandler.post( new Runnable() {
                    public void run() {
                        //ここに処理を書く
                        sum = userFacade.GetCurrentMoney(getApplicationContext());
                        sumText.setText("合計金額：" + sum + "円");
                    }
                });
            }
        },1000,3000); //1秒後から2秒間隔で実行


    }
}
