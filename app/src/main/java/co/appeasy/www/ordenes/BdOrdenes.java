package co.appeasy.www.ordenes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Fredy on 09/11/2018.
 */

public class BdOrdenes extends SQLiteOpenHelper{

    String sqlCreate = "CREATE TABLE ordenes (codigo INTEGER, nombre TEXT)";

    public BdOrdenes(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //CREAMOS BD POR PRIMERA VEZ
    db.execSQL(sqlCreate);

    }

    //CONSTRUCTOR

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        //ACUTALIZAMOS NUEVAS VERSIONES
        //PODEMO USAR CASE

      //  db.execSQL("DROP TABLE IF EXISTS ordenes");

        //Creamos nueva tabla
       // db.execSQL("sqlCreate");

    }
}
