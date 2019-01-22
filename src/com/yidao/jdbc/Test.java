package com.yidao.jdbc;

import com.yidao.jdbc.bean.BaseBean;
import com.yidao.jdbc.uitls.HttpUtils;
import com.yidao.jdbc.uitls.Ulog;
import com.yidao.jdbc.uitls.UtilGson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Test {
    public static class TTTT {
        String id = "00000000000001";
    }

    public static void main(String[] strings) {
//        BaseBean bean = new BaseBean();
//        bean.setMsg("");
//        getObjectSize(bean, "k");
//        Ulog.i("RegexUtils", RegexUtils.checkIpPort("http://172.255.0.1:7010"));


//        for (int t : get()
//                ) {
//            Ulog.i(t);
//        }


//        http://116.247.74.76:8682/api/AutoUpdate?id=00000000000001

       String message= HttpUtils.sendGetRequest("http://116.247.74.76:8682/api/AutoUpdate?id=00000000000001",null);
        Ulog.i(message);
    }

    public static ArrayList<Integer> get() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 2; i < 100; i++) {
            boolean boo = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    boo = false;
                    break;
                }
            }
            if (boo) {
                list.add(i);
            }

        }
        return list;
    }

    public static String getObjectSize(BaseBean bean, String unit) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(bean);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] bytes = byteArrayOutputStream.toByteArray();

        long len = bytes.length;
        String fileSize = "0";
        if ("B".equals(unit.toUpperCase())) {
            fileSize = fff((double) len) + "B";
        } else if ("K".equals(unit.toUpperCase())) {
            fileSize = fff((double) len / 1024) + "K";
        } else if ("M".equals(unit.toUpperCase())) {
            fileSize = fff((double) len / 1048576) + "M";
        } else if ("G".equals(unit.toUpperCase())) {
            fileSize = fff((double) len / 1073741824) + "G";
        }
        Ulog.i(fileSize);

        return fileSize;
    }

    private static double fff(double d) {
        d = (double) Math.round(d * 100) / 100;
        Ulog.i("fff", d);
        return d;
    }
}
