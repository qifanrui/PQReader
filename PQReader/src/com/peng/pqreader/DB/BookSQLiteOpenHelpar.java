package com.peng.pqreader.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookSQLiteOpenHelpar extends SQLiteOpenHelper {

	public BookSQLiteOpenHelpar(Context context) {
		super(context, "books.db", null, 2);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE book(bookname varchar(20) primary key,author varchar(20), booklength integer,readlength integer,state integer default 0,readtime varchar(20),bookpath varchar(50))";
		db.execSQL(sql);
		String sql1 = "CREATE TABLE bookTag(bookname varchar(20) primary key,bufbegin integer,bufend integer,charsetname varchar(20))";
		db.execSQL(sql1);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//db.execSQL("alter table bookTag add charsetname varchar(20)");
	}

}
