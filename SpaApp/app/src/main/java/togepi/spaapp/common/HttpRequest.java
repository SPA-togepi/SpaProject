package togepi.spaapp.common;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * HTTPリクエスト操作クラス。<br />
 */
public class HttpRequest {
    /*
     * GETリクエスト。<br />
     * @param uri URI
     */
//    protected HttpResponse doGet(String uri) throws IOException {
//        URL urlObj = new URL("http://" + this.webHost + uri);
//        HttpURLConnection http = (HttpURLConnection) urlObj.openConnection();
//        http.setRequestMethod("GET");
//        http.connect();
//        // 結果を取得
//        return getResponse(http, null);
//    }
    /*
     * POSTリクエスト。<br />
     * @param uri URI
     * @param postData POSTするデータ
     */
    protected HttpResponse doPost(String urlStr, String jsonStr) throws IOException {

        HttpResponse httpResponse = null;
        try {
            String buffer = "";
            HttpURLConnection con = null;
            URL url = new URL(urlStr);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setInstanceFollowRedirects(false);
            con.setRequestProperty("Accept-Language", "jp");
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            OutputStream os = con.getOutputStream();
            PrintStream ps = new PrintStream(os);
            ps.print(jsonStr);
            ps.close();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            buffer = reader.readLine();

            JSONArray jsonArray = new JSONArray(buffer);

            httpResponse = getResponse(con, jsonArray);
            con.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return httpResponse;
    }
    /*
     * レスポンスデータを取得する。<br />
     * @param http http接続オブジェクト
     * @param webEncode エンコーディング
     */
    private HttpResponse getResponse(HttpURLConnection http, JSONArray jsonArray) throws IOException {
        HttpResponse response = new HttpResponse();
        // ステータスコードの取得
        response.setStatus(http.getResponseCode());

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

            response.setBody(bodyByte.toString());
            response.setJSONArray(jsonArray);

            return response;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
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