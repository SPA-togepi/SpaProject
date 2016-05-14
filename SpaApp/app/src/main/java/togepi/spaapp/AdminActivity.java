package togepi.spaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Locale;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        int itemnum = 8;

        //商品のジャンルリスト
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Adapterにアイテムを追加
        adapter.add("red");
        adapter.add("green");
        adapter.add("blue");


        //TableLayoutのグループを取得
        ViewGroup vg = (ViewGroup)findViewById(R.id.TableLayout);


        for(int i = 0; i < itemnum; i++ ){
            //行を追加
            getLayoutInflater().inflate(R.layout.table_row, vg);
            //文字を設定
            TableRow tr = (TableRow)vg.getChildAt(i);
            String str = String.format(Locale.getDefault(), "%d等", i+1);
            ((TextView)(tr.getChildAt(0))).setText(str);
            ((Spinner)(tr.getChildAt(1))).setAdapter(adapter);

        }




    }
}
