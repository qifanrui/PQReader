package com.peng.pqreader.bean;


/**
 * 
 * @author android 这是书的实例
 */
public class Book {
	private String bookname;// 书名
	private String author;// 作者
	private int booklength;// 书的总长度
	private int readlength;// 已阅读的长度
	private int state;//状态 0：正在阅读  1：已读完
	private String readtime;// 最后阅读时间
	private String bookpath;//书的存储路径
	/**
	 * 
	 * @param bookname书名
	 * @param author作者
	 * @param booklength书的总长度
	 * @param readlength已阅读的长度
	 * @param state 状态 0：正在阅读  1：已读完
	 * @param readtime最后阅读时间
	 */
	public Book(String bookname, String author, int booklength, int readlength, int state,
			String readtime,String bookpath) {
		super();
		this.bookname = bookname;
		this.author = author;
		this.booklength = booklength;
		this.readlength = readlength;
		this.state=state;
		this.readtime = readtime;
		this.bookpath=bookpath;
	}
	
	
	public Book() {
		super();
	}


	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getBooklength() {
		return booklength;
	}

	public void setBooklength(int booklength) {
		this.booklength = booklength;
	}

	public int getReadlength() {
		return readlength;
	}

	public void setReadlength(int readlength) {
		this.readlength = readlength;
	}

	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public String getReadtime() {
		return readtime;
	}

	public void setReadtime(String readtime) {
		this.readtime = readtime;
	}


	public String getBookpath() {
		return bookpath;
	}


	public void setBookpath(String bookpath) {
		this.bookpath = bookpath;
	}

}
