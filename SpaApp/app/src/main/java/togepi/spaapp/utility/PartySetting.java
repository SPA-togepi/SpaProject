package togepi.spaapp.utility;

import java.util.List;

/**
 * Created by youmemusic on 2016/05/15.
 */
public class PartySetting {
    public String hostID;
    public int initialMoney;
    public int prizeNumber;
    public boolean RankingFlag;
    List<Genre> genreList;

    public String getHostID() {
        return hostID;
    }

    public void setHostID(String hostID) {
        this.hostID = hostID;
    }

    public int getInitialMoney() {
        return initialMoney;
    }

    public void setInitialMoney(int initialMoney) {
        this.initialMoney = initialMoney;
    }

    public int getPrizeNumber() {
        return prizeNumber;
    }

    public void setPrizeNumber(int prizeNumber) {
        this.prizeNumber = prizeNumber;
    }

    public boolean isRankingFlag() {
        return RankingFlag;
    }

    public void setRankingFlag(boolean rankingFlag) {
        RankingFlag = rankingFlag;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }
}
