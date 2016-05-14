package togepi.spaapp.user;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import togepi.spaapp.admin.Prize;

/**
 * Created by youmemusic on 2016/05/14.
 */
public class UserFacade {

    public UserFacade() {
    }

    /**
     * パーティに参加する
     * @param hostID パーティID
     */
    public void JoinParty(String hostID){

    }

    /**
     * カンパする
     * @param donationAmount カンパする金額
     */
    public void Donate(int donationAmount){

    }

    /**
     * 選択した順位の商品情報を取得する
     * @param price 賞品の金額
     * @return 商品情報のリスト
     */
    public List<Prize> GetPrizeInfo(int price){
        List<Prize> prizeList = new ArrayList<Prize>();

        return prizeList;
    }

    /**
     * 現在の合計金額を取得する
     * @return 現在の合計金額
     */
    public int GetCurrentMoney(){
        int currentMoney = 0;

        return currentMoney;
    }

    /**
     * 現在の自分のカンパ金額を取得する
     * @return 現在の自分のカンパ金額
     */
    public int GetCurrentDonationAmount(){
        int currentDonationAmount = 0;
        return currentDonationAmount;
    }

}
