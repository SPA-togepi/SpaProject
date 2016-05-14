package togepi.spaapp.admin;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import togepi.spaapp.SQLite.SQLite;
import togepi.spaapp.utility.Genre;
import togepi.spaapp.utility.PartySetting;

/**
 * Created by youmemusic on 2016/05/14.
 */
public class AdminFacade {

    SQLite sqLite;

    /**
     * パーティーを新規作成する
     * @param hostID パーティID。Adminが設定する。
     */
    public void CreateParty(String hostID){
        try{
            String checkHostID = "";
            if(checkHostID == null || checkHostID.equals("")){
                //POST hostIDを登録する
            }
        }
        catch (Exception e){
            Log.e("CreateParty",e.toString());
        }
    }

    /**
     * パーティの基本情報を設定する
     * @param initialMoney 初期金額
     * @param prizeNumber 賞品の総数
     * @param rankingFlag 順位付けをするか。true:yes false:no
     * @param prizeGenreList 賞品のジャンルリスト。先頭が1位
     */
    public void SettingParty(int initialMoney, int prizeNumber, boolean rankingFlag, List<Genre> prizeGenreList){
        try{
            String hostID = sqLite.GetHostID();
            List<Integer> valueOdRank = GetValueOfRank(initialMoney,prizeNumber,rankingFlag);

            for(int i =1;i <= valueOdRank.size();i++){
                //SQLite 順位、金額、ジャンルを登録
                sqLite.SetGenreOgRanking(i,valueOdRank.get(i),prizeGenreList.get(i));
            }

            //POST パーティの設定をする


            //PartySettingをSQLに登録
            PartySetting partySetting = new PartySetting();
            partySetting.setHostID(hostID);
            partySetting.setInitialMoney(initialMoney);
            partySetting.setPrizeNumber(prizeNumber);
            partySetting.setRankingFlag(rankingFlag);
            partySetting.setGenreList(prizeGenreList);

            sqLite.SetPartySetting(partySetting);

        }
        catch (Exception e){
            Log.e("SettingParty",e.toString());
        }

    }

    /**
     * カンパを締め切る
     */
    public void EndDonate(){

    }



    public List GetValueOfRank(int currentMoney,int prizeNumber,boolean rankingFlag){
        List valueOfRate = new ArrayList();

        //順位付けする場合は重み
        if(rankingFlag){
            int denominator = 0;//分母

            for (int i = 1;i <= denominator; i++){
                denominator+=i;
            }

            int molecule = prizeNumber;//分子
            for(int i=0; i<prizeNumber;i++) {
                valueOfRate.add(currentMoney * (double) (molecule / denominator));
                molecule--;
            }
        }
        //順位付けしない場合は、等分にする
        else{
            for(int i = 0; i < prizeNumber; i++){
                valueOfRate.add(currentMoney/prizeNumber);
            }
        }

        return valueOfRate;
    }


}
