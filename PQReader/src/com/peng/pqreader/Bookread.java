package com.peng.pqreader;

import java.io.BufferedReader;
import java.io.FileReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.peng.pqreader.DB.BookDAO;
import com.peng.pqreader.bean.Book;

public class Bookread extends Activity {
	
	private Book book;
	private BookDAO dao;
	private TextView tv_book_content;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.read_book);
		Intent intent=getIntent();
		Bundle bundle=intent.getExtras();
		String name=bundle.getString("bookname");
		dao=new BookDAO(this);
		book=dao.find(name);
		tv_book_content=(TextView) findViewById(R.id.tv_book_content);
		setBookcontent();
	}
	
	
	public void setBookcontent(){
		//File file=new File(book.getBookpath());
		try {
			/*FileInputStream fis=new FileInputStream(file);
			int size=fis.available();
			byte[] buffer=new byte[size];
			fis.read(buffer);
			fis.close();
			String text=new String(buffer,"UTF-8");
			tv_book_content.setText(text);*/
			FileReader in=new FileReader(book.getBookpath());
			BufferedReader reader=new BufferedReader(in);
			StringBuffer buffer=new StringBuffer();
			String str;
			while((str=reader.readLine())!=null){
				buffer.append(str+"\n");
			}
			System.out.println(buffer);
			tv_book_content.setText(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
