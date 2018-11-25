package ph05730.vanloc.com.ordering.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ph05730.vanloc.com.ordering.R;
import ph05730.vanloc.com.ordering.database.DBManager;
import ph05730.vanloc.com.ordering.goiham;
import ph05730.vanloc.com.ordering.model.BanAn;

public class BanAnDAO implements goiham {
    private DBManager dbManager;

    public BanAnDAO(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public boolean insertbanban(String tenbanan){

        SQLiteDatabase db=dbManager.getWritableDatabase();
        ContentValues contentValues =new ContentValues();

        contentValues.put(BANAN_TENBAN,tenbanan);
        contentValues.put(BANAN_TINHTRANG,"false");

       long kiemtra= db.insert(TB_BANAN,null,contentValues);
        if (kiemtra!=0){
            return true;
        }
        else {
            return false;
        }


    }

    public List<BanAn> laydsbanan(){

        SQLiteDatabase db=dbManager.getWritableDatabase();
        List<BanAn> banAnList=new ArrayList<>();
        String truyvan="SELECT * FROM " + TB_BANAN;
        Cursor cursor= db.rawQuery(truyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            BanAn banAn=new BanAn();
            banAn.setMabanan(cursor.getInt(cursor.getColumnIndex(BANAN_MABAN)));
            banAn.setTenbanan(cursor.getString(cursor.getColumnIndex(BANAN_TENBAN)));

            banAnList.add(banAn);
            cursor.moveToNext();

        }

    return banAnList;


    }
}
