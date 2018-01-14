package nyc.c4q.sqlinclass.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.sqlinclass.model.Laptop;

/**
 * Created by yokilam on 1/14/18.
 */

public class LaptopDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME= "Laptop.db";
    private static final String TABLE_NAME= "Laptop";
    private static final int SCHEMA_VERSION= 1;

    public LaptopDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "name TEXT, date_time TEXT, color TEXT, classnumber INTEGER, condition TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addLaptop(Laptop laptop){
        Cursor cursor= getReadableDatabase().rawQuery("SELECT * FROM" + TABLE_NAME
                + "WHERE name = '" + laptop.getName() + "' AND date = '" + laptop.getDateTime()
                + "'And color= '" + laptop.getColor() + "' AND classnumber = '" + laptop.getClassnumber() + "'condition = '" + laptop.getCondition() +
                "';", null);
        if (cursor.getCount()== 0){
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                    "(name, datetime, color, classnumber, condition) VALUES ('" + laptop.getName() + "', '"
                    + laptop.getDateTime() + "', '" + laptop.getColor() + "', '" + laptop.getClassnumber()
                    + "', '" + laptop.getColor() + "', '" + laptop.getCondition() +"');");
        }
        cursor.close();
    }


    public List<Laptop> getLaptopList() {
        List<Laptop> laptopList= new ArrayList <>();
        Cursor cursor= getReadableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME + ";", null);
        if(cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Laptop laptop= new Laptop(
                            cursor.getString(cursor.getColumnIndex("name")),
                            cursor.getString(cursor.getColumnIndex("datetime")),
                            cursor.getString(cursor.getColumnIndex("color")),
                            cursor.getInt(cursor.getColumnIndex("classnumber")),
                            cursor.getString(cursor.getColumnIndex("condition")));
                    laptopList.add(laptop);
                } while (cursor.moveToNext());

            }
        }
        return laptopList;
    }
}
