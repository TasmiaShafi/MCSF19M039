package com.example.dbpracticelec10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String CUSTOMER_NAME = "CustomerName";
    public static final String CUSTOMER_AGE = "CustomerAge";
    public static final String ACTIVE_CUSTOMER = "ActiveCustomer";
    public static final String CUSTOMER_ID = "CustomerID";
    public static final String CUST_TABLE = "CustTable";
    public DatabaseHelper(@Nullable Context context) {
        super(context, "MyDB.db", null, 1);
    }
    public void onCreate(SQLiteDatabase db) {
        //String createTableSTatementOne = "CREATE TABLE CustTable(CustomerID Integer PRIMARY KEY AUTOINCREMENT, " + CUSTOMER_NAME_FIRST + " Text, CustomerAge Int, ActiveCustomer BOOL) ";
        String createTableSTatement = "CREATE TABLE " + CUST_TABLE + "(" + CUSTOMER_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + CUSTOMER_NAME + " Text, " + CUSTOMER_AGE + " Int, " + ACTIVE_CUSTOMER + " BOOL) ";
        db.execSQL(createTableSTatement);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addCustomer(CustomerModel customerModel){
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();

        cv.put(CUSTOMER_NAME, customerModel.getName());
        cv.put(CUSTOMER_AGE, customerModel.getAge());
        cv.put(ACTIVE_CUSTOMER, customerModel.isActive());
        //NullCoumnHack
        long insert = db.insert(CUST_TABLE, null, cv);
        if (insert == -1) { return false; }
        else{return true;}
    }
    public List<CustomerModel> getAllRecord(){
        List<CustomerModel> list=new ArrayList<>();
        String query="SELECT * FROM " + CUST_TABLE;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                Integer Id=cursor.getInt(0);
                String Name=cursor.getString(1);
                Integer Age=cursor.getInt(2);
                Boolean Active=cursor.getInt(3)==1? true: false;
                CustomerModel newCust=new CustomerModel(Name,Age,Active,Id);
                list.add(newCust);

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return list;
    }
    public boolean deleteCustmoer(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        int del=db.delete("CustTable","CustomerID=" + id,null);
        if(del==1)
        {
            db.close();
            return true;
        }

        else{
            db.close();
            return false;

        }


    }

}
