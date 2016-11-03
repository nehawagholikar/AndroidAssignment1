package com.project.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper
{

	private static final int DATABASE_VERSION=2;

	private static final String DATABASE_NAME="employee_record";

	private static final String TABLE_CONTACTS="login_details";

	private static final String DAS_ID = "DAS_ID";
	private static final String USERNAME = "USERNAME";
	private static final String PASSWORD = "PASSWORD";
	private static final String CONFIRM_PASSWORD = "CONFIRM_PASSWORD";
	
	

	public Database(Context context) 
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db)              
	{
		db.execSQL("drop table if exists "+TABLE_CONTACTS);
		// TODO Auto-generated method stub
		String sql = "CREATE TABLE " + TABLE_CONTACTS + "(" +DAS_ID  + " TEXT," + USERNAME+" TEXT,"+ PASSWORD +  " TEXT," + CONFIRM_PASSWORD + " TEXT"+")";
		db.execSQL(sql);
	}       

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		// TODO Auto-generated method stub
		db.execSQL("drop table if exists "+TABLE_CONTACTS);
		onCreate(db);

	}


	public void addEmployee(String das_id,String username,String password, String confirm_password)
	{
		SQLiteDatabase db= this.getWritableDatabase();
		
		ContentValues  values= new ContentValues();
		values.put(DAS_ID,das_id);
		values.put(USERNAME,username);
		values.put(PASSWORD,password);
		values.put(CONFIRM_PASSWORD,confirm_password);
		
		db.insert(TABLE_CONTACTS, null, values);

	}
	
	public Cursor getEmployee()
	{
		SQLiteDatabase db= this.getWritableDatabase();
		
		String sql = "SELECT * FROM "+TABLE_CONTACTS;
		Cursor cursor=db.rawQuery(sql, null);
		/*if(cursor.moveToFirst())
		{
			do
			{
				System.out.println(cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+" "+cursor.getString(4)+" "+cursor.getString(5)+" "+cursor.getString(6)+" "+cursor.getString(7)+" "+cursor.getString(8)+" "+cursor.getString(9));
			}while(cursor.moveToNext());
		}*/
		
		return cursor;
	}
	
	
	public Boolean check(String das_id,String password)
	{
		
		SQLiteDatabase db= this.getReadableDatabase();
		String sql = "SELECT * FROM "+ TABLE_CONTACTS;
		Cursor cursor=db.rawQuery(sql, null);
		cursor.moveToFirst();
		System.out.println(cursor.getString(1));
		do
		{
			if(cursor.getString(0).equalsIgnoreCase(das_id) && cursor.getString(1).equals(password))
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}while(cursor.moveToNext());
			
	}

}
