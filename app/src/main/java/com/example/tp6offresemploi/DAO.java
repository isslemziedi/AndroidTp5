package com.example.tp6offresemploi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DAO {
    protected SQLiteDatabase db=null;
    protected MyDatabaseHelper dbHelper = null;

    public DAO(Context context){
        dbHelper = new MyDatabaseHelper(context);
    }

    public SQLiteDatabase openWrite(){
        db=dbHelper.getWritableDatabase();
        return db;
    }
    public SQLiteDatabase openRead(){
        db=dbHelper.getReadableDatabase();
        return db;
    }

    public void close(){
        db.close();
    }

    //ajout
    public void addOffre(Offre o){
        db=openWrite();
        ContentValues values = new ContentValues();
        //values.put(DataBaseHelper.KEY_ID,c.get_id());
        values.put(MyDatabaseHelper.KEY_POSTE,o.getPoste());
        values.put(MyDatabaseHelper.KEY_DESCRIPTION,o.getDescription());
        db.insert(MyDatabaseHelper.TABLE_OFFRE,null,values);
        db.close();
    }

    //show
    //Récupérer tous les offres
    public List<Offre> allOffres(){
        List<Offre> contactList=new ArrayList<>();
        //Select All Query
        String querySelect="SELECT * FROM "+MyDatabaseHelper.TABLE_OFFRE;
        db=openRead();
        Cursor cursor=db.rawQuery(querySelect,null);
        //Looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do{
                Offre offre = new Offre((int) cursor.getShort(0), cursor.getString(1), cursor.getString(2));
                //Adding a contact to list
                contactList.add(offre);
            }while (cursor.moveToNext());
        }
        // return contactList
        return contactList;
    }

    //update
    //Updating single contact
    public int updateContact(Offre o){
        db=openWrite();
        ContentValues values = new ContentValues();
        values.put(MyDatabaseHelper.KEY_POSTE,o.getPoste());
        values.put(MyDatabaseHelper.KEY_DESCRIPTION,o.getDescription());
        //Updating a row
        return db.update(MyDatabaseHelper.TABLE_OFFRE, values,
                MyDatabaseHelper.KEY_ID+" = ?",new
                        String[]{String.valueOf(o.getId())});
    }

    //delete
    //Delete single offre
    public void deleteContact(Offre o){
        db=openWrite();
        db.delete(MyDatabaseHelper.TABLE_OFFRE,
                MyDatabaseHelper.KEY_ID+ "= ?",
                new String[]{String.valueOf(o.getId())});
        db.close();
    }



    //Récupérer un offre à partir de son id
    /*
    public Offre searchOffreById(int id){
        db=openRead();
        Cursor cursor=db.query(MyDatabaseHelper.TABLE_OFFRE,new String[] { MyDatabaseHelper.KEY_ID,
                MyDatabaseHelper.KEY_POSTE, MyDatabaseHelper.KEY_DESCRIPTION}, MyDatabaseHelper.KEY_ID+"=?", new String[]
                {String.valueOf(id)}, null,null,null,null);
        if (cursor != null)
            cursor.moveToFirst();
        Offre offre = new Offre(cursor.getShort(0), cursor.getString(1), cursor.getString(2));
        // return contact
        return offre;
    }
    */





}
