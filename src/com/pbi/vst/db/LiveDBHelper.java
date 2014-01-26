package com.pbi.vst.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class LiveDBHelper extends SQLiteOpenHelper {

	private static LiveDBHelper mInstance = null;

	public LiveDBHelper(Context context) {
		super(context, "live.db", null, 1);
		// TODO Auto-generated constructor stub
	}

	public static LiveDBHelper getInstance(Context paramContext) {
		if(mInstance == null){
			mInstance  = new LiveDBHelper(paramContext);
		}
		
		return mInstance;
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
