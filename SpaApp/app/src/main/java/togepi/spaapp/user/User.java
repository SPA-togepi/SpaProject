package togepi.spaapp.user;

import android.graphics.Bitmap;

/**
 * Created by hirano on 2016/05/14.
 */
public class User {
    public int  donationAmount = 0;
    public String id;
    public Bitmap bmp;

    public int getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(int donationAmount) {
        this.donationAmount = donationAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Bitmap getBmp() {
        return bmp;
    }

    public void setBmp(Bitmap bmp) {
        this.bmp = bmp;
    }
}
