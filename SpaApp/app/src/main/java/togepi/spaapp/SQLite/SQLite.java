package togepi.spaapp.SQLite;

import java.util.HashMap;
import java.util.Map;

import togepi.spaapp.utility.Genre;
import togepi.spaapp.utility.PartySetting;

/**
 * Created by youmemusic on 2016/05/15.
 */
public class SQLite {

    /**
     * パーティIDをDBから取得する
     * @return
     */
    public String GetHostID(){
        return "";
    }

    /**
     * パーティIDをDBに登録する
     * @param hostID
     */
    public void SetHostID(String hostID){

    }

    /**
     * UserIDをDBから取得する
     * @return
     */
    public String GetUserID(){
        return "";
    }

    /**
     * UserIDをDBに登録する
     * @param userID
     */
    public void SetUserID(String userID){

    }

    /**
     * パーティ設定をDBから取得する
     * @return
     */
    public PartySetting GetPartySetting(){
        PartySetting partySetting = new PartySetting();

        return partySetting;
    }

    /**
     * パーティ設定をDBに登録する
     */
    public void SetPartySetting(PartySetting partySetting){

    }

    /**
     * 賞品の順位と金額とジャンルをDBに登録する
     * @param rank
     * @param value
     * @param genre
     */
    public void SetGenreOgRanking(int rank, int value, Genre genre){

    }

}
