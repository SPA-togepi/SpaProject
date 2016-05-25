package togepi.spaapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class ItemListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);



        int price = getIntent().getIntExtra("price", 0);
        int rank = getIntent().getIntExtra("rank", 0);
        String genre = "electric";

        if(price <= 2000){
            price = 1000;
        }else if(price > 2000 && price <= 3000){
            price = 2000;
        }else if(price > 3000){
            price = 3000;
        }

        for(int i = 1 ; i < 4; i++) {
            String resName = "a" + String.valueOf(price) + "_" + String.valueOf(i);
            int resourceId = getResources().getIdentifier(resName, "drawable", getPackageName());
            String viewName = "imageView" + String.valueOf(i);
            int viewId = getResources().getIdentifier(viewName, "id", getPackageName());
            ImageView imageView = (ImageView) findViewById(viewId);
            imageView.setImageResource(resourceId);
        }

    }
}
