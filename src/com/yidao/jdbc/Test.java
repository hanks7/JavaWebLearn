package com.yidao.jdbc;

import com.yidao.jdbc.bean.BaseBean;
import com.yidao.jdbc.uitls.HttpUtils;
import com.yidao.jdbc.uitls.Ulog;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Test {

    public static void main(String[] strings) {
        long privus = System.currentTimeMillis();
        String message = HttpUtils.sendGetRequest("http://116.247.74.76:8682/api/AutoUpdate?id=00000000000001", null);
        Ulog.i(message);
        Ulog.i("网络请求所用时间:", (System.currentTimeMillis() - privus));
    }

}
