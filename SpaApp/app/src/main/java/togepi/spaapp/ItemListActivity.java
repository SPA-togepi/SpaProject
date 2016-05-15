package togepi.spaapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import togepi.spaapp.img.AsyncTaskHttpRequest;

public class ItemListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        ImageView imageView = (ImageView)findViewById(R.id.imageView);

        Uri uri = Uri.parse("http://cdn-ak.f.st-hatena.com/images/fotolife/f/fjswkun/20150927/20150927140905.jpg");
        Uri.Builder builder = uri.buildUpon();
        AsyncTaskHttpRequest task = new AsyncTaskHttpRequest(imageView);
        task.execute(builder);


    }
}
