package com.peng.pqreader.bean;

public class BookTag {
	private String bookname;
	private int bufbegin;
	private int bufend;

	public BookTag() {
		super();
	}

	public BookTag(String bookname, int bufbegin, int bufend) {
		super();
		this.bookname = bookname;
		this.bufbegin = bufbegin;
		this.bufend = bufend;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getBufbegin() {
		return bufbegin;
	}

	public void setBufbegin(int bufbegin) {
		this.bufbegin = bufbegin;
	}

	public int getBufend() {
		return bufend;
	}

	public void setBufend(int bufend) {
		this.bufend = bufend;
	}

}
