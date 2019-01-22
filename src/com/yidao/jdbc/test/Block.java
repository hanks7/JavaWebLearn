package com.yidao.jdbc.test;

public class Block {

    // 静态块
    static {
        System.out.println("静态代码块1");
    }

    // 静态块
    static {
        System.out.println("静态代码块2");
    }

    // 非静态块
    {
        System.out.println("非静态代码块1");
    }

    // 非静态块
    {
        System.out.println("非静态代码块2");
    }

    public Block() {
        System.out.println("无参构造函数");
    }

    public static void main(String[] args) {
        new Block();
    }
  /*
    静态代码块1
    静态代码块2
    非静态代码块1
    非静态代码块2
    无参构造函数
  * */

}

