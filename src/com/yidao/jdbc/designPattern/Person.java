package com.yidao.jdbc.designPattern;

import java.util.Observable;

/**
 * 被观察者
 * Created by User on 2017/11/22.
 */
public class Person extends Observable {

    String name;

    public void setName(String name) {
        this.name = name;
        setChanged();
        notifyObservers("123123");
    }
}
