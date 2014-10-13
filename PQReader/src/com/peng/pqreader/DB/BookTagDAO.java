package com.peng.pqreader.DB;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.peng.pqreader.bean.BookTag;



public class BookTagDAO {

	private BookSQLiteOpenHelpar helpar;
	public BookTagDAO(Context context){
		helpar=new BookSQLiteOpenHelpar(context);
	}
	
	public long add(BookTag book) {
		SQLiteDatabase db = helpar.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("bookname", book.getBookname());
		values.put("bufbegin", book.getBufbegin());
		values.put("bufend", book.getBufend());
		values.put("charsetname", book.getCharsetname());
		long rowid = db.insert("bookTag", null, values);
		return rowid;
	}
	public BookTag find(String name){
		SQLiteDatabase db=helpar.getReadableDatabase();
		Cursor cursor=db.query("bookTag", null, "bookname=?", new String[]{name}, null, null, null);
		if(cursor.moveToNext()){
			String bookname = cursor.getString(0);
			int bufbegin = cursor.getInt(1);
			int bufend = cursor.getInt(2);
			String charsetname=cursor.getString(3);
			BookTag book = new BookTag(bookname,bufbegin,bufend,charsetname);
			cursor.close();
			db.close();
			return book;
		}
		return null;
	}
	
	public void update(String name, int bufbegin, int bufend) {
		SQLiteDatabase db = helpar.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("bufbegin", bufbegin);
		values.put("bufend", bufend);
		db.update("bookTag", values, "bookname=?", new String[] { name });
		db.close();
	}
	public void updatecharsetname(String name, String charsetname) {
		SQLiteDatabase db = helpar.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("charsetname", charsetname);
		db.update("bookTag", values, "bookname=?", new String[] { name });
		db.close();
	}
	public int delete(String name) {
		SQLiteDatabase db = helpar.getWritableDatabase();
		int id = db.delete("bookTag", "bookname=?", new String[] { name });
		db.close();
		return id;
	}
}
