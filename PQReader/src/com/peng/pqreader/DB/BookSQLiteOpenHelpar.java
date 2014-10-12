package com.peng.pqreader.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookSQLiteOpenHelpar extends SQLiteOpenHelper {

	public BookSQLiteOpenHelpar(Context context) {
		super(context, "books.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE book(bookname varchar(20) primary key,author varchar(20), booklength integer,readlength integer,state integer default 0,readtime varchar(20),bookpath varchar(50))";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
