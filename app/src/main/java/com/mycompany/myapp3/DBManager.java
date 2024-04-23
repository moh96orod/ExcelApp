package com.mycompany.myapp3;

import android.content.*;
import android.database.*;
import android.database.sqlite.*;
import android.util.*;
import java.util.*;

public class DBManager extends SQLiteOpenHelper
{

	private static final String dbname = "ExcelDB.db";
	
	
	public DBManager(Context context) {
		super(context, dbname, null, 1);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		String query = "create table exceltb (name, explain)";
		db.execSQL(query);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		db.execSQL("DROP TABLE IF EXSITS exceltb");
		onCreate(db);
		
	}
	
	public String addRecord(String name, String explain) {
		SQLiteDatabase db = this.getWritableDatabase();

		
		ContentValues cv = new ContentValues();
		cv.put("name", name);
		cv.put("explain", explain);
		
		
		
		
		long res = db.insert("exceltb", null, cv);
		
		if(res == -1) {
			return "fail";
		} else {
			return "successfully";
		}
	}
	
	public ArrayList<String> fetchAll ()
	{

		ArrayList data = new ArrayList<String>();
		SQLiteDatabase sql = this.getReadableDatabase();
		Cursor c = sql.rawQuery("SELECT * FROM exceltb", null, null);
		while(c.moveToNext()) {
			Log.e(c.getString(0), "message");

			data.add(c.getString(1));
		}

		c.close();

		return data;


	}
	
}
