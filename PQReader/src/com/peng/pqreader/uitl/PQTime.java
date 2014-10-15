package com.peng.pqreader.uitl;

import java.text.SimpleDateFormat;
import java.util.Date;
import android.annotation.SuppressLint;
import android.text.format.Time;

public class PQTime {
	@SuppressLint("SimpleDateFormat")
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String readtime = sdf.format(new Date());
		return readtime;
	}
	public static String getTimeforday() {
		Time time = new Time();
		time.setToNow();
		int minute = time.minute;
		int hour = time.hour;
		String readtime = hour + ": "+ minute ;
		return readtime;
	}
}
