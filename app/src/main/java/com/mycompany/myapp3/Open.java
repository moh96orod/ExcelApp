package com.mycompany.myapp3;

import android.app.*;
import android.database.*;
import android.database.sqlite.*;
import android.os.*;
import android.util.*;
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.*;
import java.util.function.*;
import android.view.View.*;
import android.widget.AdapterView.*;
import android.view.*;
import com.mycompany.myapp3.Table.*;

public class Open extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.open);
		
		LinearLayout li = (LinearLayout) findViewById(R.id.openLinearLayout1);
		
		SQLiteDatabase loadDatabse = openOrCreateDatabase("kx.db", MODE_PRIVATE, null);

		saveDataTable x = new saveDataTable(this);
		
		Cursor result = loadDatabse.rawQuery("Select * from data", null);
		long count2 = DatabaseUtils.queryNumEntries(loadDatabse, "data");
		ArrayList<String> list = new ArrayList<>();
		
		
		ArrayList data = x.fetchAll();
		
		DBManager sql = new DBManager(this);
		ArrayList data2 = sql.fetchAll();
		
		ListView ll = (ListView) findViewById(R.id.openListView1);
		ArrayAdapter aa = new ArrayAdapter<String>(this, R.layout.listview_item, R.id.listviewitemTextView1, data2);
		ll.setAdapter(aa);
		
		
		
	}
}
