package togepi.spaapp.user;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import togepi.spaapp.SQLite.SQLite;
import togepi.spaapp.admin.Prize;
import togepi.spaapp.common.HttpRequest;
import togepi.spaapp.common.HttpResponse;

/**
 * Created by youmemusic on 2016/05/14.
 */
public class UserFacade {

    public UserFacade() {
    }

    SQLite sqLite = new SQLite();
    HttpRequest httpRequest = new HttpRequest();

    /**
     * パーティに参加する
     * @param hostID パーティID
     */
    public void JoinParty(String hostID, Context context){
        try{
            //userIDが登録されてるか確認
            String userID = sqLite.GetUserID(context);

            if(userID == null || userID.equals("")){
                //GET 新しくIDを作る
                String getRequestUrl = "" ;
                HttpResponse response = httpRequest.doGet(getRequestUrl);
                userID = response.getJsonArray().getString("id");

                sqLite.SetUserID(userID, context);
            }

            //POST パーティに参加する
            //GET パーティに参加する
            String getRequestUrl = "" + "hostID?="+hostID+"&id?="+userID;
            httpRequest.doGet(getRequestUrl);

            sqLite.SetHostID(hostID, context);
        }
        catch (Exception e){
            Log.e("Join Party",e.toString());
        }
    }

    /**
     * カンパする
     * @param donationAmount カンパする金額
     */
    public void Donate(int donationAmount, Context context)  {
        try{
            String hostID = sqLite.GetHostID(context);
            String userID = sqLite.GetUserID(context);

            //カンパ受付中か確認する

//            JSONObject requestJson = new JSONObject();
//            requestJson.accumulate("hostID",hostID);
//            requestJson.accumulate("id",userID);
//            requestJson.accumulate("donationAmount",donationAmount);
//
//            httpRequest = new HttpRequest();
//            httpRequest.doPost("",requestJson.toString());
            //GET カンパする
            String getRequestUrl = ""+"hostID?=" + hostID + "&id?=" + userID + "&donationAmount?=" + donationAmount;
            httpRequest.doGet(getRequestUrl);

        }
        catch (Exception e){
            Log.e("Donate",e.toString());
        }

    }

    /**
     * 選択した順位の商品情報を取得する
     * @param price 賞品の金額
     * @return 商品情報のリスト
     */
    public List<Prize> GetPrizeInfo(int price){
        List<Prize> prizeList = new ArrayList<Prize>();

        try{
            //POST 賞品の一覧を取得する

            //もらった値をprizeにしてく。

        }
        catch(Exception e){
            Log.e("GetPrizeInfo",e.toString());
        }

        return prizeList;
    }

    /**
     * 現在の合計金額を取得する
     * @return 現在の合計金額
     */
    public int GetCurrentMoney(Context context){

        int currentMoney = 0;

        try{
            String hostID = sqLite.GetHostID(context);

            //POST 現在の合計金額を取得する
//            JSONObject requestJson = new JSONObject();
//            requestJson.accumulate("hostID",hostID);
//
//            HttpResponse response = httpRequest.doPost("",requestJson.toString());
//            currentMoney = response.getJsonArray().getInt("currentMoney");

            //GET 現在の合計金額を取得する
            String getRequestUrl = "" + "hostID?=" + hostID;
            HttpResponse response = httpRequest.doGet(getRequestUrl);
            currentMoney = response.getJsonArray().getInt("currentAmount");

        }
        catch (Exception e){
            Log.e("GetCurrentMoney",e.toString());
        }

        return currentMoney;
    }

    /**
     * 現在の自分のカンパ金額を取得する
     * @return 現在の自分のカンパ金額
     */
    public int GetCurrentDonationAmount(Context context){
        int currentDonationAmount = 0;

        try{
            String hostID = sqLite.GetHostID(context);
            String userID = sqLite.GetUserID(context);

            //POST 現在のカンパ金額取得
//            JSONObject requestJson = new JSONObject();
//            requestJson.accumulate("hostID",hostID);
//            requestJson.accumulate("userID",userID);
//
//            HttpResponse response = httpRequest.doPost("",requestJson.toString());
//            currentDonationAmount = response.getJsonArray().getInt("denationAmount");

            //GET 現在のカンパ金額
            String getRequestUrl = "" + "hostID?=" + hostID + "&id?=" + userID;
            HttpResponse response = httpRequest.doGet(getRequestUrl);
            JSONArray userInfoJson = response.getJsonArray().getJSONArray("User");
            currentDonationAmount = userInfoJson.getInt(0);


        }
        catch (Exception e){
            Log.e("GetDonationAmount",e.toString());
        }

        return currentDonationAmount;
    }

}
