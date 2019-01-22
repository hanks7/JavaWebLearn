package com.yidao.jdbc.uitls;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ulog {


	/**
	 *  打印控制台日志
	 * @param tag
	 * @param obArray
	 */
	public static void i(String tag, Object... obArray) {
		String message="";
		for (Object o : obArray) {
			message=message+"==>"+o;
		}
		System.out.println("time:" + getCurrentTime() + "---" + tag
				+ message);
	}

	/**
	 * 打印控制台日志
	 *
	 * @param message
	 */
	public static void i( Object... message) {
		i("tag", message);
	}

	/**
	 * 返回当前时间
	 *
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getCurrentTime() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");//
		return dateFormat.format(now);
	}
}
