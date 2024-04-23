package com.mycompany.myapp3;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import android.content.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		Button newProject = (Button) findViewById(R.id.mainButton1);
		newProject.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View p1)
				{
					Intent i = new Intent(MainActivity.this, CreateProject.class);
					startActivity(i);
				}
		});
		
		Button openProject = (Button) findViewById(R.id.mainButton2);
		openProject.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View p1)
				{
					Intent i = new Intent(MainActivity.this, Open.class);
					startActivity(i);
				}
			});
    }
}
