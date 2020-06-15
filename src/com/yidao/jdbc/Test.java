package com.yidao.jdbc;

import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.jsp.jstl.core.Config;


class A {

    static {
        //1
        System.out.print("1");
    }

    public A() {
        //3 5
        System.out.print("2");
    }
}

class B extends A {

    static {

        //2
        System.out.print("a");
    }

    public B() {
        //4 6
        System.out.print("b");
    }
}

public class Test {

    public static void main(String[] args) {
        A ab = new B();//1a2b
        ab = new B();//2b

    }

}




