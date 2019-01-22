package com.yidao.jdbc.designPattern;

import com.yidao.jdbc.uitls.Ulog;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式
 * Created by User on 2017/11/22.
 */
public class main {
    public static void main(String[] args) {
        Person person=new Person();
        Observer observer=new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                Ulog.i("tttt"+arg);
            }
        };
        person.addObserver(observer);
        person.setName("klsdjaflkdas");
        person.deleteObserver(observer);
    }
}
