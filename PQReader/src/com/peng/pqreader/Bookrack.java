package com.peng.pqreader;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.peng.pqreader.DB.BookDAO;
import com.peng.pqreader.bean.Book;
import com.zeng.reader.MainReader;

public class Bookrack extends Activity {

	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bookrack);
		listView = (ListView) findViewById(R.id.lv_content);
	}

	/**
	 * 更新listview
	 *
	 */
	@Override
	protected void onResume() {
		setAdapter();
		listView.setOnItemClickListener(listener);
		super.onResume();
	}
	/**
	 * 给listview中的条目添加响应事件
	 */
	private OnItemClickListener listener=new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// 这里的view是我们在list.xml中定义的LinearLayout对象.
			TextView textView=(TextView) view.findViewById(R.id.tv_bookname);
			String bookname=textView.getText().toString().trim();
			Intent intent=new Intent(Bookrack.this,MainReader.class);
			intent.putExtra("bookname", bookname);
			startActivity(intent);
			//startActivityForResult(intent, 0);
		}
	
	};
	/**
	 * 给listview添加适配器
	 */
	public void setAdapter() {
		List<Map<String, Object>> data = getData();
		listView.setAdapter(new SimpleAdapter(this, data, R.layout.book_item,
				new String[] { "bookname", "booklength", "readlength",
						"bookimg" },
				new int[] { R.id.tv_bookname, R.id.tv_booklength,
						R.id.tv_readlength, R.id.iv_bookimg }));
	}

	/**
	 * 
	 * @returnList<Map<String, Object>>数据
	 */
	public List<Map<String, Object>> getData() {
		BookDAO dao = new BookDAO(this);
		List<Book> books = dao.findAll();
		List<Map<String, Object>> data = new ArrayList<>();
		for (Book book : books) {
			DecimalFormat df = new DecimalFormat("#0.0");
			
			Map<String, Object> map = new HashMap<>();
			map.put("bookname", book.getBookname());
			float length=book.getBooklength();
			String strlength = "";
			if ((length/1024)>1) {
				strlength=df.format(length/1024)+"k";
				length=length/1024;
				if (length/1024>1) {
					strlength=df.format(length/1024)+"M";
				}
			}
			map.put("booklength", strlength);
			DecimalFormat df1 = new DecimalFormat("#0.0");
			String strPercent = df1.format(book.getReadlength()*100f/ book.getBooklength()) + "%";
			map.put("readlength","已阅读:" + strPercent);
			Random random = new Random();
			int id = random.nextInt(10);
			switch (id) {
			case 0:
				map.put("bookimg", R.drawable.cover_bg);
				break;
			case 1:
				map.put("bookimg", R.drawable.cover_bg1);
				break;
			case 2:
				map.put("bookimg", R.drawable.cover_bg2);
				break;
			case 3:
				map.put("bookimg", R.drawable.cover_bg3);
				break;
			case 4:
				map.put("bookimg", R.drawable.cover_bg4);
				break;
			case 5:
				map.put("bookimg", R.drawable.cover_bg5);
				break;
			case 6:
				map.put("bookimg", R.drawable.cover_bg6);
				break;
			case 7:
				map.put("bookimg", R.drawable.cover_bg7);
				break;
			case 8:
				map.put("bookimg", R.drawable.cover_bg8);
				break;
			case 9:
				map.put("bookimg", R.drawable.cover_bg9);
				break;
			}
			data.add(map);
		}
		return data;
	}
	/**
	 * 菜单
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}
	/**
	 * 给菜单的条目添加响应事件
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_settings:

			break;
		case R.id.action_bookinput:
			Intent intent=new Intent(this, Bookinput.class);
			startActivity(intent);
			break;
		case R.id.action_exit:

			break;
		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}
}
