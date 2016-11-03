package com.project.employeerecord;

import com.project.database.Database;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;

import android.view.View;


import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends Activity
{
	Button save,reset;
	Database db;
	EditText das_id,username,password,confirm_password;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		try
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_second);
			db=new Database(SecondActivity.this);
			save=(Button)findViewById(R.id.save);
			reset=(Button)findViewById(R.id.reset);
			das_id=(EditText)findViewById(R.id.dasid);
			username=(EditText)findViewById(R.id.username);
			password=(EditText)findViewById(R.id.password);
			confirm_password=(EditText)findViewById(R.id.confpassword);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		try
		{

			save.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					show_alertdialog();
				}
			});


			reset.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					das_id.setText("");
					password.setText("");
					username.setText("");
					confirm_password.setText("");
				}
			});
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}	
	protected void show_alertdialog()
	{
		// TODO Auto-generated method stub

		AlertDialog.Builder alert=new AlertDialog.Builder(this);
		alert.setMessage("Do you want save ?");
		alert.setTitle("Confirmation");

		alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				// TODO Auto-generated method stub
				db.addEmployee(das_id.getText().toString(), username.getText().toString(), password.getText().toString(), confirm_password.getText().toString());
				Toast.makeText(SecondActivity.this, "Record inserted", Toast.LENGTH_LONG).show();
				Intent intent=new Intent(SecondActivity.this,MainActivity.class);
				Bundle b=new Bundle();
				b.putString("UserName", username.getText().toString());
				intent.putExtras(b);
				startActivity(intent);
			}
		});

		alert.setNegativeButton("No", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				das_id.setText("");
				password.setText("");
				confirm_password.setText("");
				username.setText("");
			}
		});
		alert.show();

	}

}



/*
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			switch(v.getId())
			{
			case R.id.save:

				AlertDialog.Builder alert=new AlertDialog.Builder(this);
				alert.setMessage("Do you want save ?");
				alert.setTitle("Confirmation");
				alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) 
					{
						// TODO Auto-generated method stub
						db.addEmployee(das_id.getText().toString(), username.getText().toString(), password.getText().toString(), confirm_password.getText().toString());
						Toast.makeText(SecondActivity.this, "Record inserted", Toast.LENGTH_LONG).show();
						Intent intent=new Intent(SecondActivity.this,MainActivity.class);
						Bundle b=new Bundle();
						b.putString("UserName", username.getText().toString());
						intent.putExtras(b);
						startActivity(intent);
					}
				});

				alert.setNegativeButton("No", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						das_id.setText("");
						password.setText("");
						confirm_password.setText("");

					}
				});
				alert.show();

				break;
			case R.id.reset:
					das_id.setText("");
					password.setText("");
					confirm_password.setText("");
				break;
			}
		}
	}		
		save.setOnClickListener(new View.OnClickListener() 
		{

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				AlertDialog.Builder alert=new AlertDialog.Builder(this);
				alert.setMessage("Do you want save ?");
				alert.setTitle("Confirmation");
				alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) 
					{
						// TODO Auto-generated method stub
						db.addEmployee(das_id.getText().toString(), username.getText().toString(), password.getText().toString(), confirm_password.getText().toString());
						Toast.makeText(SecondActivity.this, "Record inserted", Toast.LENGTH_LONG).show();
						Intent intent=new Intent(SecondActivity.this,MainActivity.class);
						Bundle b=new Bundle();
						b.putString("UserName", username.getText().toString());
						intent.putExtras(b);
						startActivity(intent);
					}
				});

				alert.setNegativeButton("No", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						das_id.setText("");
						password.setText("");
						confirm_password.setText("");

					}
				});
				show_alertdialog();

			}
		});

		reset.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				das_id.setText("");
				password.setText("");
				confirm_password.setText("");
			}
		});

	}
 */






