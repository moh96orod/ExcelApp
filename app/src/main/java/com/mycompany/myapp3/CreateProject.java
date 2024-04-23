package com.mycompany.myapp3;

import android.app.*;
import android.database.*;
import android.database.sqlite.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.content.*;

public class CreateProject extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_project);
		
		
	}
	
	public void save(View v) {
		DBManager db = new DBManager(this);
		
		EditText ed1 = (EditText) findViewById(R.id.createprojectEditText1);
		EditText ed2 = (EditText) findViewById(R.id.createprojectEditText2);
		
		String res = db.addRecord(ed1.getText().toString(), ed2.getText().toString());
		Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
		
		Intent i = new Intent(CreateProject.this, MainProject.class);
		startActivity(i);
		
		ed1.setText("");
	}
	
}
