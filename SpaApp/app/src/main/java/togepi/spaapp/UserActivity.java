package togepi.spaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.StringTokenizer;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        //景品数
        int itemnum = 8;

        //景品の金額リスト
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4000);


        //TableLayoutのグループを取得
        ViewGroup vg = (ViewGroup)findViewById(R.id.TableLayout2);


        for(int i = 0; i < itemnum; i++ ){
            //行を追加
            getLayoutInflater().inflate(R.layout.table_row_users, vg);
            //文字を設定
            TableRow tr = (TableRow)vg.getChildAt(i);
            String str = String.format(Locale.getDefault(), "%d等　", i+1);
            ((TextView)(tr.getChildAt(0))).setText(str);
            ((Button)(tr.getChildAt(1))).setText(String.valueOf(list.get(0)));

        }


    }
}
