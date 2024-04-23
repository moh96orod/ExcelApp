package com.mycompany.myapp3;

import android.app.*;
import android.database.*;
import android.database.sqlite.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import java.util.*;
import android.util.*;
import com.mycompany.myapp3.Table.*;

public class MainProject extends Activity
{
	 public static final ArrayList< String > data = new ArrayList();
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.project);
		
		TextView projectName = (TextView) findViewById(R.id.projectTextView1);
		
		SQLiteDatabase loadDatabse = openOrCreateDatabase("ExcelDB.db", MODE_PRIVATE, null);

		Cursor result = loadDatabse.rawQuery("Select * from exceltb", null);

		result.moveToFirst();

		String name1 = result.getString(1);
		
		projectName.setText(name1);
		
		
	}
	
	public void save(View v) {
		TextView projectName = (TextView) findViewById(R.id.projectTextView1);
		String name = projectName.getText().toString();
		
		EditText ed1 = (EditText) findViewById(R.id.projectEditText1);
		EditText ed2 = (EditText) findViewById(R.id.projectEditText2);
		EditText ed3 = (EditText) findViewById(R.id.projectEditText3);
		
		String value1 = ed1.getText().toString();
		String value2 = ed2.getText().toString();
		String value3 = ed3.getText().toString();
		
		saveDataTable db = new saveDataTable(this);
		
		db.addRecord(value1, value2, value3);
		
		Toast.makeText(getApplicationContext(), "Saved!", Toast.LENGTH_SHORT).show();
	}
	
	public void addLayout(View v) {
		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.HORIZONTAL);
		
		
		
		
		EditText tv1 = new EditText(this);
		tv1.setText("EditText");
		
		EditText tv2 = new EditText(this);
		tv2.setText("EditText2");
		
		EditText tv3 = new EditText(this);
		tv3.setText("EditText3");
		
		
		
		ll.addView(tv1);
		ll.addView(tv2);
		ll.addView(tv3);
		
		LinearLayout lv1 = (LinearLayout) findViewById(R.id.projectLinearLayout1);
		lv1.addView(ll);
		
		Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
	}
	
}
