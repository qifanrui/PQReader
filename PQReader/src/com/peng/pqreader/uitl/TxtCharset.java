package com.peng.pqreader.uitl;

import java.nio.ByteBuffer;

public class TxtCharset {

	public static String getCharset(byte[] buf) {

		byte b0 = buf[0];
		byte b1 = buf[1];
		byte b3 = buf[3];
		byte b6 = buf[6];
		byte b9 = buf[9];

		if (b0 == -1 && b1 == -2) {
			return "UTF-16LE";
		} else if (b0 == -2 && b1 == -1) {
			return "UTF-16BE";
		} else {
			if (b3 >= -32 && b6 >= -32 && b9 >= -32) {
				return "utf-8";
			} else {
				return "gbk";
			}
		}
	}

	public static String getCharset(ByteBuffer buffer) {
		byte[] buf = new byte[10];
		for (int i = 0; i < 10; i++) {
			buf[i] = buffer.get(i);
		}
		byte b0 = buf[0];
		byte b1 = buf[1];
		byte b3 = buf[3];
		byte b6 = buf[6];
		byte b9 = buf[9];

		if (b0 == -1 && b1 == -2) {
			return "UTF-16LE";
		} else if (b0 == -2 && b1 == -1) {
			return "UTF-16BE";
		} else {
			if (b3 >= -32 && b6 >= -32 && b9 >= -32) {
				return "utf-8";
			} else {
				return "gbk";
			}
		}
	}
}
