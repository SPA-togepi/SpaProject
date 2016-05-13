package togepi.spaapp;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class BluetoothActivity extends AppCompatActivity {

    final String TAG = "BuletoothAct";
    boolean bluetooth = false;
    Button btSerchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blootooth);

        initView();
        setOnClick();
    }

    @Override
    public void onStart(){
        super.onStart();

        //BluetoothAdapter取得
        BluetoothAdapter Bt = BluetoothAdapter.getDefaultAdapter();
        if(Bt.equals(null)){
            //Bluetooth非対応端末の場合の処理
            Log.v("TAG","Bluetoothがサポートされてます");
            finish();
        }else{
            //Bluetooth対応端末の場合の処理
            Log.v("TAG","Bluetoothがサポートされてます");

            //Bluetoothのon offを判断
            bluetooth = Bt.isEnabled();
            if(bluetooth){
                //bluetoothがonの場合

            }else{
                //OFFだった場合、ONにすることを促すダイアログを表示する画面に遷移
                Intent btOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(btOn, 1);
            }
        }
    }

    @Override
    public void onResume(){
        super.onResume();

        checkDiscoverAble(bluetooth);
    }


    public void checkBluetooth(){



    }

    @Override
    protected void onActivityResult(int requestCode, int ResultCode, Intent date){
        //ダイアログ画面から結果を受けた後の処理を記述
        if (ResultCode != Activity.RESULT_OK){
            //ユーザがbluetoothをonにしなかった場合
            finish();
        }else{
            //ユーザがbluetoothをonにした場合
            bluetooth = true;
        }

    }


    private void checkDiscoverAble(boolean bluetooth){
        if(bluetooth){
            //自デバイスの検出を有効にする
            Intent discoverableOn = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            discoverableOn.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
            startActivity(discoverableOn);
        }
    }

    private void initView(){
        btSerchBtn = (Button) findViewById(R.id.searchBtn);

    }

    private void setOnClick(){
        btSerchBtn.setOnClickListener(buttonBluetoothSearch);
    }


    /*
    * searchボタンの処理
    * */
    View.OnClickListener buttonBluetoothSearch = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
