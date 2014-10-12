package com.peng.pqreader.uitl;

import android.text.format.Time;

public class PQTime {
	public static String getTime() {
		Time time = new Time("GMT+8");
		time.setToNow();
		int year = time.year;
		int month = time.month;
		int day = time.monthDay;
		int minute = time.minute;
		int hour = time.hour;
		int sec = time.second;
		String readtime = year + "- " + month + "-" + day + " " + hour + ": "
				+ minute + ": " + sec;
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
