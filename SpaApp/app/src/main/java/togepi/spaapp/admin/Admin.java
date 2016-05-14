package togepi.spaapp.admin;

import java.util.List;

import togepi.spaapp.user.User;
import togepi.spaapp.utility.Genre;

/**
 * Created by hirano on 2016/05/14.
 */
public class Admin {
    int initialMoney;
    int currentMoney;
    List<User> ptUsers;
    List<Prize> ptPrizes;
    int prizeNumber;
    int leftItemNum;
    List<Genre> genreList;

    public int getInitialMoney() {
        return initialMoney;
    }

    public void setInitialMoney(int initialMoney) {
        this.initialMoney = initialMoney;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public List<User> getPtUsers() {
        return ptUsers;
    }

    public void setPtUsers(List<User> ptUsers) {
        this.ptUsers = ptUsers;
    }

    public List<Prize> getPtPrizes() {
        return ptPrizes;
    }

    public void setPtPrizes(List<Prize> ptPrizes) {
        this.ptPrizes = ptPrizes;
    }

    public int getPrizeNumber() {
        return prizeNumber;
    }

    public void setPrizeNumber(int prizeNumber) {
        this.prizeNumber = prizeNumber;
    }

    public int getLeftItemNum() {
        return leftItemNum;
    }

    public void setLeftItemNum(int leftItemNum) {
        this.leftItemNum = leftItemNum;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }
}
