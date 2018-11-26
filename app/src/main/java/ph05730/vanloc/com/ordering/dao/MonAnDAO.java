package ph05730.vanloc.com.ordering.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import ph05730.vanloc.com.ordering.database.DBManager;
import ph05730.vanloc.com.ordering.goiham;
import ph05730.vanloc.com.ordering.model.MonAn;

public class MonAnDAO implements goiham {
    private DBManager dbManager;

    public MonAnDAO(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public boolean themmonan(MonAn monAn){
        SQLiteDatabase db=dbManager.getWritableDatabase();
        ContentValues contentValues =new ContentValues();

        contentValues.put(MONAN_TENMONAN,monAn.getTenMonAn());
        contentValues.put(MONAN_GIATIEN,monAn.getGiatien());
        contentValues.put(MONAN_MALOAI,monAn.getMaLoai());
        contentValues.put(MONAN_HINHANH, monAn.getHinhanh());

        long kiemtra=db.insert(TB_MONAN,null,contentValues);
        if (kiemtra!=0){
            return true;
        }else {
            return false;
        }
    }
}
