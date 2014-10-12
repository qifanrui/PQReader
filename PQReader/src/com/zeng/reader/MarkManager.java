package com.zeng.reader;

import java.util.ArrayList;
import java.util.List;

public class MarkManager {
	public static final MarkManager single = new MarkManager();
	private List<BookMark> list = new ArrayList<BookMark>();

	public MarkManager() {
		// TODO Auto-generated constructor stub
	}

	public void add(BookMark bm) {
		list.add(bm);
	}

	public BookMark get(int position) {
		return list.get(position);
	}

	public int count() {
		return list.size();
	}

	public void set(int index, BookMark bm) {
		list.set(index, bm);
	}

	// 测试使用，
	public void removeAll() {
		list.clear();
	}

	public List<BookMark> getList() {
		return list;
	}

	/**
	 * 
	 * @param name
	 * @return 存在相同名字的则 返回该位置，否则 -1;
	 */
	public int isExist(String name) {
		for (int i = 0; i < single.count(); i++) {
			BookMark bm = single.get(i);
			String str = bm.getBookName();
			if (str.equals(name))
				return i;
		}
		return -1;
	}
}

class BookMark {
	String bookName;
	List<Items> list;

	public BookMark() {
		// TODO Auto-generated constructor stub
		list = new ArrayList<Items>();
	}

	public BookMark(String bookName, Items item) {
		list = new ArrayList<Items>();
		this.bookName = bookName;
		list.add(item);
	}

	public BookMark(String bookName, List<Items> items) {
		// TODO Auto-generated constructor stub
	}

	public void setItem(Items item) {
		list.add(item);
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public List<Items> getList() {
		return list;
	}

	public void setList(List<Items> list) {
		this.list = list;
	}
}

class Items {
	private long begin;
	private long end;
	private String content;
	private String percent;
	private String time;

	public Items() {
		// TODO Auto-generated constructor stub
	}

	public Items(long begin, long end, String content) {
		// TODO Auto-generated constructor stub
		this.begin = begin;
		this.end = end;
		this.content = content;
	}

	public Items(long begin, long end, String content, String percent,
			String time) {
		// TODO Auto-generated constructor stub
		this.begin = begin;
		this.end = end;
		this.content = content;
		this.time = time;
		this.percent = percent;
	}

	public long getBegin() {
		return begin;
	}

	public void setBegin(long begin) {
		this.begin = begin;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
