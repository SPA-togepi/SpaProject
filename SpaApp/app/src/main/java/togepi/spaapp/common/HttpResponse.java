package togepi.spaapp.common;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by SuzukiRikuro on 2016/05/15.
 */
public class HttpResponse extends AsyncTask<Void, Void, JSONObject> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // doInBackground前処理
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        HttpURLConnection con = null;
        URL url = null;
        String urlStr = "http://ec2-54-199-215-9.ap-northeast-1.compute.amazonaws.com:3000/";

        try {
            // URLの作成
            url = new URL(urlStr);
            // 接続用HttpURLConnectionオブジェクト作成
            con = (HttpURLConnection) url.openConnection();
            // リクエストメソッドの設定
            con.setRequestMethod("POST");
            // リダイレクトを自動で許可しない設定
            con.setInstanceFollowRedirects(false);
            // URL接続からデータを読み取る場合はtrue
            con.setDoInput(true);
            // URL接続にデータを書き込む場合はtrue
            con.setDoOutput(true);

            // 接続開始
            con.connect();

            // 本文の取得
            InputStream in = con.getInputStream();
            byte bodyByte[] = new byte[1024];
            in.read(bodyByte);
            //Jsonを取得する
            String readSt = readInputStream(in);
            in.close();

            return new JSONObject(readSt);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(JSONObject result) {
        super.onPostExecute(result);
        // doInBackground後処理
    }

    public String readInputStream(InputStream in) throws IOException, UnsupportedEncodingException {
        StringBuffer sb = new StringBuffer();
        String st = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        while ((st = br.readLine()) != null) {
            sb.append(st);
        }
        try {
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
