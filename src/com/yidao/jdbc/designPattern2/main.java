package com.yidao.jdbc.designPattern2;

import com.yidao.jdbc.uitls.Ulog;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式
 * Created by User on 2017/11/22.
 */
public class main {

    public static final int inputNum = 2019;
    //总行数
    private static int totalNum;

    public static void main(String[] args) {

//        ArrayList<Integer> list = getIntegers();
//
//        int t = 1;
//        int m = 0;
//        aaa(list, t, m);
//        bbb(list, t, m);

        aaaa();
    }

    //将所有的数添加到集合中
    private static ArrayList<Integer> getIntegers() {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= inputNum; i = i + 2) {
            list.add(i);
        }
        return list;
    }

    //根据既定的值找出总共多少行
    private static void aaa(ArrayList<Integer> list, int t, int m) {
        for (int i = 0; i < list.size(); i++) {
            int n = i + 1;
            if (list.get(i) == inputNum) {
                log("行号:" + t);
                totalNum = t;
            }
            if (n == 2 * t - 1 + m) {
                t++;
                m = n;
            }

        }
    }

    //显示所有数
    private static void bbb(ArrayList<Integer> list, int t, int m) {

        addRowSpace(totalNum - t);
        for (int i = 0; i < list.size(); i++) {
            int n = i + 1;

            show(list.get(i));
            if (n == 2 * t - 1 + m) {

                t++;
                m = n;
                System.out.print("\n");
                addRowSpace(totalNum - t);
            }


        }
    }

    //给每一行添加空格
    public static void addRowSpace(int j) {
        String space = "";
        for (int i = 0; i < j; i++) {
            space = space + "      ";
        }
        System.out.print(space);
    }

    //打印日志
    private static void log(Object message) {
        System.out.println(message + "");
    }

    //给每个数添加空格
    private static void show(int i) {
        if (i < 10) {
            System.out.print(" " + i + "  " + "  ");
            return;
        }
        if (i < 100) {
            System.out.print(" " + i + " " + "  ");
            return;
        }
        if (i < 1000) {
            System.out.print(" " + i + "  ");
            return;
        }
        if (i < 10000) {
            System.out.print(i + "  ");
            return;
        }
    }

    //之前练习设计模式
    private static void aaaa() {
        Person person = new Person();
        Observer observer = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                Ulog.i("tttt" + arg);
            }
        };
        person.addObserver(observer);
        person.setName("klsdjaflkdas");
        person.deleteObserver(observer);
    }

}
