package togepi.spaapp.common;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by SuzukiRikuro on 2016/05/26.
 */

/**
 * 実装方法は
 * URL url = new URL("http://www.example.co.jp/index.html");
 * new HttpGetTask().execute(url);
 * 参考URL: http://qiita.com/kawa106/items/9f50537a36dfa31863c3
 */
public class HttpGetTask extends AsyncTask<URL, Void, HttpResponse> {

    @Override
    protected HttpResponse doInBackground(URL... urls) {
        String result = "";
        HttpURLConnection con = null;
        HttpResponse httpResponse = null;
        try{
            con = (HttpURLConnection) urls[0].openConnection();
            con.setReadTimeout(10000);
            con.setConnectTimeout(15000);
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.connect();

            httpResponse = new HttpResponse(con.getResponseCode(), readResult(con.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(con != null){
                con.disconnect();
            }
        }
        return httpResponse;
    }

    private String readResult(InputStream inputStream) throws IOException {
        StringBuffer sb = new StringBuffer();
        String line = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        while((line = br.readLine()) != null){
            sb.append(line);
        }
        try{
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }
}
