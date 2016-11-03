package com.project.employeerecord;

import com.project.database.Database;

import android.app.Activity;
import android.os.Bundle;

import android.widget.Toast;

public class ThirdActivity extends Activity {
	
	Database db;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		
		db = new Database(ThirdActivity.this);
		
		Bundle b=getIntent().getExtras();
		String userName=b.getString("UserName");
		
		Toast.makeText(ThirdActivity.this, "Welcome "+userName, Toast.LENGTH_LONG).show();
		
		
	}

	
}
