package togepi.spaapp.admin;

import java.util.List;

import togepi.spaapp.utility.Genre;

/**
 * Created by youmemusic on 2016/05/14.
 */
public class AdminFacade {

    /**
     * パーティーを新規作成する
     * @param hostID パーティID。Adminが設定する。
     */
    public void CreateParty(String hostID){

    }

    /**
     * パーティの基本情報を設定する
     * @param initialMoney 初期金額
     * @param prizeNumber 賞品の総数
     * @param RankingFlag 順位付けをするか。true:yes false:no
     * @param prizeGenreList 賞品のジャンルリスト。先頭が1位
     */
    public void SettingParty(int initialMoney, int prizeNumber, boolean RankingFlag, List<Genre> prizeGenreList){

    }

    /**
     * カンパを締め切る
     */
    public void EndDonate(){

    }


}
