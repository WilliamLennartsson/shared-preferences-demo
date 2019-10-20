package com.example.sharedpreferencesdemo;

public class Singleton {

    public static Singleton instance = new Singleton();

    public static Singleton getInstance(){ return instance; };
}
