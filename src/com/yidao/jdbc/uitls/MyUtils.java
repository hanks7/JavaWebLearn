package com.yidao.jdbc.uitls;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.yidao.jdbc.uitls.UtilGson.*;


public class MyUtils {
	
	/**
	 * 把ResultSet数据转换成list数据
	 * 
	 * @return List
	 * @throws java.sql.SQLException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List resultSetToList(ResultSet rs)
			throws java.sql.SQLException {
		if (rs == null)
			return Collections.EMPTY_LIST;
		ResultSetMetaData md = rs.getMetaData(); // 得到结果�?rs)的结构信息，比如字段数�?字段名等
		int columnCount = md.getColumnCount(); // 返回�?ResultSet 对象中的列数
		List list = new ArrayList();
		Map rowData = new HashMap();
		while (rs.next()) {
			rowData = new HashMap(columnCount);
			for (int i = 1; i <= columnCount; i++) {
				rowData.put(md.getColumnName(i), rs.getObject(i));
			}
			list.add(rowData);
		}
		// System.out.println("list:" + list.toString());
		return list;
	}

	/**
	 * 获得当前Tomcat的ip
	 * 
	 * @return http://192.168.40.36
	 */
	public static String getLocalHostlIp() {
		try {
			Inet4Address ipadress = (Inet4Address) Inet4Address.getLocalHost();
			System.out.println(ipadress.getHostAddress());
			return "http://" + ipadress.getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "http://127.0.0.1";
		}

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

	/**
	 * 错误
	 * 
	 * @param response
	 * @param msg
	 *            {"code":"200","msg":"xxxxxxxxxxx","data":""}
	 */
	public static void errorMessage(HttpServletResponse response, int code,
			String msg) {
		MessageDataBean messageBean = new MessageDataBean();
		messageBean.setContent(code, msg, "");
		String responseText = GsonToJson(messageBean);
		ResponseUtils.renderJson(response, responseText);
	}

	/**
	 * 正确
	 * 
	 * @param response
	 * @param data
	 *            {"code":"200","msg":"xxxxxxxxxxx","data":""}
	 */
	public static void trueMessage(HttpServletResponse response, Object data) {
		MessageDataBean messageBean = new MessageDataBean();
		messageBean.setContent(0, "success", data);
		String responseText = GsonToJson(messageBean);
		ResponseUtils.renderJson(response, responseText);
	}

	/**
	 * 带返回值的
	 * 
	 * @param request
	 * @param keyWord
	 *            键
	 * @param defautWord
	 *            错误值
	 * @return
	 */
	public static Object getParameter(HttpServletRequest request,
			String keyWord, Object defautWord) {
		String values = "";
		try {
			values = request.getParameter(keyWord);
			Log(keyWord + "--1--ERROR----");
		} catch (Exception e) {
			Log(keyWord + "--2--ERROR----");
			values = (String) defautWord;
			e.printStackTrace();
		}
		Log(keyWord + "--3--ERROR----");
		return values;
	}

	/**
	 * 带返回值的
	 * 
	 * @param request
	 * @param keyWord
	 *            键
	 * @param keyWord
	 *            错误值
	 * @return
	 */
	public static String getParameterOrEmpty(HttpServletRequest request,
			String keyWord) {
		try {
			String values = request.getParameter(keyWord);
			if (values == null) {
				values = "";
			}
			return values;
		} catch (Exception e) {
			// TODO: handle exception
			Log(keyWord + "----Exception----");
			return "";
		}
	}

	/**
	 * 解析返回参数或0
	 * 
	 * @param request
	 * @param keyWord
	 *            键
	 * @return
	 */
	public static int getIntOrZero(HttpServletRequest request, String keyWord) {
		try {
			int values = Integer.parseInt(request.getParameter(keyWord));
			return values;
		} catch (Exception e) {
			// TODO: handle exception
			Log(keyWord + "----Exception----");
			return 0;
		}
	}

	/**
	 * 解析返回参数或默认值
	 * 
	 * @param request
	 * @param keyWord
	 * @param defaut
	 * @return
	 */
	public static int getIntOrDefaut(HttpServletRequest request,
			String keyWord, int defaut) {
		try {
			int values = Integer.parseInt(request.getParameter(keyWord));
			return values;
		} catch (Exception e) {
			Log(keyWord + "----Exception----");
			return defaut;
		}
	}

	/**
	 * 带返回值的
	 * 
	 * @param obj
	 * @return
	 */
	public static String removeNull(Object obj) {
		if (obj == null) {
			return "";
		} else {
			return obj.toString();
		}
	}

	/**
	 * 字段是否为空
	 * @param url
	 * @return
	 */
	public static boolean isEmpty(String url) {
		if (url == null || url.length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 打印控制台日志
	 * 
	 * @param message
	 */
	public static void Log(Object message) {
		System.out.println("time："+getCurrentTime()+"  log=" + message + "");
	}


}
