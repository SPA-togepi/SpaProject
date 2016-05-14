package togepi.spaapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Locale;

public class AdminActivity extends AppCompatActivity {

    TextView partyIdText;
    EditText itemNumEdit, initMoneyEdit;
    ViewGroup viewGroup;
    // キーボード表示を制御するためのオブジェクト
    InputMethodManager inputMethodManager;
    // 背景のレイアウト
    private RelativeLayout mainLayout;
    Button initSettingButton;
    CompoundButton rankSwitch;


    ArrayAdapter<String> adapter;
    String partyName = null;
    int initMoney = 0;
    int itemnum = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mainLayout = (RelativeLayout) findViewById(R.id.admin_layout);

        //商品のジャンルリスト
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Adapterにアイテムを追加
        adapter.add("red");
        adapter.add("green");
        adapter.add("blue");

        //Intentのパラメータを取得
        Intent intent = getIntent();
        partyName = intent.getStringExtra("partyName");

        initView();
        setView();

    }

    private void initView(){
        partyIdText = (TextView) findViewById(R.id.partyIdText);
        itemNumEdit = (EditText) findViewById(R.id.itemnum);
        initMoneyEdit = (EditText) findViewById(R.id.initMoneyEdit);
        viewGroup = (ViewGroup) findViewById(R.id.TableLayout);
        initSettingButton = (Button) findViewById(R.id.initSettingButton);
        rankSwitch = (CompoundButton) findViewById(R.id.rankSwitch);
    }

    private void setView(){
        partyIdText.setText("パーティーID：" + partyName);

        itemNumEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    //フォーカス時

                }else{
                    //離れた時
                    itemnum = Integer.parseInt(itemNumEdit.getText().toString());
                    for(int i = 0; i < itemnum; i++ ){
                        //行を追加
                        getLayoutInflater().inflate(R.layout.table_row, viewGroup);
                        //文字を設定
                        TableRow tr = (TableRow)viewGroup.getChildAt(i);
                        String str = String.format(Locale.getDefault(), "%d等", i+1);
                        ((TextView)(tr.getChildAt(0))).setText(str);
                        ((Spinner)(tr.getChildAt(1))).setAdapter(adapter);
                    }
                }
            }
        });

        initMoneyEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    //フォーカス時

                }else{
                    //離れた時
                    initMoney = Integer.parseInt(initMoneyEdit.getText().toString());

                }
            }
        });

        initSettingButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //サーバにデータ送信

                Intent intent = new Intent(AdminActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });

        rankSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 状態が変更された
                if(isChecked == true){
                    for(int i = 0; i < itemnum; i++ ){
                        //行を追加
                        getLayoutInflater().inflate(R.layout.table_row, viewGroup);
                        //文字を設定
                        TableRow tr = (TableRow)viewGroup.getChildAt(i);
                        String str = String.format(Locale.getDefault(), "%d等", i+1);
                        ((TextView)(tr.getChildAt(0))).setText(str);
                        ((Spinner)(tr.getChildAt(1))).setAdapter(adapter);
                    }
                }else{
                    for(int i = 0; i < itemnum; i++ ){
                        //行を追加
                        getLayoutInflater().inflate(R.layout.table_row, viewGroup);
                        //文字を設定
                        TableRow tr = (TableRow)viewGroup.getChildAt(i);
                        String str = String.format(Locale.getDefault(), "%d", i+1);
                        ((TextView)(tr.getChildAt(0))).setText(str);
                        ((Spinner)(tr.getChildAt(1))).setAdapter(adapter);
                    }
                }
            }
        });

    }

    // 画面タップ時の処理
    @Override
    public boolean onTouchEvent(MotionEvent event) {

// キーボードを隠す
        inputMethodManager.hideSoftInputFromWindow(mainLayout.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
// 背景にフォーカスを移す
        mainLayout.requestFocus();

        return true;

    }

}
