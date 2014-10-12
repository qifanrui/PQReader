package com.zeng.reader;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.util.Log;
import static com.zeng.reader.MarkManager.single;
public class XmlParser {
	public static void parseXml(String filepath)throws XmlPullParserException, IOException {
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		factory.setNamespaceAware(true);
		XmlPullParser m_Parser = factory.newPullParser();
		
		FileInputStream infile = new FileInputStream(filepath);
		BufferedReader reader = new BufferedReader(new InputStreamReader(infile));
		 m_Parser.setInput(reader);
		 single.removeAll();// 或许要这一句?
		 int eventType = 0; int count = 0;int index = -1;
		 eventType = m_Parser.getEventType();
		 int columnNumber = m_Parser.getColumnNumber();
		 Log.i("abc", columnNumber+"") ;
		 //
		 BookMark bm = null;
		 while(eventType != XmlPullParser.END_DOCUMENT){
			 if(eventType == XmlPullParser.START_DOCUMENT){
				 Log.i("abc", "Start doc");
			 }else if(eventType == XmlPullParser.START_TAG){
				 Log.i("abc", "start tag"+m_Parser.getName());
				 if(m_Parser.getName().equals("books") == true){
					 
				 }else if(m_Parser.getName().equals("book") == true){
					 bm = new BookMark();
					 if(m_Parser.getAttributeName(0).equals("name") == true){
						 bm.setBookName(m_Parser.getAttributeValue(0));
					 }
				 }else if(m_Parser.getName().equals("items") == true){
					 Items item = new Items();
					 count = m_Parser.getAttributeCount();
					 for(int i = 0;i <count;i++){
						 if(m_Parser.getAttributeName(i).equals("begin") == true){
							 item.setBegin(Long.valueOf(m_Parser.getAttributeValue(i)));
						 }else if(m_Parser.getAttributeName(i).equals("end") == true){
							 item.setEnd(Long.valueOf(m_Parser.getAttributeValue(i)));
						 }else if(m_Parser.getAttributeName(i).equals("content")== true){
							 item.setContent(m_Parser.getAttributeValue(i));
						 }else if(m_Parser.getAttributeName(i).equals("percent")){
							 item.setPercent(m_Parser.getAttributeValue(i));
						 }else if(m_Parser.getAttributeName(i).equals("time")){
							 item.setTime(m_Parser.getAttributeValue(i));
						 }
					 }
					 bm.setItem(item);
					 int isExist = single.isExist(bm.getBookName());
					 if(isExist<0)
					 single.add(bm);
					 else
					 single.set(isExist, bm);
				 }
			 }else if(eventType == XmlPullParser.END_TAG){
				 if(m_Parser.getName().equals("items")){
					 
				 }
			 }else if(eventType == XmlPullParser.TEXT){
				 
			 }
			 eventType = m_Parser.next();
		 }
	}
}
