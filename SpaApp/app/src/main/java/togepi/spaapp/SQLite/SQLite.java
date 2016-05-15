package togepi.spaapp.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import togepi.spaapp.utility.Genre;
import togepi.spaapp.utility.PartySetting;

/**
 * Created by youmemusic on 2016/05/15.
 */
public class SQLite {


    public SQLite(){

    }

    /**
     * パーティIDをDBから取得する
     * @return
     */
    public String GetHostID(Context context){
        DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper(context);
        SQLiteDatabase db = databaseOpenHelper.getReadableDatabase();

        Cursor c = db.query("partySettings", new String[] { "hostID" }, null, null, null, null, null);

        boolean mov = c.moveToFirst();
        String hostId = null;
        hostId = c.getString(0);

//        while (mov) {
//            hostId = c.getString(0);
//            mov = c.moveToNext();
//        }
        return hostId;
    }

    /**
     * パーティIDをDBに登録する
     * @param hostID
     */
    public void SetHostID(String hostID,Context context){
        final DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper(context);
        SQLiteDatabase db = null;
        try {
            db = databaseOpenHelper.getWritableDatabase();
            ContentValues insertValues = new ContentValues();
            insertValues.put("hostID", hostID);
            db.insert("partySettings", null, insertValues);
        } finally {
            if(db != null){
                db.close();
            }
        }
    }

    /**
     * UserIDをDBから取得する
     * @return
     */
    public String GetUserID(Context context){
        DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper(context);
        SQLiteDatabase db = databaseOpenHelper.getReadableDatabase();

        Cursor c = db.query("users", new String[] { "_id" }, null, null, null, null, null);

        boolean mov = c.moveToFirst();
        String userId = null;
        userId = c.getString(0);

//        while (mov) {
//            userId = c.getString(0);
//            mov = c.moveToNext();
//        }
        return userId;
    }

    /**
     * UserIDをDBに登録する
     * @param userID
     */
    public void SetUserID(String userID,Context context){
        final DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper(context);
        SQLiteDatabase db = null;
        try {
            db = databaseOpenHelper.getWritableDatabase();
            ContentValues insertValues = new ContentValues();
            insertValues.put("_id", userID);
            db.insert("users", null, insertValues);
        } finally {
            if(db != null){
                db.close();
            }
        }
    }

    /**
     * パーティ設定をDBから取得する
     * @return
     */
    public PartySetting GetPartySetting(Context context){
        PartySetting partySetting = new PartySetting();
//
//        DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper(context);
//        SQLiteDatabase db = databaseOpenHelper.getReadableDatabase();
//
//        Cursor c = db.query("partySettings", new String[] { "hostID", "initialMoney", "prizeNumber", "RankingFlag"}, null, null, null, null, null);
//
//        boolean mov = c.moveToFirst();
//        String hostId = c.getString(0);
//        while (mov) {
//            mov = c.moveToNext();
//        }

        return partySetting;
    }

    /**
     * パーティ設定をDBに登録する
     */
    public void SetPartySetting(PartySetting partySetting,Context context){

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
