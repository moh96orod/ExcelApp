package com.mycompany.myapp3.Table;


import android.database.sqlite.*;
import android.content.*;
import android.widget.*;
import java.util.*;
import android.database.*;
import android.util.*;

public class saveDataTable extends SQLiteOpenHelper
{

	private static final String dbname = "kx.db";


	public saveDataTable(Context context) {
		super(context, dbname, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		String query = "create table data (text1, text2, text3)";
		db.execSQL(query);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		db.execSQL("DROP TABLE IF EXSITS data");
		onCreate(db);

	}

	public String addRecord(String v1, String v2, String v3) {
		SQLiteDatabase db = this.getWritableDatabase();


		ContentValues cv = new ContentValues();
		cv.put("text1", v1);
		cv.put("text2", v2);
		cv.put("text3", v3);

		long res = db.insert("data", null, cv);

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
		Cursor c = sql.rawQuery("SELECT * FROM data", null, null);
		while(c.moveToNext()) {
			Log.e(c.getString(0), "message");
			
			data.add(c.getString(0));
		}
		
		c.close();
		
		return data;
		
		
	}

}
