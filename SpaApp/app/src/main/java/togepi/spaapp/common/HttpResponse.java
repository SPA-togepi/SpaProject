package togepi.spaapp.common;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by SuzukiRikuro on 2016/05/15.
 */

public class HttpResponse {

    private int status;
    private String body;
    private JSONObject jsonArray;


    public void setStatus(int status) { this.status = status; }
    public int getStatus() { return this.status; }

    public void setBody(String body) {
        this.body = body;
    }
    public String getBody() { return this.body; }

    public void setJSONArray(JSONObject JSONArray) {
        this.jsonArray = JSONArray;
    }
    public JSONObject getJsonArray() { return this.jsonArray; }
}
//public class HttpResponse extends AsyncTask<Void, Void, JSONObject> {
//
//    private LinkedHashMap<String, String> header;
//    private int status;
//
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//        // doInBackground前処理
//    }
//
//    @Override
//    protected JSONObject doInBackground(Void... params) {
//        HttpURLConnection con = null;
//        URL url = null;
//        String urlStr = "http://ec2-54-199-215-9.ap-northeast-1.compute.amazonaws.com:3000/";
//
//        try {
//            // URLの作成
//            url = new URL(urlStr);
//            // 接続用HttpURLConnectionオブジェクト作成
//            con = (HttpURLConnection) url.openConnection();
//            // リクエストメソッドの設定
//            con.setRequestMethod("POST");
//            // リダイレクトを自動で許可しない設定
//            con.setInstanceFollowRedirects(false);
//            // URL接続からデータを読み取る場合はtrue
//            con.setDoInput(true);
//            // URL接続にデータを書き込む場合はtrue
//            con.setDoOutput(true);
//
//            // 接続開始
//            con.connect();
//
//            // 本文の取得
//            InputStream in = con.getInputStream();
//            byte bodyByte[] = new byte[1024];
//            in.read(bodyByte);
//            //Jsonを取得する
//            String readSt = readInputStream(in);
//            in.close();
//
//            return new JSONObject(readSt);
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    @Override
//    protected void onPostExecute(JSONObject result) {
//        super.onPostExecute(result);
//        // doInBackground後処理
//    }
//
//    public String readInputStream(InputStream in) throws IOException, UnsupportedEncodingException {
//        StringBuffer sb = new StringBuffer();
//        String st = "";
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
//        while ((st = br.readLine()) != null) {
//            sb.append(st);
//        }
//        try {
//            in.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return sb.toString();
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public void setHeader(LinkedHashMap<String,String> header) {
//        this.header = header;
//    }
//}
