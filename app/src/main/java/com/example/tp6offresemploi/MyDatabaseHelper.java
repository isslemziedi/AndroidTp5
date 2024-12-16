package com.example.tp6offresemploi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    //version BDD
    public static final int DATABASE_VERSION=1;

    //Nom BDD
    public static final String DATABASE_NAME="demo_DB";

    //nom de table offre
    public static final String TABLE_OFFRE="OFFRE";

    //Nom de colonnes Table CONTACT
    public static final String KEY_ID="ID";
    public static final String KEY_POSTE="POSTE";
    public static final String KEY_DESCRIPTION="DESCRIPTION";


    public  MyDatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_OFFRE_TABLE =
                "CREATE TABLE "+ TABLE_OFFRE + "("
                    +KEY_ID + " INTEGER PRIMARY KEY, "
                    +KEY_POSTE + "TEXT, "
                    +KEY_DESCRIPTION + "TEXT" + ")";
        db.execSQL(CREATE_OFFRE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop ancienne table if existe
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_OFFRE);
        //create tables une autre fois
        onCreate(db);

    }

}


