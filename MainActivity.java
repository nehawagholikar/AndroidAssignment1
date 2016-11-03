package com.project.employeerecord;





import com.project.database.Database;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity 
{
	Button login;
	EditText das_id,password;
	Database db;
	TextView signup;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		db=new Database(MainActivity.this);
		das_id=(EditText)findViewById(R.id.dasid);
		password=(EditText)findViewById(R.id.password);
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		login=(Button)findViewById(R.id.login);
		
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(db.check(das_id.getText().toString(), password.getText().toString()))
				{
					
					Bundle b=getIntent().getExtras();
					String userName=b.getString("UserName");
					
					Intent intent=new Intent(MainActivity.this,ThirdActivity.class);
					
					Bundle bb=new Bundle();
					bb.putString("UserName",userName);
					intent.putExtras(bb);
					startActivity(intent);
				}
				else
				{
					Toast.makeText(MainActivity.this, "Wrong DAS ID or Password or create new account", Toast.LENGTH_LONG).show();
				}
								
				
			}
		});
		
		signup = (TextView) findViewById(R.id.signup);
	  //  signup.setMovementMethod(LinkMovementMethod.getInstance());
	    
	    signup.setOnClickListener( new View.OnClickListener()
	    {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,SecondActivity.class);
				startActivity(intent);
			
			}
		});

	}

	//@Override
	/*public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.login:
			
			if(db.check(das_id.getText().toString(), password.getText().toString()))
			{
				
				Bundle b=getIntent().getExtras();
				String userName=b.getString("UserName");
				
				Intent intent=new Intent(MainActivity.this,ThirdActivity.class);
				
				Bundle bb=new Bundle();
				bb.putString("UserName",userName);
				intent.putExtras(bb);
				startActivity(intent);
			}
			else
			{
				Toast.makeText(MainActivity.this, "Wrong DAS ID or Password or create new account", Toast.LENGTH_LONG).show();
			}
			
			break;
		case R.id.signup:
			Intent intent=new Intent(MainActivity.this,SecondActivity.class);
			startActivity(intent);
			break;
		}
	}*/
}
