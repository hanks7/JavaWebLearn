package com.yidao.jdbc.imooc.day6Register;

import com.yidao.jdbc.uitls.Ulog;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterTest {

    public static void main(String[] args) {
        StringBuilder content = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream("E:/doc_work/intellijIdea/JavaWebLearn/web/html/regular/cities.html");
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(isr);
            String lineText = "";
            while((lineText = bufferedReader.readLine()) != null) {//一行一行读到内存中
                content.append(lineText + "\n");
            }
            bufferedReader.close();
//            Ulog.i(content);

        } catch (Exception e) {
            e.printStackTrace();
        }
        test1(content);
        test2(content);

    }

    /**
     * 使用分组查询
     * @param content
     */
    private static void test2(StringBuilder content) {
        //1.创建正则表达式对象
        Pattern p = Pattern.compile("<li>([\\u4e00-\\u9fa5]{2,10})([a-zA-Z]+)</li>");
        //2.匹配正则表达式
        Matcher m = p.matcher(content);
        //3.查找匹配的结果
        while(m.find()) {
            String chs = m.group(1);
            String eng = m.group(2);
            Ulog.i(chs + "-" + eng);
        }
    }

    /**
     * 不使用分组查询
     * @param content
     */
    private static void test1(StringBuilder content) {
        //1.创建正则表达式对象
        Pattern p = Pattern.compile("<li>[\\u4e00-\\u9fa5]{2,10}[a-zA-Z]+</li>");
        //2.匹配正则表达式
        Matcher m = p.matcher(content);
        //3.查找匹配的结果 正则表达式使用了分组查询所以就会出现下面的group
        while(m.find()) {
			Ulog.i(m.group(0));
        }
    }
}
