package com.yidao.jdbc;

import com.hanks.test.TestLog;
import com.yidao.jdbc.uitls.HttpUtils;
import com.yidao.jdbc.uitls.Ulog;


public class Test {
    static int i=1;

    public static void foo(int t) {
        t=2;
    }

    public static void main(String[] strings) {
        long privus = System.currentTimeMillis();
        String message = HttpUtils.sendGetRequest("http://116.247.74.76:8682/api/AutoUpdate?id=00000000000001", null);
        Ulog.i(message);
        Ulog.i("网络请求所用时间:", (System.currentTimeMillis() - privus));
        TestLog.i("测试引入的module");

        foo(i);
        Ulog.i("i",i);
    }

}
