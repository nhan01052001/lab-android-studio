package com.example.connectwithdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler<Contact> extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "customerDB";
    private static final String TABLE_CUSTOMER = "customer";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CUSTOMER + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT)";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMER);
        onCreate(db);
    }

    public void addUser(Customer cus) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, cus.getName());

        // Inserting Row
        db.insert(TABLE_CUSTOMER, null, values);
        //2nd argument is String containing nullColumnHack
        //db.close(); // Closing database connection
    }

    Customer getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CUSTOMER, new String[] { KEY_ID,
                        KEY_NAME }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Customer cus = new Customer(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));

        return cus;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> cusList = new ArrayList<Customer>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CUSTOMER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Customer cus = new Customer();
                cus.setId(Integer.parseInt(cursor.getString(0)));
                cus.setName(cursor.getString(1));
                // Adding contact to list
                cusList.add(cus);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return cusList;
    }

    public void deleteCustomer(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(
                TABLE_CUSTOMER,
                KEY_ID + "=?",
                new String[]{String.valueOf(id)}
        );

        db.close();
    }

    public int countCustomer(){
        String count = "SELECT * FROM " + TABLE_CUSTOMER;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(count, null);

        cursor.close();;

        return cursor.getCount();
    }

}
