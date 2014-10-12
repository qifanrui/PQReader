package com.peng.pqreader;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.peng.pqreader.DB.BookDAO;
import com.peng.pqreader.bean.Book;
import com.peng.pqreader.uitl.PQTime;

public class Bookinput extends Activity {
	private SeekBar sb_min;
	private TextView tv_min;
	private TextView tv_file_path;
	int minsize;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.book_input);
		tv_min = (TextView) findViewById(R.id.tv_min);
		sb_min = (SeekBar) findViewById(R.id.sb_min);
		sb_min.setOnSeekBarChangeListener(Mylistener);
		tv_file_path = (TextView) findViewById(R.id.tv_file_path);
		String path = Environment.getExternalStorageDirectory().toString();
		tv_file_path.setText(path);
	}

	private SeekBar.OnSeekBarChangeListener Mylistener = new OnSeekBarChangeListener() {

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {

		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {

		}

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			tv_min.setText("最小书籍文件大小：" + progress + "k");
			minsize = progress;
		}
	};

	public void input(View view) {
		File root = new File(tv_file_path.getText().toString().trim());
		getAllFiles(root);
		this.finish();
	}

	public void mybook(View view) {

	}

	public void getAllFiles(File root) {
		File files[] = root.listFiles();
		if (files != null)
			for (File f : files) {
				if (f.isDirectory()) {
					getAllFiles(f);
				} else {
					int size = (int) (f.length() / 1024);
					if (size > minsize) {
						String path = f.toString();
						String name = path.substring(path.lastIndexOf("/") + 1,
								path.length());
						if (name.contains(".txt")) {
							BookDAO dao = new BookDAO(this);
							if (dao.find(name) == null) {
								String time = PQTime.getTime();
								String strname=name.substring(0, name.lastIndexOf("."));
								Book book = new Book(strname, null,
										(int) f.length(), 0, 0, time,
										path);
								dao.add(book);
							}

						}
					}
				}
			}
	}

	
}
