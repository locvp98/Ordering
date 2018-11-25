package ph05730.vanloc.com.ordering.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ph05730.vanloc.com.ordering.goiham;

public class DBManager extends SQLiteOpenHelper implements goiham {

    public DBManager( Context context) {
        super(context,"quanlynhahang", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tbNhanVIEN);
        db.execSQL(tbMONAN);
        db.execSQL(tbLOAIMONAn);
        db.execSQL(tbBANAN);
        db.execSQL(tbgoimon);
        db.execSQL(tbchitietgoimon);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
